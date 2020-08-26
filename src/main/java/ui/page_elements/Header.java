package ui.page_elements;

import browser.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;
    private Browser browser;

    public Header(Browser browser) {
        this.driver = browser.getDriver();
        this.browser = browser;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".logout")
    private WebElement logOutButton;

    @Step("Click logout button")
    public void clickLogoutButton() {
        logOutButton.click();
    }
}
