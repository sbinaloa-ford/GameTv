package automation.GameTv;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.PageLocators;

public class GameTvTest extends Base{
	
	PageLocators pl;
	
	@BeforeClass
	public void setup() {
		loadProperties();
		service=startServer();
		try {
			capabilities();
		} catch (Exception e) {
			e.printStackTrace();
			//service.stop();
		}
		 pl = new PageLocators(driver);
	}

	@Test(priority=1)
	public void verifyLoginScreen() throws IOException, InterruptedException
	{
		Assert.assertTrue(driver!=null,"Session is created");
		Assert.assertTrue(pl.getGoogleLoginIcon().isDisplayed());
		Assert.assertTrue(pl.getTwitterIcon().isDisplayed());
	}
	
	@Test(priority=2)
	public void verifyAndClickTwitterIcon() throws IOException, InterruptedException
	{	
		Assert.assertTrue(driver!=null,"Session is created");
		Assert.assertTrue(pl.getTwitterIcon().getAttribute("clickable").equals("true"));
		pl.getTwitterIcon().click();
	}
	
	@Test(priority=3)
	public void verifyAuthorisationScreen() throws IOException, InterruptedException
	{
		Assert.assertTrue(driver!=null,"Session is created");
	    Assert.assertTrue(pl.getAuthoriseButton().isDisplayed()); 
	    Assert.assertTrue(pl.getAuthoriseButton().getAttribute("clickable").equals("true"));
	    Assert.assertTrue(pl.getUserName().isDisplayed()); 
	    Assert.assertTrue(pl.getPassword().isDisplayed()); 
	}
	
	@Test(priority=4)
	public void loginandverifyHomePage() throws IOException, InterruptedException
	{
		Assert.assertTrue(driver!=null,"Session is created successfully");
		pl.getUserName().sendKeys(userName);
		pl.getPassword().sendKeys(password);
		pl.getAuthoriseButton().click();
		Assert.assertTrue(pl.getHomePage().isDisplayed()); 
	}
	
	@AfterClass
	public void teardown() {
	     service.stop();
	}
}


