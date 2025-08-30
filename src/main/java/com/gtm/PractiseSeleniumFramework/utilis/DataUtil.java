package com.gtm.PractiseSeleniumFramework.utilis;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.gtm.PractiseSeleniumFramework.TestSetup;

public class DataUtil extends TestSetup{

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName =m.getDeclaringClass().getSimpleName();//VerifyLoginTests
		//String sheetName = m.getName();//validateLoginWithValidCredentials

		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rowNum - 1][colNum];

		for (int rows = 2; rows <= rowNum; rows++) {

			for (int cols = 0; cols < colNum; cols++) {

				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);

			}

		}

		return data;

	}

}
