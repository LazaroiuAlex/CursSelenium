package curs16;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class IsSelectedExample extends BaseTest {
	
	/*
	 * isDisplayed() --> verifica daca elementul este vizibil - aplicabil pe orice webelement
	 * 
	 * isSelected() --> verifica daca un element de tip checkbox sau radio button este selectat sau nu
	 * se aplica doar pe elemente care au atributul type = checkbox sau radio button
	 * 
	 * isEnabled() --> 
	 */
	
	@Test
	public void isSelected() {
		
		driver.findElement(By.cssSelector("ul[class^='menu_user_nav']>li>a")).click();
		
		WebElement rememberMeCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		System.out.println(rememberMeCheckBox.isSelected());
		assertFalse(rememberMeCheckBox.isSelected());
		
		rememberMeCheckBox.click();
		System.out.println(rememberMeCheckBox.isSelected());
		assertTrue(rememberMeCheckBox.isSelected());
		
		System.out.println("-------------------------------------------");
		
		//is selected este doar pentru radiobox sau checkbox de aceea mai jos avem false twice
		
		WebElement usernameField = driver.findElement(By.cssSelector("input[id='log']"));
		System.out.println(usernameField.isSelected());
		usernameField.click();
		System.out.println(usernameField.isSelected());
		
	}

}
