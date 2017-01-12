package ua.com.tartustour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.tartustour.pages.locators.LoginPageConstants;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 11/6/2016.
 */

public class LoginPage extends AbstractPage<LoginPage>{

    @FindBy(xpath = LoginPageConstants.LOGIN_BUTTON)
    WebElement loginButton;
    @FindBy(xpath = LoginPageConstants.EMAIL_FIELD)
    WebElement emailField;
    @FindBy(xpath = LoginPageConstants.PASSWORD_FIELD)
    WebElement passField;
    @FindBy(xpath = LoginPageConstants.BACK_TO_HOMEPAGE)
    WebElement goHomeButton;
    @FindBy(xpath = LoginPageConstants.FORGOT_PASS_LINK)
    WebElement forgotPassLink;
    @FindBy(xpath = LoginPageConstants.REGISTRATION_LINK)
    WebElement registreLink;
    @FindBy(xpath = LoginPageConstants.REMEMBER_CHECKBOX)
    WebElement remembePassCheckBox;

    @Autowired
    public LoginPage(WebDriver beanDriver) {
        super(beanDriver);
    }

    @Override
    protected void isLoaded(){
        assertTrue(webElementIsEnabled(loginButton));
        assertTrue(webElementIsEnabled(emailField));
        assertTrue(webElementIsEnabled(passField));
        assertTrue(webElementIsEnabled(registreLink));
    }
    @Override
    protected void load(){
        refreshPage();
    }

    public void enterEmail(String email){
        logger.info("| Setting email"+email+ " |");
        clearAndType(emailField, email);
    }
    public void enterPass(String pass){
        logger.info("| Setting password "+pass+ " |");
        clearAndType(passField, pass);
    }

    public void clickLogin(){
        logger.info("| Trying to login |");
        click(loginButton);
    }
    public void checkSaveCredentials(){
        logger.info("| Mark remember credentials checkbox |");
        click(remembePassCheckBox);
    }
    public boolean isCredentialsSaveBoxChecked(){
        return remembePassCheckBox.isSelected();
    }

    public ProfilePage login(String email,String pass,boolean saveCredentials){
        enterEmail(email);
        enterPass(pass);
        if(saveCredentials)checkSaveCredentials();
        clickLogin();
        return  new ProfilePage(driver).get();
    }
}
