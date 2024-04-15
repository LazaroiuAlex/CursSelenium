package curs12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
	
	@Test
	public void testOpenBrowser() {
		
		WebDriver driver = new ChromeDriver(); // EdgeDriver sau FireFoxDriver in functie de browser-ul folosit
		driver.get("https://keybooks.ro/");
	}

}
