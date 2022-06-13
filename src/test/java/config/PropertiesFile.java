package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		getproperties();
	}
		
		
		public static void getproperties() throws IOException
		{
			Properties prop=new Properties();
			FileInputStream input=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			String user=prop.getProperty("email");
			System.out.println(user);
		}

	}


