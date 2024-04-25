package curs15;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Curs15Hw {
	
	WebDriver hwBrowser;
	
	@BeforeClass
	public void setup() {
		
		hwBrowser = new ChromeDriver();
		hwBrowser.get("https://keybooks.ro/contacts/");
		hwBrowser.manage().window().maximize(); //maximizeaza window-ul 
		
	}
	
	@Test
	public void writeInBox() throws InterruptedException {
		
		WebElement nameBox = hwBrowser.findElement(By.cssSelector("input[name='your-name']"));
		nameBox.sendKeys("John Doe");
		
		WebElement emailBox = hwBrowser.findElement(By.cssSelector("input[name='your-email']"));
		emailBox.sendKeys("JohnDoe@email.com");
		
		WebElement subjectBox = hwBrowser.findElement(By.cssSelector("input[name='your-s']"));
		subjectBox.sendKeys("Email sent for testing purpose");
		
		WebElement messageBox = hwBrowser.findElement(By.cssSelector("textarea[name='your-message']"));
		messageBox.sendKeys("This is an automated email, please do not respond");
		
		WebElement sendMessageBox = hwBrowser.findElement(By.cssSelector("input[value='Send Message']"));
		sendMessageBox.click();
		
		
		WebElement responseMessage = hwBrowser.findElement(By.cssSelector("div[aria-hidden='true']"));
		assertEquals(responseMessage.getText(), "Thank you for your message. It has been sent.");
		
	}
	
	@AfterClass
	public void tearDown() {
		
		hwBrowser.quit();

	}
	
}
