package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageLocators {
	
	public PageLocators(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@content-desc='AuthoriseWithTwitter_593']")
	public WebElement twitterIcon;
	
	public WebElement getTwitterIcon() {
		return twitterIcon;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc='By signing up, you agree to our ']")
	public WebElement googleLoginIcon;
	
	public WebElement getGoogleLoginIcon() {
		return googleLoginIcon;
	}
	
	@AndroidFindBy(uiAutomator="resourceId(\"username_or_email\")")
	public WebElement userName;
	
	public WebElement getUserName() {
		return userName;
	}
	
	@AndroidFindBy(uiAutomator="resourceId(\"password\")")
	public WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
	
	@AndroidFindBy(xpath="//*[@text='Authorise app']")
	public WebElement authorise;
	
	public WebElement getAuthoriseButton() {
		return authorise;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc='HomePage]")
	public WebElement homePage;
	
	public WebElement getHomePage() {
		return homePage;
	}
}
