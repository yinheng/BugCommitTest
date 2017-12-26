import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.CaseFormat;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {
	
	public List<ExcelHandler> excelReader(String path) {
	
		File file = new File(path);
		Workbook workbook = null;
		try {
		workbook = Workbook.getWorkbook(file);}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch (BiffException e) {
			e.printStackTrace();
		}		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();//sheet页有多少行
		int columns = sheet.getColumns();//sheet页有多少列
		System.out.println("sheet columns:" + sheet.getColumns()+ "rows :" + rows);
		List<ExcelHandler> bugList = new ArrayList<ExcelHandler>();
		
		for(int i = 1; i < rows; i++ ) {
			Cell[] cells = sheet.getRow(i);
			ExcelHandler excelHandler = new ExcelHandler();
		    for (int j = 0; j < cells.length; j ++){
		    	String vString = cells[j].getContents();
		    	String string0 = sheet.getCell(j, 0).getContents();//表头
		    	System.out.println(string0);
		    	switch (string0) {
				case ExcelHandler.USERNAME:
					excelHandler.setUserName(vString);
					break;
				case ExcelHandler.PASSWORD:
					excelHandler.setPassWord(vString);
					break;
				case ExcelHandler.TITLE:
					excelHandler.setTitle(vString);
					break;
				case ExcelHandler.PROJECT:
					excelHandler.setProject(vString);
					break;
				case ExcelHandler.DEVELOPER:
					excelHandler.setDeveloper(vString);
					break;
				case ExcelHandler.SUBPROJECT:
					excelHandler.setSubProject(vString);
					break;
				case ExcelHandler.PRODUCT:
					excelHandler.setProduct(vString);
					break;
				case ExcelHandler.FIRSTC:
					excelHandler.setFirstCharacteristic(vString);
					break;
				case ExcelHandler.SECONDC:
					excelHandler.setSecondCharacteristic(vString);
					break;
				case ExcelHandler.VERSION:
					excelHandler.setVersion(vString);
					break;
				case ExcelHandler.DESCRIBE:
					excelHandler.setDescribe(vString);
					break;
				case ExcelHandler.SERVERTITY:
					excelHandler.setServerity(vString);
					break;
				case ExcelHandler.TYPE:
					excelHandler.setType(vString);
					break;
				case ExcelHandler.REPRODUCIBILITY:
					excelHandler.setReproducibility(vString);
					break;
				case ExcelHandler.TESTCASE:
					excelHandler.setTestCase(vString);
					break;
				case ExcelHandler.TESTSOLUTION:
					excelHandler.setTestSolution(vString);
					break;
				case ExcelHandler.STAGE:
					excelHandler.setStage(vString);
					break;
					
				case ExcelHandler.ATTACHMENT:
					excelHandler.setAttachment(vString);
				}
		    			    		
		    		
       		}

		    System.out.println(excelHandler.toString());
		    bugList.add(excelHandler);
		}
	
		return bugList;

	}

}
