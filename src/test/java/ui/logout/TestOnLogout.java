package ui.logout;

import base.TestBase;
import data.TestData;
import io.qameta.allure.Step;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.AccountPage;
import ui.pages.LoginPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

@Listeners(TestListener.class)
public class TestOnLogout extends TestBase {

    private LoginPage loginPage;
    private AccountPage accountPage;

    @Test(description = "Check user can log out from system")
    public void checkUserLogout() {
        if (accountPage.userIsLoggedIn()) {
            accountPage.header.clickLogoutButton();
            assertTrue(loginPage.userOnLoginPage());
        } else {
            fail(TestData.LOGIN_ERROR);
        }
    }

    @BeforeClass
    @Step("Actions performed before tests")
    private void beforeTests() {
        loginPage = pageFactory.getLoginPage();
        accountPage = pageFactory.getAccountPage();
        loginPage.openLoginPage()
                .loginUser(TestData.TEST_EMAIL, TestData.TEST_PASSWORD);
    }
}
