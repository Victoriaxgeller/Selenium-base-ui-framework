package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserSetup {

    protected WebDriver driver;

    public WebDriver getDriver(String  browser) {
        if (driver == null) {
             browser =  browser == null ? System.getProperty("browser") :  browser;
            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
            }
        }
        return driver;
    }

    public WebDriver getDriver() {
        return getDriver(null);
    }
}