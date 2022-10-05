package co.up.tune.emp.attd.service;

import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.up.tune.emp.attd.mapper.AttdMapper;
import co.up.tune.emp.vo.AttdVO;

@Service
@Transactional
public class AttdServiceImpl implements AttdService{
	@Autowired
	private AttdMapper dao;
		
	@Override
	public void excel(AttdVO attdVO, HttpServletResponse response) throws Exception {
		List<AttdVO> list = dao.attdList();
		
		try {
			Workbook elist = new HSSFWorkbook();
			Sheet sheet = elist.createSheet("전체사원_근태");
			
			Row row = null;
			Cell cell =null;
			int rowNo = 0;
			
			//배경색 노란색
			CellStyle headStyle = elist.createCellStyle();
			headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
			headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			//헤더
			String[] headerArray = {"출근날짜","사번","이름","부서명","직위","출근시간","퇴근시간","근무시간","연장시간","상태"};
			row = sheet.createRow(rowNo++);
			for(int i = 0; i < headerArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(headStyle);
				cell.setCellValue(headerArray[i]);
			}
			
			for(AttdVO excelData : list) {
				row=sheet.createRow(rowNo++);
				cell = row.createCell(0);
				cell.setCellValue(excelData.getAtdcDt());
				
				cell = row.createCell(1);
				cell.setCellValue(excelData.getEmpNo());
				
				cell = row.createCell(2);
				cell.setCellValue(excelData.getNm());
				
				cell = row.createCell(3);
				cell.setCellValue(excelData.getDept());
				
				cell = row.createCell(4);
				cell.setCellValue(excelData.getPosition());
				
				cell = row.createCell(5);
				cell.setCellValue(excelData.getAtdcDttm());
				
				cell = row.createCell(6);
				cell.setCellValue(excelData.getAfwkDttm());
				
				cell = row.createCell(7);
				cell.setCellValue(excelData.getWktm());
				
				cell = row.createCell(8);
				cell.setCellValue(excelData.getOvtm());
				
				cell = row.createCell(9);
				cell.setCellValue(excelData.getSt());
				}
			
			//컨텐츠 타입 + 파일명
			response.setContentType("ms-vnd/excel");
			response.setHeader("Content-Disposition", "ATTachment; Filename="+URLEncoder.encode("출퇴근 현황","UTF-8")+".xls");
			
			//엑셀 출력
			elist.write(response.getOutputStream());
			elist.close();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AttdVO> attdList() {
		// 관리자 - 전체사원 근태리스트
		
		List<AttdVO> list =  dao.attdList();
		
		for( AttdVO vo :list) {
			// 퇴근한 사원들 중
			if (vo.getAfwkDttm() != null) {
				// 60분 이상 근무 했다면
				if(vo.getWktm() != null && vo.getWktm() > 59 ) {
					long wktmH = (long) Math.floor(vo.getWktm() / 60);
					vo.setWktmH(wktmH);
					
					// 60분 이상 초과 근무를 했다면
					if(vo.getOvtm() != null && vo.getOvtm() > 59) {
						// 소수점 버리기
						long ovtmH = (long) Math.floor(vo.getOvtm() / 60);
						vo.setOvtmH(ovtmH);
					}
				}
			}
		}
		return list;
	}

	@Override
	public List<AttdVO> attdGoodList() {
		// 관리자 - 전체사원 정상
		return dao.attdGoodList();
	}

	@Override
	public List<AttdVO> attdBadList() {
		// 관리자 - 전체사원 이상
		return dao.attdBadList();
	}

	@Override
	public List<AttdVO> myAttdList(AttdVO vo) {
		// TODO Auto-generated method stub
		return dao.myAttdList(vo);
	}

	@Override
	public List<AttdVO> attdListSearch(String key, String val) {
		// TODO Auto-generated method stub
		return dao.attdListSearch(key, val);
	}
 

	@Override
	public int startAttd(AttdVO vo) {
		// 출근 시간 저장
		
		// 오늘 날짜 구하기
		Date curDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YY/MM/dd");
		String today = dateFormat.format(curDate);
		
		Map<String, Object> checkMap = new HashMap<>();
		checkMap.put("empNo", vo.getEmpNo());
		checkMap.put("atdcDt", today);
		
		// 이미 출근했는지 여부 체크
		if(dao.alreadyAttd(checkMap) == 0) {
			dao.startAttd(vo);
		}
		return 0;
	}

	@Override
	public int endAttd(AttdVO vo) {
		// 일한시간은 출근시간+퇴근시간
		// 야근시간은 9시간 초과 시간
		// 상태는 근무시간 9시간 미만일 경우엔 '이상'으로, 9시간 이상일 경우엔 '정상'으로
		
		System.out.println("Attd ServiceImple endAttd vo :"+ vo);
		
		long commonWkTm = 540;
		
		// 1. 출근시간 조회
		Date atdcDttm = dao.selectAtdcTmByEmpNo(vo.getEmpNo());
		
		// 2. wktm 구하기 (현재시간 - 출근시간 = 근무시간 *분단위) 
		// 2-1 현시간 구하기
		Date curDate = new Date();
		
		// 2-2 포맷 정하기
		SimpleDateFormat dateFormat = new SimpleDateFormat("YY/MM/dd/ HH:mm:ss");
		
		// 날짜를 특정 포맷으로 변환시 무조건 에러 처리 해주어야하므로 try-catch 혹은 throw하여 에러를 보내주어야 함.
		// try-catch로 처리.
		try {
			atdcDttm = dateFormat.parse(dateFormat.format(atdcDttm));
			curDate = dateFormat.parse(dateFormat.format(curDate));
			System.out.println("format atdcDttm : " + atdcDttm + "curDate: " + curDate);
			
			// 2-3 차이 구하기
			long diff = curDate.getTime() - atdcDttm.getTime();
			System.out.println("atdcDttm : " + atdcDttm.getTime() + "curDate: " + curDate.getTime());
			
			long diffMinutes = diff / 60000 ;   
				
			System.out.println("diffMinutes : " + diffMinutes);
			
			// 2-4 set wktm 
			vo.setWktm(diffMinutes);
			if(diffMinutes> 59) {
				// 소수점 버리기
				long wktmH = (long) Math.floor(diffMinutes / 60);
				vo.setWktmH(wktmH);
			}
			
			
			// 3 st 구하기
			// 정산근무 혹은 초과근무라면
			if (diffMinutes >= commonWkTm ) {
				vo.setSt("정상");
				// 4 ovtm 구하기 (wktm-540)
				long ovtm = diffMinutes-commonWkTm;
				vo.setOvtm(ovtm);
				
				if(ovtm > 59) {
					// 소수점 버리기
					long ovtmH = (long) Math.floor(ovtm / 60);
					vo.setOvtmH(ovtmH);
				}
			
			// 근무시간 미달시
			} else {
				vo.setSt("비정상");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return dao.endAttd(vo);
	}

	@Override
	public List<AttdVO> wktmChart(AttdVO vo) {
		// 워크타임 차트
		return dao.wktmChart(vo);
	}

	@Override
	public int checkGood(AttdVO vo) {
		// 오늘 출근시작 몇명
		return dao.checkGood(vo);
	}

	@Override
	public int checkBad(AttdVO vo) {
		// 어제 이상 출근 몇명
		return dao.checkBad(vo);
	}

	@Override
	public AttdVO checkTime(AttdVO vo) {
		// 출근시간 띄우기
		return dao.checkTime(vo);
	}

	@Override
	public AttdVO checkBTime(AttdVO vo) {
		// TODO Auto-generated method stub
		return dao.checkBTime(vo);
	}


}
