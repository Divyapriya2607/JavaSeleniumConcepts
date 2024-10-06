package SELENIUMCONCEPTS;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDownExampleUsingJavaScript {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		

	}

}
