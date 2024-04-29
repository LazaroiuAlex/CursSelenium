package curs17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class RelativeLocatorsExample extends BaseTest {
	
	/*
	 * toLeftOf
	 * toRightOf
	 * below
	 * above
	 * near
	 */
	
	@Test
	public void relativeLocatorsExample() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//toLeftOf (pretul lui the son)
		WebElement price10_20 = driver.findElement(RelativeLocator.with(By.cssSelector("h5[class*='sc_title']")).toLeftOf(By.cssSelector("a[href='life-in-the-garden']")));
		
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:6px solid red;')", price10_20);
		
		//tpRightOf
		WebElement price15_99 = driver.findElement(RelativeLocator.with(By.cssSelector("h5[class*='sc_title']")).toRightOf(By.cssSelector("a[href='life-in-the-garden']")));
		
		jse.executeScript("arguments[0].setAttribute('style', 'background: green; border:6px solid red;')", price15_99);
		
		//below
		
		WebElement price15_05 = driver.findElement(RelativeLocator.with(By.cssSelector("h5[class*='sc_title']")).below(By.cssSelector("div[class='wpb_wrapper']>p")));
		
		jse.executeScript("arguments[0].setAttribute('style', 'background: grey; border:6px solid black;')", price15_05);
	}

}
