package ua.com.tartustour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ua.com.tartustour.framemanagers.ConfigManager;
import ua.com.tartustour.pages.locators.MainPageConstants;

import static org.testng.Assert.assertTrue;


/**
 * Created by Administrator on 11/5/2016.
 */

@Component
@Lazy
public class MainPage extends AbstractPage<MainPage> {

    @FindBy(xpath = MainPageConstants.TARTUS_ICON)
    WebElement tartusIcon;
    @FindBy(xpath = MainPageConstants.CRUISE_TAB)
    WebElement cruiseTab;
    @FindBy(xpath = MainPageConstants.DISCOUNT_TAB)
    WebElement discountTab;
    @FindBy(xpath = MainPageConstants.INFO_TAB)
    WebElement infoTab;
    @FindBy(xpath = MainPageConstants.EVENTS_TAB)
    WebElement eventsTab;
    @FindBy(xpath = MainPageConstants.TOURISTS_TAB)
    WebElement touristsTab;
    @FindBy(xpath = MainPageConstants.AGENCIES_TAB)
    WebElement agenciesTab;
    @FindBy(xpath = MainPageConstants.CO_INFO_TAB)
    WebElement coInfoTab;
    @FindBy(xpath = MainPageConstants.ENTER_LOGIN)
    WebElement loginButton;

    @Autowired
    public MainPage(WebDriver beanDriver) {
        super(beanDriver);
    }

    @Override
    protected void load(){
        refreshPage();
    }

    @Override
    protected void isLoaded(){
        assertTrue(webElementIsEnabled(tartusIcon));
        assertTrue(webElementIsEnabled(cruiseTab));
        assertTrue(webElementIsEnabled(discountTab));
        assertTrue(webElementIsEnabled(infoTab));
        assertTrue(webElementIsEnabled(eventsTab));
        assertTrue(webElementIsEnabled(touristsTab));
        assertTrue(webElementIsEnabled(agenciesTab));
        assertTrue(webElementIsEnabled(coInfoTab));
        assertTrue(webElementIsEnabled(loginButton));
        assertTrue(webElementIsEnabled(tartusIcon));
    }

    public MainPage navigateMainPage(){
      navigateUrl(ConfigManager.getMAIN_URL());
      return  new MainPage(driver).get();
    }

    public LoginPage goToLoginPage(){
        click(loginButton);
        return new LoginPage(driver).get();
    }
}
