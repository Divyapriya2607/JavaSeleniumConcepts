package SELENIUMCONCEPTS;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverUsingActions {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in");
		WebElement element = driver.findElement(By.xpath("//div[@class='nav-line-1-container']/span"));
		System.out.println(element.getCssValue("font-size"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		//Screenshot();
	}

	public static void Screenshot() throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
	    File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
	    File DestFile=new File("D://test_eclipse_workspace/JavaSeleniumConcepts/screenshot1.png");
	    FileUtils.copyFile(SourceFile, DestFile);
				
	}

}
