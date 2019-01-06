package tests;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.DataProviderPage;
import pageobjects.LoginPage;

@Epic("Login")
public class LoginTest2 extends BaseTest{

	@Link("http://www.bmc.com/")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void lg1_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "111");
		//Assert.fail();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void lg11_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "333");		
	}

	///////////////////////////////// Home Work 1 ///////////////////////////////////
	@Severity(SeverityLevel.CRITICAL)
	//Faker
	@Test(priority = 0, description = "Error Login")
	public void lg12_loginFacker_Failed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
	}

	@Severity(SeverityLevel.CRITICAL)
	//DataProvider
	@Test(dataProviderClass= DataProviderPage.class, dataProvider="loginFailData")
	public void lg13_loginDataProvider_Failed(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}

	@Severity(SeverityLevel.MINOR)
	//Parameters
	@Test @Parameters({"user1", "pass1"})
	public void lg14_loginPrameters_Failed(String user1, String pass1) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(user1, pass1);
	}

	@Severity(SeverityLevel.NORMAL)
	//DataProvider + Faker
	@Test(dataProviderClass= DataProviderPage.class, dataProvider="loginFaker")
	public void lg15_loginDataProviderFaker_Failed(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}

	///////////////////////////////// END Home Work 1 ///////////////////////////////////

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void lg2_loginSucced() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		Reporter.log("this is a simle testing log");
	}

}
