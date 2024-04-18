package curs13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

//https://keybooks.ro/

public class WebElementExample {
	
	WebDriver browser;
	
	@BeforeClass
	public void setup() {
		
		browser = new ChromeDriver();
		browser.get("https://keybooks.ro/");
		browser.manage().window().maximize(); //maximizeaza window-ul 
		
	}
	@Test
	public void testWebElement() throws InterruptedException {
		
		browser.findElement(By.linkText("Login")).click();
		Thread.sleep(5000); //bad practice in a fi folosit ca metoda de a astepta element
	}
	
	
	@AfterClass
	public void tearDown() {
		
		browser.quit();
	}

}
