package curs16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class CssSelectorExample extends BaseTest {
	
	@Test
	public void selectorTest() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// locator: first-of-type -> li[class*='sc_tabs_title']:first-of-type
		WebElement menuNewReleases = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:first-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:6px solid red;')", menuNewReleases);
		
		// nth-of-type: li[class*='sc_tabs_title']:nth-of-type(2)
		WebElement menuComingSoon = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(2)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: red; border:6px solid yellow;')", menuComingSoon);
		
		WebElement menuBestSellers = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(3)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: green; border:6px solid blue;')", menuBestSellers);
		
		// last-of-type: li[class*='sc_tabs_title']:first-of-type
		WebElement menuAwardWinners = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:last-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: purple; border:6px solid pink;')", menuAwardWinners);
		
	}

}
