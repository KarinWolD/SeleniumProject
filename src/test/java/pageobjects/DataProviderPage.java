package pageobjects;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

public class DataProviderPage {

		@DataProvider
		public Object[][] loginFailData(){
			return new Object[][]{{"user1","password1"},{"user2","password2"}};
		}//loginData
		
		@DataProvider
		public Object[][] loginFaker(){
			Faker faker = new Faker();
			String user= faker.name().fullName();
			String password = faker.internet().password();
			
			return new Object[][]{{user,password},{user,password}};
		}//loginFaker
}
