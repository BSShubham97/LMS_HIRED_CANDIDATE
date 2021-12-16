package com.bridgelabz.lmscandidate.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.lmscandidate.model.HiredCandidate;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "FirstName", "Email", "HiredCity", "Degree", "HiredLab", "Location" };
	static String SHEET = "HiredCandidateData";

	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<HiredCandidate> excelToLMSCandidate(InputStream is) {
		try {
//			Workbook workbook = new XSSFWorkbook(is);
//
//			Sheet sheet = workbook.getSheet(SHEET);
		Workbook workbook = WorkbookFactory.create(is);
		Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<HiredCandidate> hiredCandidateList = new ArrayList<HiredCandidate>();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();
				HiredCandidate hiredCandidate = new HiredCandidate();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						hiredCandidate.setId((long) currentCell.getNumericCellValue());
						break;
					case 1:
						hiredCandidate.setFirstName(currentCell.getStringCellValue());
						break;
					case 2:
						hiredCandidate.setEmail(currentCell.getStringCellValue());
						break;
					case 3:
						hiredCandidate.setHiredCity(currentCell.getStringCellValue());
						break;
					case 4:
						hiredCandidate.setDegree(currentCell.getStringCellValue());
						break;
					case 5:
						hiredCandidate.setHiredLab(currentCell.getStringCellValue());
						break;
					case 6:
						hiredCandidate.setLocation(currentCell.getStringCellValue());
						break;

					default:
						break;
					}
					cellIdx++;
				}
				hiredCandidateList.add(hiredCandidate);
			}
			workbook.close();

			return hiredCandidateList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

}
