package co.up.tune.emp.attd.service;

import java.net.URLEncoder;
import java.util.List;

import javax.mail.Session;
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
		return dao.attdList();
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
		return dao.startAttd(vo);
	}

	@Override
	public int endAttd(AttdVO vo) {
		// 퇴근 시간 저장
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

}
