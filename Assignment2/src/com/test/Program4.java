package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program4 {
    public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
		minimizeFlyOutwindow();
		addcustomer(); 
		deleteCustomer();
		logout();
		
	}
   
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "D:\\ECLIPSESAMPLE\\Web-Automation2\\Library\\driver\\chromedriver.exe");
		oBrowser =new  ChromeDriver();
		}catch(Exception e)
		{
		e.printStackTrace();	 
		}
		
	}
	private static void navigate()
	{
		try
		{
		oBrowser.get("http://localhost/login.do");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	private static void login() 
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(5000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static void minimizeFlyOutwindow()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void addcustomer() 
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div/div[2]")).click();
			oBrowser.findElement(By.xpath("//div [text()= New Customer")).click();
			oBrowser.findElement(By.name("Enter Customer Name")).sendKeys("Girish");
			oBrowser.findElement(By.xpath("//span[text()=Create Customer")).click();
			

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	private static void deleteCustomer()
	{
		try
		{
			oBrowser.findElement(By.xpath("//span[text()='Customer, Girish']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			Alert oAlert=oBrowser.switchTo().alert();
			String content=oAlert.getText();
			System.out.println(content);
			oAlert.accept();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static void logout()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
