import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelFile {
	String website;
	String contact;
	String name;

	public void readExcel() throws BiffException, IOException {
		boolean sent;
		String FilePath = "D:\\Test.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();
		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
		
		for (int row = 0; row < totalNoOfRows; row++) {
			for (int col = 0; col < totalNoOfCols; col++) {
				
				String d=sh.getCell(col, row).getContents() + "\t";
//					if(d=="contact"){
//						contact=col;
//					}
				if (col == 1 && row > 0) {
					website = sh.getCell(col, row).getContents();
					sent = FormFiller.selenium(website);
				
					writeToXL(sent);
				}
			}
			System.out.println();
		}
	}

	private void writeToXL(boolean sent) throws IOException {
		String contact="";
		System.out.print("sent" +" " +sent);
//		if(sent){
//			contact="SENT";
//		}
//		else contact="DID NOT SEND";
		
		System.out.println("contact" +" " +contact);
		
		FileInputStream fsIP= new FileInputStream(new File("D:\\Test.xls")); //Read the spreadsheet that needs to be updated
        
        HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
          
        HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
          
        HSSFCell cell = null; // declare a Cell object
        
        cell = worksheet.getRow(2).getCell((short) 1);   // Access the second cell in second row to update the value
          
        cell.setCellValue("OverRide Last Name"); 
		
	}

	public static void main(String args[]) throws BiffException, IOException {
		ReadExcelFile DT = new ReadExcelFile();
		DT.readExcel();
	}
}