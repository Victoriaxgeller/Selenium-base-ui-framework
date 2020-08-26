package ui.pages.factory;

import browser.Browser;
import ui.pages.AccountPage;
import ui.pages.LoginPage;

public class PageFactory {
    private Browser browser;

    public PageFactory(Browser browser) {
        this.browser = browser;
    }

    public AccountPage getAccountPage() {
        return new AccountPage(browser);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(browser);
    }
}