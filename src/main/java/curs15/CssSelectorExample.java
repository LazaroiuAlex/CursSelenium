package curs15;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import seleniumutils.BaseTest;

public class CssSelectorExample extends BaseTest {
	
	//@Test
	public void sssExample1() {
		
		// shortcut -> .sc_title_underline
		// sau scris normal (see below)
		//h2[class = 'sc_title sc_title_underline sc_align_venter margin_bottom_tiny']
		
		//CssSelector pentru atribut class --> .
		//.menu_main_nav_area (varianta scurta) || nav[class='menu_main_nav_area'] (varianta normala)
		
		//CssSelector pentru atribut id --> #
		// #menu_user --> gaseste orice element care are id (#) cu valoarea "menu_user"
		// ul#menu_user --> gaseste doar elementele care au tag name 'ul' si id (#) cu valoarea 'menu_user'
		// ul[id='menu_user'] -- same result as previous(above)
		// ul --> tagname
		// id (#) --> atribut
		// menu_user --> valoare atribut
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement loginMenu = driver.findElement(By.cssSelector("#menu_user"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red;')", loginMenu);
		
		WebElement logoSlogan = driver.findElement(By.cssSelector("div[class='logo_slogan']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red;')", logoSlogan);

	}
	
	//@Test
	public void cssExample2() {
		
		WebElement loginPopUp = driver.findElement(By.cssSelector("a[href='#popup_login']"));
		loginPopUp.click();
		
		//input#log
		//input[id='log']
		//input[id='log'][name='log'][placeholder='Login or Email'] --> logincal AND (cand avem mai multe atribute)
		//input[id='password'],[name='pwd'] --> , means OR
		
		WebElement usernameField = driver.findElement(By.cssSelector("input[id='log'][name='log'][placeholder='Login or Email']"));
		usernameField.sendKeys("Test User");
		
		WebElement passwordField = driver.findElement(By.cssSelector("input[id='password'],[name='pwd']"));
		passwordField.sendKeys("Parola");
	}
	
	//@Test
	public void cssExample3() {
		
		//* --> contains (it's a wildcard)
		// a[href='the-long-road-to-the-deep-silence'] (normal)
		// a[href*='road'] (cu wildcard)
		
		WebElement book1 = driver.findElement(By.cssSelector("a[href*='road-to-the-deep']"));
		System.out.println(book1.getText());
		
		//~ --> contains word
		
		WebElement book2 = driver.findElement(By.cssSelector("h3[class~='sc_title_regular']"));
		System.out.println(book2.getText());
	
		
		// ^ -->starts with
		
		WebElement book3 = driver.findElement(By.cssSelector("a[href^='life']"));
		System.out.println(book3.getText());
		
		// $ --> ends with
		
		WebElement book4 = driver.findElement(By.cssSelector("a[href$='story']"));
		System.out.println(book4.getText());
	}
	
	@Test
	public void cssExample4() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//parent + child css --> semnul > este pentru direct child, daca punem " " (spatiu) se poate duce si pe nepot
		
		//"ul[role='tablist']>li"
		List<WebElement> menuEntries = driver.findElements(By.cssSelector("ul[role='tablist']>li"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid green;')", menuEntries.get(3));
		
		//"ul[role='tablist']>li[aria-selected='True']"
		
		WebElement selectMenuEntry = driver.findElement(By.cssSelector("ul[role='tablist']>li[aria-selected='true']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid blue;')", selectMenuEntry);
		
		//"ul[role='tablist']>li:not([aria-selected='true'])" --> :not este negatie, cauta toate elementele care nu au true
		List<WebElement> notSelectedMenuEntries = driver.findElements(By.cssSelector("ul[role='tablist']>li:not([aria-selected='true'])"));
		
		for(WebElement element : notSelectedMenuEntries) {
			
			Thread.sleep(3000);
			jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid orange;')", element);
			
		}
		
		// ul[role='tablist']>li[role='tab']>a[href*=#sc_tab]
		// ul -->parinte al lui li
		// li --> este copil al lui ul si parinte al lui a
		// a  --> este copil al lui li si nepot al lui ul
		// ca sa cobor de la ul direct la a (sarim peste li), nu mai fac referinte cu > ()direct child ci pun doar spatiu
		// ul[role='tablist'] a[href*=#sc_tab]
		
		
		List<WebElement> menuLinks = driver.findElements(By.cssSelector("ul[role='tablist'] a[href*='#sc_tab']"));
		
		for(WebElement element : menuLinks) {
			
			Thread.sleep(3000);
			jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid pink;')", element);
			
		}
		
	}

}
