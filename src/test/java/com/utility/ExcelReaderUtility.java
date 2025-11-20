package com.utility;


import com.ui.pojo.UserLogin;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<UserLogin> readExcelFile(String fileName) {


        File xlsxFile = new File(System.getProperty("user.dir") + "//test-data//" + fileName);
        XSSFWorkbook xssfWorkbook = null;
        List<UserLogin> userList;
        Row row;
        Cell emailAddressCell;
        Cell password;
        UserLogin user;
        Iterator<Row> rowIterator;
        XSSFSheet xssfSheet;

        try {
            xssfWorkbook = new XSSFWorkbook(xlsxFile);
            userList = new ArrayList<UserLogin>();
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");

            rowIterator = xssfSheet.iterator();
            rowIterator.next(); // to skip the header at Row 1  basically column Name

            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                emailAddressCell = row.getCell(0);
                password = row.getCell(1);

                user = new UserLogin(emailAddressCell.toString(), password.toString());
                userList.add(user);
                xssfWorkbook.close();

            }

        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();

    }


}
