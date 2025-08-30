package com.gtm.PractiseSeleniumFramework.utilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManger {
private static Properties prop;
private static FileInputStream fis;

public static Properties initilizePropertyManager()
{
	
	prop=new Properties();
	try {
		fis=new FileInputStream(Constants.PROPERTY_FILE);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
}


}
