package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir")+"//TestData//userData.xlsx";
        ExcelUtility utility=new ExcelUtility(path);

        int rowCount = utility.getRowCount("Sheet1");
        int cellCount =utility.getCellCount("Sheet1",1);

        String apiData[][]=new String[rowCount][cellCount];

        for (int i=1;i<=rowCount;i++){
            for (int j=0;j<cellCount;j++){
                apiData[i-1][j]=utility.getCellData("Sheet1",i,j);
            }

        }
        return apiData;

    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir")+"//TestData//userData.xlsx";
        ExcelUtility utility=new ExcelUtility(path);

        int rowCount = utility.getRowCount("Sheet1");


        String apiUserNames[]=new String[rowCount];

        for (int i=1;i<=rowCount;i++){
            apiUserNames[i-1]=utility.getCellData("Sheet1",i,1);
        }
        return apiUserNames;

    }
}
