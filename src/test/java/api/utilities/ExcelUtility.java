package api.utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelUtility {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle cellStyle;
    String path;

    public ExcelUtility(String path){
        this.path=path;
    }
    public int getRowCount(String sheetName) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int count =sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return count;
    }

    public int getCellCount(String sheetName,int rowNum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rowNum);
        int count =row.getLastCellNum();
        workbook.close();
        fi.close();
        return count;
    }

    public String getCellData (String sheetName,int rowNum,int colNum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rowNum);
        cell=row.getCell(colNum);
        workbook.close();
        fi.close();
        return cell.toString();
    }


}
