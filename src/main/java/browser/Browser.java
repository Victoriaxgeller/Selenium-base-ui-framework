package browser;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@CommonsLog
public class Browser extends BrowserSetup {

    private static String BASE_URL = "http://automationpractice.com";

    public void startBrowser(WebDriver driver) {
        this.driver = driver;
        openUrl("/");
    }

    public void openUrl(String URL) {
        String absoluteUrl = BASE_URL + "/" + StringUtils.strip(URL, "/");
        driver.get(absoluteUrl);
        waitForUrl(driver, absoluteUrl);
        log.debug("OPENED URL: " + absoluteUrl);
    }

    public static void waitForUrl(WebDriver driver, String URL) {
        WebDriverWait wait = new WebDriverWait(driver, 15, 2);
        wait.until(ExpectedConditions.urlContains(URL));
    }

    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15, 2);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String getBaseUrl() {
        return BASE_URL;
    }
}
