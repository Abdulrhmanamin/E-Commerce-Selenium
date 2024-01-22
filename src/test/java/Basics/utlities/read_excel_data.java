package Basics.utlities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class read_excel_data {

    public String[][] read_data() throws IOException, InvalidFormatException {
        File myfile =new File(".\\TestData\\testdata.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(myfile);
        XSSFSheet sheet = wb.getSheet("sheet1");
        int number_of_rows = sheet.getPhysicalNumberOfRows();
        int number_of_columns = sheet.getRow(0).getLastCellNum();
        String[][] myarray = new String[number_of_rows-1][number_of_columns];
        for (int i = 1; i <number_of_rows ; i++) {

            for (int j = 0; j <number_of_columns ; j++) {
                XSSFRow row=sheet.getRow(i);
                myarray[i-1][j]=row.getCell(j).getStringCellValue();

                
            }

        }

        return myarray;
    }
}
