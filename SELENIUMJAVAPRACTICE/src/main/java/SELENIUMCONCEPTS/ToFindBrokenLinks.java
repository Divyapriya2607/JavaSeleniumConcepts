package SELENIUMCONCEPTS;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToFindBrokenLinks {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            
            if (url != null && !url.isEmpty()) {
                verify(url);
            } else {
                System.out.println("Empty or null URL");
            }
        }

        // Close the driver
        driver.quit();
    }

    public static void verify(String urlLink) {
        HttpURLConnection httpcon = null;
        try {
            URL link = new URL(urlLink);
            httpcon = (HttpURLConnection) link.openConnection();
            httpcon.setRequestMethod("GET");
            httpcon.connect();

            if (httpcon.getResponseCode() == 200) {
                System.out.println(urlLink + " is a valid link");
            } else {
                System.out.println(urlLink + " is a broken link");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (httpcon != null) {
                httpcon.disconnect();
            }
        }
    }
}
