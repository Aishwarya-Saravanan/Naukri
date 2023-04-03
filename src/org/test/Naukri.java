package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Naukri {
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Aishu\\eclipse-workspace\\SeleniumTest\\Browser\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://www.naukri.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement log = driver.findElement(By.xpath("//a[@id=\'login_Layer\']"));
		log.click();
		
//		Logging using Credentials
		WebElement email = driver.findElement(By.xpath("//input[@type='text']"));
		email.sendKeys("aishwaryasaro97@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("Lakshmi@333");
		
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		
		WebElement view = driver.findElement(By.xpath("//a[text()='Complete']"));
		view.click();
			
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		Thread.sleep(1000);
		WebElement upload = driver.findElement(By.xpath("//input[@id='attachCV']"));
		js.executeScript("arguments[0].click()",upload);
		
//		Uploading a file using Robot class
		Robot r= new Robot();
		r.delay(2000);
		
//		path to file in a clipboard
		StringSelection s= new StringSelection("C:\\Aishu res\\Aishu.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		WebElement sy = driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__bars']"));
		sy.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		logout.click();
		
		Thread.sleep(2000);
		
    	driver.quit();
		
		
	}

}
