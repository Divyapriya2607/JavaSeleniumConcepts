package SELENIUMCONCEPTS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxWithoutUsingSendKeys {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in");
		//WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('twotabsearchtextbox').value='mobile'");
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor) driver; jse.
		 * executeScript("document.evaluate(\"//input[@id='twotabsearchtextbox']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='mobile';"
		 * );
		 */

	}

}
