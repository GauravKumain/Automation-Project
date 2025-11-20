package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.UserLogin;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    //public static Iterator<UserLogin> readCSVFile(String fileName) {
    public static Iterator<Object[]> readCSVFile(String fileName) {
        File csvFile = new File(System.getProperty("user.dir") + "//test-data//" +fileName);
        Reader reader = null;
        CSVReader csvReader = null;
        String[] line;
        List<Object[]> userList;
        UserLogin userData;
        try {
            reader = new FileReader(csvFile);
            csvReader = new CSVReader(reader);
            csvReader.readNext(); //-----> Read 1st Row immediately  index-0
            //csvReader.readNext(); //-----> Reads next Row  index-1
            //csvReader.readNext(); //-----> Reads next Row  index-2
            //line =csvReader.readNext(); //-----> Reads next Row  index-3   Also we storing it in line so its not lost. now it will return null if we go out of the rows.

            userList = new ArrayList<>();

            while((line = csvReader.readNext())!= null)
            {
                  userData = new UserLogin(line[0],line[1]);
                  userList.add(new Object[]{userData});
            }

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(userList.toString());
          return userList.iterator();
    }
}
