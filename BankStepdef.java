package com.cg.trg;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BankStepdef {
  String Customername;
  String phoneNumber;
  String adhaarNumber;
 String  panNumber;
  boolean temp,temp1;
	
	@Given("^User Enters all his details in homepage$")
	public void user_Enters_all_his_details_in_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver.exe");
    	WebDriver wd=new ChromeDriver();
    	wd.get("file:///D:/SpringProjects/Selenium/customer.html");
    	
    	 Customername="Sandhya";
    	  phoneNumber="9951942754";
    	  adhaarNumber="7894561230";
    	  panNumber= "ES1234569";
    	 
    	  // TODO Auto-generated method stub
    	  		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kathirn\\Desktop\\chromedriver.exe");
    	      	WebDriver driver=new ChromeDriver();
    	      	
    	  /*		File pathToBinary = new File("C:/Program Files/Mozilla Firefox/firefox.exe");
    	  		FirefoxProfile firefoxProfile = new FirefoxProfile();
    	  		FirefoxBinary binary = new FirefoxBinary(pathToBinary);
    	  				
    	  		WebDriver driver = new FirefoxDriver(binary,firefoxProfile);
    	  		*/
    	  		//driver.get("file:///C:/Users/kathirn/Desktop/hotelBooking/hotelbooking.html");
    	  		driver.get("file:///D:/SpringProjects/Selenium/customer.html");
    	  		String parentWindow = driver.getWindowHandle().toString();
    	  		
    	  		driver.findElement(By.linkText("click")).click();
    	  		driver.switchTo().window("PopupWindow");
    	  	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	  		Thread.sleep(2000);
    	  		driver.close();
    	  		
    	  		driver.switchTo().window(parentWindow);
    	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	  		//driver.close(); 
    	   

	}

	@Then("^Validate all the details$")
	public void validate_all_the_details() throws Throwable {
		Pattern p = Pattern.compile("^[A-Z][a-z]+$");
		Matcher m = p.matcher(Customername);
		if (m.matches()) {
			temp = true;
		} else
			System.out.println("name is in incorrect format");
		Pattern p1 = Pattern.compile("[6-9][0-9]{9}");
		Matcher m1 = p1.matcher(phoneNumber);
		if (m1.matches()) {
			temp1 = true;
		} else
			System.out.println("phonenumber is in incorrect format");
	}

	@Then("^Send the valid details to the createaccount page$")
	public void send_the_valid_details_to_the_createaccount_page() throws Throwable {
		if ((temp && temp1)) {
			System.out.println("details are valid");WebDriver wd=new ChromeDriver();
	    	wd.get("file:///D:/SpringProjects/Selenium/customer.html");
			
			 WebElement element =wd.findElement(By.name("Customername"));
		        element.sendKeys(Customername);
		       wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		        WebElement a =wd.findElement(By.name("Phonenumber"));
		        a.sendKeys(phoneNumber);
		        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		        WebElement e =wd.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td/input"));
		        e.click();
		     
		       WebElement e0 =wd.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td/input[1]"));
		        e0.click();
		        WebElement e1 =wd.findElement(By.name("adhaarNumber"));
		        e1.sendKeys(adhaarNumber);
		        WebElement e2 =wd.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td/input[1]"));
		        e2.click();
		     
		        WebElement e4 =wd.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td/input[2]"));
		        e4.sendKeys(panNumber);
		        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		     
		        Select drpCity = new Select(wd.findElement(By.name("city")));
				drpCity.selectByVisibleText("Hyderabad");
				
		        WebElement e7 =wd.findElement(By.xpath("/html/body"));
		        e7.click();	
		        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		        wd.close();
	}
	}
	@Then("^Successfully added$")
	public void successfully_added() throws Throwable {
System.out.println("Details are successfully added");
	}


	
}
