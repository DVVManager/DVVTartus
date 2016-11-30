package ua.com.tartustour.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ua.com.tartustour.framemanagers.ConfigManager;
import ua.com.tartustour.utils.TestHelper;

import static ua.com.tartustour.pages.locators.MainPageConstants.*;
import static ua.com.tartustour.pages.locators.SearchFormConstants.*;

import static org.testng.Assert.assertTrue;


/**
 * Created by Administrator on 11/5/2016.
 */

@Component
@Lazy
public class MainPage extends AbstractPage<MainPage> {

    @FindBy(xpath = TARTUS_ICON)
    WebElement tartusIcon;
    @FindBy(xpath = CRUISE_TAB)
    WebElement cruiseTab;
    @FindBy(xpath = DISCOUNT_TAB)
    WebElement discountTab;
    @FindBy(xpath = INFO_TAB)
    WebElement infoTab;
    @FindBy(xpath = EVENTS_TAB)
    WebElement eventsTab;
    @FindBy(xpath = TOURISTS_TAB)
    WebElement touristsTab;
    @FindBy(xpath = AGENCIES_TAB)
    WebElement agenciesTab;
    @FindBy(xpath = CO_INFO_TAB)
    WebElement coInfoTab;
    @FindBy(xpath = ENTER_LOGIN)
    WebElement loginButton;

    @Autowired
    public MainPage(WebDriver beanDriver) {
        super(beanDriver);
    }

    @Override
    protected void load() {
        refreshPage();
    }

    @Override
    protected void isLoaded() {
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

    public MainPage navigateMainPage() {
        navigateUrl(ConfigManager.getMAIN_URL());
        return new MainPage(driver).get();
    }

    public LoginPage goToLoginPage() {
        click(loginButton);
        return new LoginPage(driver).get();
    }


    public class SearchForm {

        @FindBy(xpath = SEARCH_BUTTON)
        WebElement searchButton;
        @FindBy(xpath = CRUISE_SEA_CATEGORY)
        WebElement seaCruiseButton;
        @FindBy(xpath = CRUISE_RIVER_CATEGORY)
        WebElement riverCruiseButton;
        @FindBy(xpath = CRUISE_REGION)
        WebElement regionField;
        @FindBy(xpath = CRUISE_START_DATE)
        WebElement startDateField;
        @FindBy(xpath = CRUISE_NEXT_START_DATE)
        WebElement nextStartDateField;
        @FindBy(xpath = DETAILED_SEARCH_BUTTON)
        WebElement detailedSearchBytton;
        @FindBy(xpath = CLEAR_SEARCH_BUTTON)
        WebElement clearSearchButton;
        @FindBy(xpath = HISTORY_BUTTON)
        WebElement historyButton;

        @Autowired
        public SearchForm() {
            PageFactory.initElements(driver, this);
        }

        public SearchResultPage performSearch(){
            click(searchButton);
            logger.info("| Proceeding with search and waiting for result page |");
            return (SearchResultPage) new SearchResultPage(driver).get();
        }

        public void setStartDateFieldAsCurrent(){
            typeText(startDateField, TestHelper.getCurrentDate("dd-MM-yyyy"));
            startDateField.sendKeys(Keys.ESCAPE);
        }
        public void setStartDateFieldCustomed(String dayMonthYear,int increment){
            typeText(startDateField, TestHelper.getDateInPastOrFuture(dayMonthYear, increment));
            startDateField.sendKeys(Keys.ESCAPE);
        }
        public void setNextStartDateFieldAsCurrent(){
            typeText(nextStartDateField, TestHelper.getCurrentDate("dd-MM-yyyy"));
            startDateField.sendKeys(Keys.ESCAPE);
        }
        public void setNextStartDateFieldCustomed(String dayMonthYear,int increment){
            typeText(nextStartDateField, TestHelper.getDateInPastOrFuture(dayMonthYear, increment));
            startDateField.sendKeys(Keys.ESCAPE);
        }


    }
}
