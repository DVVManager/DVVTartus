package ua.com.tartustour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ua.com.tartustour.pages.locators.RegistrationPageConstants;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 11/6/2016.
 */
@Component
@Lazy
public class RegistrationPage extends LoginPage {

    @Autowired
    public RegistrationPage(WebDriver beanDriver) {
        super(beanDriver);
    }
    @Override
    public void isLoaded(){
        assertTrue(webElementIsEnabled(emailField));
        assertTrue(webElementIsEnabled(nameField));
        assertTrue(webElementIsEnabled(surnameField));
        assertTrue(webElementIsEnabled(passField));
        assertTrue(webElementIsEnabled(confirmedPassField));
        assertTrue(webElementIsEnabled(registreButton));
    }

    @Override
    public void load(){
        refreshPage();
    }

    @FindBy(xpath= RegistrationPageConstants.EMAIL_FIELD)
    WebElement emailField;

    @FindBy(xpath= RegistrationPageConstants.NAME_FIELD)
    WebElement nameField;

    @FindBy(xpath= RegistrationPageConstants.PASSWORD_FIELD)
    WebElement passField;

    @FindBy(xpath= RegistrationPageConstants.CONFIRMED_PASS_FIELD)
    WebElement confirmedPassField;

    @FindBy(xpath= RegistrationPageConstants.SURNAME_FIELD)
    WebElement surnameField;

    @FindBy(xpath= RegistrationPageConstants.REGISTER_BUTTON)
    WebElement registreButton;
}
