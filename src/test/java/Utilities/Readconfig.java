package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;

	public Readconfig() {
		File src = new File("./configration/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("give some error" + e.getMessage());
		}

	}

	public String URL() {
		String url = pro.getProperty("url");
		return url;

	}

	public String username() {
		String username = pro.getProperty("username");
		return username;

	}

	public String password() {
		String password = pro.getProperty("password");
		return password;

	}

	
	public String Fname() {
		
		String Fname=pro.getProperty("FNAME");
		return Fname;
	}
public String Lname() {
		
		String Lname=pro.getProperty("LNAME");
		return Lname;
	}
public String Zipcode() {
	
	String Zip=pro.getProperty("Zip");
	return Zip;
}

}
