package ua.com.tartustour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static ua.com.tartustour.pages.locators.ComparePageConstants.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 12/9/2016.
 */
public class ComparePage extends MainPage {

    @FindBy(xpath = COMPARE_PAGE_TITLE)
    WebElement title;
    @FindBy(xpath = PORT_LABEL)
    WebElement portLabel;
    @FindBy(xpath = DATES_LABEL)
    WebElement dateLabel;
    @FindBy(xpath = REGION_LABEL)
    WebElement regionLabel;
    @FindBy(xpath = COMPANY_LABEL)
    WebElement companyLabel;
    @FindBy(xpath = SHIP_LABEL)
    WebElement shipLabel;
    @FindBy(xpath = DURATION_LABEL)
    WebElement durationLabel;
    @FindBy(xpath = PRICE_LABEL)
    WebElement priceLabel;
    @FindBy(xpath = ONLY_CHILDREN_LABEL)
    WebElement onlyChildrenlabel;
    @FindBy(xpath = ONLY_DISCOUNT_LABEL)
    WebElement discountLabel;
    @FindBy(xpath = RUSSIAN_SERVICE_LABEL)
    WebElement russianServiceLabel;
    @FindBy(xpath = ADD_ID_BUTTON)
    WebElement addIdButton;
    @FindBy(xpath = CRUISE_ID_SEARCH_FIELD)
    WebElement searchIdField;

    public ComparePage(WebDriver beanDriver) {
        super(beanDriver);
    }

    @Override
    public void load(){
        refreshPage();
    }
    @Override
    public void isLoaded(){
        assertTrue(title.getText().equalsIgnoreCase("Сравнение круизов"));
        assertTrue(webElementIsEnabled(regionLabel));
        assertTrue(webElementIsEnabled(portLabel));
        assertTrue(webElementIsEnabled(dateLabel));
        assertTrue(webElementIsEnabled(companyLabel));
        assertTrue(webElementIsEnabled(shipLabel));
        assertTrue(webElementIsEnabled(durationLabel));
        assertTrue(webElementIsEnabled(priceLabel));
        assertTrue(webElementIsEnabled(onlyChildrenlabel));
        assertTrue(webElementIsEnabled(discountLabel));
        assertTrue(webElementIsEnabled(russianServiceLabel));
        assertTrue(webElementIsEnabled(addIdButton));
        assertTrue(webElementIsEnabled(searchIdField));
    }

    @Override
    public ComparePage get(){
        return (ComparePage)super.get();
    }

}
