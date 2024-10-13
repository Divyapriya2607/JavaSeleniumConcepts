package SELENIUMCONCEPTS;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ToValidateTitleOfThePage {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title not matched");
		}
		//Assert.assertEquals(actualTitle,expectedTitle);

	}

}
