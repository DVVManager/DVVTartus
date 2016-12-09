package ua.com.tartustour.pages;

import org.openqa.selenium.By;
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

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static ua.com.tartustour.pages.locators.SearchResultPageConstants.*;
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

        public SearchForm() {
            PageFactory.initElements(driver, this);
        }

        public SearchForm get() {
            assertTrue(webElementIsEnabled(seaCruiseButton));
            assertTrue(webElementIsEnabled(riverCruiseButton));
            assertTrue(webElementIsEnabled(searchButton));
            assertTrue(webElementIsEnabled(regionField));
            assertTrue(webElementIsEnabled(startDateField));
            assertTrue(webElementIsEnabled(nextStartDateField));
            assertTrue(webElementIsEnabled(detailedSearchBytton));
            assertTrue(webElementIsEnabled(clearSearchButton));
            assertTrue(webElementIsEnabled(historyButton));
            return new SearchForm();
        }

        public SearchResultPage performSearch() {
            TestHelper.waitSeconds(1);
            clickIfVisible(searchButton);
            TestHelper.waitSeconds(1);
            logger.info("| Proceeding with search and waiting for result page |");
            return new SearchResultPage(driver).get();
        }

        public void performSearchWithEmptyResult() {
            TestHelper.waitSeconds(1);
            clickIfVisible(searchButton);
            String emptyResultMessage = getElementBy(By.xpath(EMPTY_RESULT)).getText();
            assertEquals(emptyResultMessage.trim(), "Нет круизов удовлетворяющих Вашему запросу");
        }

        public void setStartDateFieldAsCurrent() {
            logger.info("| Setting start date as current |");
            clearAndType(startDateField, TestHelper.getCurrentDate("dd-MM-yyyy"));
            TestHelper.waitSeconds(1);
            startDateField.sendKeys(Keys.ESCAPE);

        }

        public void setStartDateFieldCustomed(String dayMonthYear, int increment) {
            logger.info("| Setting start date |");
            clearAndType(startDateField, TestHelper.getDateInPastOrFuture(dayMonthYear, increment));
            TestHelper.waitSeconds(1);
            startDateField.sendKeys(Keys.ESCAPE);

        }

        public void setNextStartDateFieldAsCurrent() {
            logger.info("| Setting next start date as current |");
            clearAndType(nextStartDateField, TestHelper.getCurrentDate("dd-MM-yyyy"));
            TestHelper.waitSeconds(1);
            startDateField.sendKeys(Keys.ESCAPE);

        }

        public void setNextStartDateFieldCustomed(String dayMonthYear, int increment) {
            logger.info("| Setting next start date |");
            clearAndType(nextStartDateField, TestHelper.getDateInPastOrFuture(dayMonthYear, increment));
            TestHelper.waitSeconds(1);
            startDateField.sendKeys(Keys.ESCAPE);

        }

        public String setRandomAvailableRegion() {
            logger.info("| Setting random available region |");
            click(regionField);
            WebElement region;
            if (getElementsCount(By.xpath(CRUISE_REGION_LIST)) > 0) {
                region = getRandomFromWebElements(By.xpath(CRUISE_REGION_LIST));
                clickIfVisible(region);
            } else {
                throw new RuntimeException("| No available cruise region - seems no cruise as well |");
            }
            WebElement subRegion = getRandomFromWebElements(By.xpath(CRUISER_SUB_REGION_LIST));
            String selectedSubRegion = subRegion.getAttribute("data-value");
            clickIfVisible(subRegion);
            click(regionField);
            return selectedSubRegion;
        }

        public void setSpecifiedRegion(String region) {
            click(regionField);
            logger.info("| Setting region " + region + " |");
            moveToElementAndClick(getElementBy(By.xpath(String.format(CRUISE_REGION_SPECIFIED, region))));
            //TestHelper.waitSeconds(1);

        }

        public void setSpecifiedSubRegion(String subRegion) {
            //moveMouse(317,353);
            moveToElementAndClick(getElementBy(By.xpath(String.format(CRUISE_SUBREGION_SPECIFIED, subRegion))));
            TestHelper.waitSeconds(1);
            click(regionField);
            logger.info("| Setting sub region " + subRegion + " |");
        }

        public void clearFilledData() {
            TestHelper.waitSeconds(1);
            logger.info("| Clear data in search from |");
            clickIfVisible(clearSearchButton);
            TestHelper.waitSeconds(1);
            this.get();
        }

        public void goToSearchHistory() {
            TestHelper.waitSeconds(1);
            clickWithJS(historyButton);
            logger.info("| Going to search history |");
            TestHelper.waitSeconds(1);
        }

        public void openDetailsSearch() {
            logger.info("| Opening detailed search section |");
            TestHelper.waitSeconds(1);
            clickIfVisible(detailedSearchBytton);
            TestHelper.waitSeconds(2);
        }

        public void hideDetailedSearch() {
            logger.info("| Hiding detailed search section |");
            clickIfVisible(getElementBy(By.xpath(HIDE_DETAILED_SEARCH_BUTTON)));
            TestHelper.waitSeconds(1);
        }

        public void chooseSeaCruise() {
            logger.info("| Choosing SEA Cruise |");
            clickIfVisible(seaCruiseButton);
        }

        public void chooseRiverCruise() {
            logger.info("| Choosing RIVER Cruise |");
            clickIfVisible(riverCruiseButton);
        }

        public SearchForm returnToSearchFromHistory() {
            TestHelper.waitSeconds(1);
            clickIfVisible(getElementBy(By.xpath(BACK_TO_SEARCH)));
            logger.info("| Going back to search from |");
            return get();
        }

        public String setRandomAvailablePort() {
            logger.info("| Setting random available port |");
            click(getElementBy(By.xpath(CRUISE_PORT)));
            WebElement portRegion;
            if (getElementsCount(By.xpath(CRUISE_PORT_LIST)) > 0) {
                portRegion = getRandomFromWebElements(By.xpath(CRUISE_PORT_LIST));
                clickIfVisible(portRegion);
            } else {
                throw new RuntimeException("| No available cruise region - seems no cruise as well |");
            }
            WebElement city = getRandomFromWebElements(By.xpath(CRUISE_PORT_CITIES_LIST));
            String selectedSubRegion = city.getAttribute("data-value");
            clickIfVisible(city);
            click(getElementBy(By.xpath(CRUISE_PORT)));
            return selectedSubRegion;
        }

        public void setSecifiedPortRegion(String portRegion) {
            WebElement portRegionElement = getElementBy(By.xpath(CRUISE_PORT));
            click(portRegionElement);

            moveToElementAndClick(getElementBy(By.xpath(String.format(CRUISE_PORT_REGION, portRegion))));
            logger.info("| Setting port region " + portRegion + " |");
        }

        public void setSpecifiedCity(String city) {
            //moveMouse(317,353);
            moveToElementAndClick(getElementBy(By.xpath(String.format(CRUISE_PORT_CITY, city))));
            TestHelper.waitSeconds(1);
            click(getElementBy(By.xpath(CRUISE_PORT)));
            logger.info("| Setting sub region " + city + " |");
        }

        public void chooseRandomCurrency() {
            List<WebElement> currencies = getAllDropDownOptions(getElementBy(By.id(CURRENCY_DROPDOWN)));
            Collections.shuffle(currencies);
            currencies.get(0).click();
        }

        public void setCurrency(String currencyCode) {
            selectDropDownElementByText(getElementBy(By.id(CURRENCY_DROPDOWN)), currencyCode);
        }

        public void setPrice(int value) {

            WebElement slideBar = getElementBy(By.id(PRICE_SLIDE_BAR));
            executeJSCommand("arguments[0].setAttribute('value', '" + value + "')", slideBar);
            executeJSCommand("document.getElementById('" + PRICE_SLIDE_BAR + "').onchange()");
            /*executeJSCommand("window.outputUpdate("+value+");");*/
        }

        public void chooseWithRussianGroup() {
            getElementBy(By.xpath(RUSSIAN_GROUP)).click();
        }

        public void chooseWithSales() {
            getElementBy(By.xpath(SALES_ONLY)).click();
        }

        public void chooseWithFreeForChildren() {
            getElementBy(By.xpath(CHILDREN_FREE)).click();
        }

        public void setRandomAvailableCompany() {
            logger.info("| Setting random available company |");
            click(getElementBy(By.xpath(COMPANY_FIELD)));
            WebElement coCategory;
            if (getElementsCount(By.xpath(COMPANY_CATEGORY_LIST)) > 0) {
                coCategory = getRandomFromWebElements(By.xpath(COMPANY_CATEGORY_LIST));
                clickIfVisible(coCategory);
                TestHelper.waitSeconds(1);
            } else {
                throw new RuntimeException("| No available cruise region - seems no cruise as well |");
            }
            click(getElementBy(By.xpath(COMPANY_FIELD)));
            WebElement company = getRandomFromWebElements(By.xpath(COMPANY_NAME_LIST));
            int x = company.getLocation().getX();
            int y = company.getLocation().getY();
            moveMouse(x, y);
            clickIfVisible(company);
            TestHelper.waitSeconds(1);

        }

        public void setRiverByText(String riverName){
            selectDropDownElementByText(getElementBy(By.id(RIVER_FIELD)), riverName);
        }

        public void setRandomRiver(){
            List<WebElement> rivers=getAllDropDownOptions(getElementBy(By.id(RIVER_FIELD)));
            Collections.shuffle(rivers);
            rivers.get(0).click();
        }
    }

}

