package base;

import browser.Browser;
import org.testng.annotations.*;
import ui.pages.factory.PageFactory;

public abstract class TestBase {

    protected Browser browser;
    protected PageFactory pageFactory;

    @Parameters("browser")
    @BeforeClass
    public void setUpBrowser(@Optional String browserName) {
        browser = new Browser();
        browser.startBrowser(browser.getDriver());
        pageFactory = new PageFactory(browser);
    }

    @AfterClass
    public void closeBrowser() {
        browser.closeBrowser();
    }
}
