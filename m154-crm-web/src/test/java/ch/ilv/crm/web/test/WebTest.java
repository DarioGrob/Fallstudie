package ch.ilv.crm.web.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junit.framework.TestCase;

public class WebTest{

	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
		
		
		ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        
        driver = new ChromeDriver(options);
        
        driver.get("http://www.google.com");
        
        driver.manage().window().maximize();
        
        driver.get("http://localhost:7070");
	}
	
	
	@Test
	public void testCustomer() {
		String title = driver.getTitle();
		assertTrue(title.contains("CRM App"));
		
		
		
		
		WebElement forename = driver.findElement(By.xpath("/html/body/form[1]/input[1]"));
		forename.sendKeys("Dario");

		WebElement name = driver.findElement(By.xpath("/html/body/form[1]/input[2]"));
		name.sendKeys("Grob");

		WebElement button1 = driver.findElement(By.xpath("/html/body/form[1]/p/input"));
		
		button1.click();

		WebElement customername = driver.findElement(By.xpath("/html/body/span"));

		assertTrue(customername.getText().trim().contains("Dario Grob"));
		
		
		
		WebElement customerNumber = driver.findElement(By.xpath("/html/body/form[2]/input[1]"));
		customerNumber.sendKeys("0");
		
		WebElement button2 = driver.findElement(By.xpath("/html/body/form[2]/p/input"));
		button2.click();
		
		WebElement customerPrename = driver.findElement(By.xpath("/html/body/span[1]"));
		assertTrue(customerPrename.getText().trim().contains("Dario"));
		
		WebElement customerName = driver.findElement(By.xpath("/html/body/span[2]"));
		assertTrue(customerName.getText().trim().contains("Grob"));
	}
}
