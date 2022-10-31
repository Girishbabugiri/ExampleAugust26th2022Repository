package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {
    public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		 navigate();
		 login() ;
		 minimizeFlyOutwindow();
		 createuser();
		 Modifyuser();
		 deleteUser();
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
	
	private static void createuser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("firstName")).sendKeys("Venkatesh");
			oBrowser.findElement(By.name("middleName")).sendKeys("k");
			oBrowser.findElement(By.name("lastName")).sendKeys("Venky");
			oBrowser.findElement(By.name("email")).sendKeys("Venkatesh@gmail.com");
			oBrowser.findElement(By.name("username")).sendKeys("Venkateshvenkatt");
			oBrowser.findElement(By.name("password")).sendKeys("Venky@321");
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("Venky@321");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(2000);
			
			
		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	private static void Modifyuser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Venkatesh, Venky k.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("password")).sendKeys("Venkatesh@321");
			Thread.sleep(1000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("Venkatesh@321");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	
	private static void deleteUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//span[text()='User, demo A.']")).click();
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
	
	