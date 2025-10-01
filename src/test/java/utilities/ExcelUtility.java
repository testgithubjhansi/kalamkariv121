package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtility(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        fis.close();
    }

    public String getCellData(int rowNum, int colNum) {
        if (sheet.getRow(rowNum) == null) {
            return "";
        }
        if (sheet.getRow(rowNum).getCell(colNum) == null) {
            return "";
        }
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColumnCount(int rowNum) {
        if (sheet.getRow(rowNum) == null) {
            return 0;
        }
        return sheet.getRow(rowNum).getLastCellNum();
    }

    public void closeWorkbook() throws IOException {
        workbook.close();
    }

    public static void main(String[] args) {
        try {
            // Example usage:
            ExcelUtility excel = new ExcelUtility("path/to/your/TestData.xlsx", "Sheet1");

            // Get cell data
            String data = excel.getCellData(0, 0); // Row 0, Column 0
            System.out.println("Cell Data: " + data);

            // Get row count
            int rowCount = excel.getRowCount();
            System.out.println("Row Count: " + rowCount);

            // Get column count for a specific row
            int colCount = excel.getColumnCount(0); // For row 0
            System.out.println("Column Count for row 0: " + colCount);

            excel.closeWorkbook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}