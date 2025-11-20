package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.UserLogin;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "//test-data//loginData.json");
        FileReader fileReader = new FileReader(testDataFile);


        TestData data = gson.fromJson(fileReader, TestData.class);

        List<Object[]> dataToreturn = new ArrayList<Object[]>();

        for (UserLogin user : data.getData()) {
            dataToreturn.add(new Object[]{user});
        }

        return dataToreturn.iterator();


    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<Object[]> loginCSVDataProvider()
    {
        return CSVReaderUtility.readCSVFile("loginData.csv");

    }

    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<UserLogin> loginXLSXDataProvider()
    {
        return ExcelReaderUtility.readExcelFile("loginData.xlsx");
    }
}
