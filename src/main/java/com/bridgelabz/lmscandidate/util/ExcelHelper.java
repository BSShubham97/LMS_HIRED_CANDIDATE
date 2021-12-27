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
	static String[] HEADERs = {"Id","FirstName","MiddleName","LastName","Email","MobileNum","HiredCity","HiredDate","Degree","HiredLab","AttitudeRemark","CommunicationRemark","KnowledgeRemark","OnboardingStatus","Status","CreatorUser","JoinDate","Location","AggPercentage","CurrentPincode","PermanentPincode"};
//	static String SHEET = "HiredCandidateData";

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
						hiredCandidate.setMiddleName(currentCell.getStringCellValue());
						break;
					case 3:
						hiredCandidate.setLastName(currentCell.getStringCellValue());
						break;
					case 4:
						hiredCandidate.setEmail(currentCell.getStringCellValue());
						break;
					case 5:
						hiredCandidate.setMobileNum(currentCell.getStringCellValue());
						break;
					case 6:
						hiredCandidate.setHiredCity(currentCell.getStringCellValue());
						break;
					case 7:
						hiredCandidate.setHiredDate(currentCell.getStringCellValue());
						break;
					case 8:
						hiredCandidate.setDegree(currentCell.getStringCellValue());
						break;
					case 9:
						hiredCandidate.setHiredLab(currentCell.getStringCellValue());
						break;
					case 10:
						hiredCandidate.setAttitudeRemark(currentCell.getStringCellValue());
						break;
					case 11:
						hiredCandidate.setCommunication(currentCell.getStringCellValue());
						break;
					case 12:
						hiredCandidate.setKnowledgeRemark(currentCell.getStringCellValue());
						break;
					case 13:
						hiredCandidate.setOnboardingStatus(currentCell.getStringCellValue());
						break;
					case 14:
						hiredCandidate.setStatus(currentCell.getStringCellValue());
						break;
					case 15:
						hiredCandidate.setCreatorUser(currentCell.getStringCellValue());
						break;
					case 16:
						hiredCandidate.setJoinDate(currentCell.getStringCellValue());
						break;
					case 17:
						hiredCandidate.setLocation(currentCell.getStringCellValue());
						break;
					case 18:
						hiredCandidate.setAggregatePr((Double)currentCell.getNumericCellValue());
						break;
					case 19:
						hiredCandidate.setCurrentPincode((long) currentCell.getNumericCellValue());
						break;
					case 20:
						hiredCandidate.setPermanentPincode((long) currentCell.getNumericCellValue());
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
