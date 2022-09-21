package co.up.tune.emp.attd.web;


import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.up.tune.emp.attd.service.AttdService;
@Controller
public class AttdController {
	@Autowired
	AttdService dao;
	
	@GetMapping("/attdUpForm")
	public String attdUpForm() {
		return "emp/attd/attdUpForm";
	}
	
	@GetMapping("/attdList")
	public String attdList() {
		return "emp/attd/attdList";
	}
	
	
	/*@PostMapping("/excel")
	public void excel(@RequestParam String excelName, HttpServletResponse response, Model model) throws Exception {*/
		
	
		@GetMapping("/excel")
		public void excel(HttpServletResponse response) throws IOException {
		HSSFWorkbook eWorkBook = new HSSFWorkbook();
		HSSFSheet eSheet = null;
		HSSFRow eRow = null;
		HSSFCell eCell = null;
		
		//제목폰트
		HSSFFont font = eWorkBook.createFont();
		font.setFontHeightInPoints((short)9);
		font.setFontName("맑은고딕");
		
		//제목스타일에 폰트적용 정렬
		HSSFCellStyle styleHd = eWorkBook.createCellStyle();	//제목스타일
		styleHd.setFont(font);
		
		eSheet = eWorkBook.createSheet("첫번째 시트");	//시트 생성
		
		//1행
		eRow = eSheet.createRow(0);
		eRow.setHeight((short) 0x150);
		
		eCell = eRow.createCell(0);
		eCell.setCellValue("출근날짜");
		eCell.setCellStyle(styleHd);
		
		eCell = eRow.createCell(1);
		eCell.setCellValue("사번");
		eCell.setCellStyle(styleHd);
		
		eCell = eRow.createCell(2);
		eCell.setCellValue("이름");
		eCell.setCellStyle(styleHd);
		
		//2행
		eRow = eSheet.createRow(1);
		eRow.setHeight((short) 0x150);
		
		eCell = eRow.createCell(0);
		eCell.setCellValue("2022-09-21");
		eCell.setCellStyle(styleHd);
		
		eCell = eRow.createCell(1);
		eCell.setCellValue("656121");
		eCell.setCellStyle(styleHd);
		
		eCell = eRow.createCell(2);
		eCell.setCellValue("김자바");
		eCell.setCellStyle(styleHd);
		
		
		response.setContentType("Application.Msexcel");
		//response.setHeader("Content-Disposition", "ATTachment; Filename="+URLEncoder.encode("테스트","UTF-8")+".xls");
		//String encodeResult = URLEncoder.encode(String encodingString, String charsetName);
		response.setHeader("Content-Disposition", "ATTachment; Filename="+URLEncoder.encode("출퇴근 현황","UTF-8")+".xls");
		
		OutputStream fileOut = response.getOutputStream();
		eWorkBook.write(fileOut);
		fileOut.close();
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
}
