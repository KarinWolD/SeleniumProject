package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.DataProviderPage;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void lg1_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "111");		
	}
	
	@Test
	public void lg11_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "333");
	}
	
	///////////////////////////////// Home Work 1 ///////////////////////////////////
	@Test //Faker
	public void lg12_loginFacker_Failed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
	}

	//DataProvider
	@Test(dataProviderClass= DataProviderPage.class, dataProvider="loginFailData")
	public void lg13_loginDataProvider_Failed(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}
	
	//Parameters
	@Test @Parameters({"user1", "pass1"})
	public void lg14_loginPrameters_Failed(String user1, String pass1) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(user1, pass1);
	}
	
	//DataProvider + Faker
	@Test(dataProviderClass= DataProviderPage.class, dataProvider="loginFaker")
	public void lg15_loginDataProviderFaker_Failed(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}
	
	///////////////////////////////// END Home Work 1 ///////////////////////////////////
	
	@Test
	public void lg2_loginSucced() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
	}
	
}
