package junitcucumber;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class RespositoryParser {
	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile = new Properties();

	public void getProperty() throws IOException{
	Properties obj = new Properties();
	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/ObjectRepo.properties");
	obj.load(objfile);
	
	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
	}
}
