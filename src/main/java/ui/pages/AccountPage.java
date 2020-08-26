package ui.pages;

import browser.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.page_elements.Header;

public class AccountPage {

    public Header header;

    private final String LOGOUT_RELATIVE_URL = "account/ui.logout/";
    private final String PAGE_TITLE = "MY ACCOUNT";

    private Browser browser;

    public AccountPage(Browser browser) {
        this.browser = browser;
        PageFactory.initElements(browser.getDriver(), this);
        header = new Header(browser);
    }

    @FindBy(css = ".page-heading")
    private WebElement accountHeading;

    @Step("Check user is logged in")
    public boolean userIsLoggedIn() {
        browser.waitUntilVisible(accountHeading);
        return accountHeading.getText().equals(PAGE_TITLE);
    }

}
