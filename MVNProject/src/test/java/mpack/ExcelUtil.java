package mpack;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    public static String[] getCredentials(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1); // assuming data is in the second row
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();
        workbook.close();
        file.close();
        return new String[]{username, password};
    }
}
