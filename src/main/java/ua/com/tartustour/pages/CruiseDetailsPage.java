package ua.com.tartustour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static ua.com.tartustour.pages.locators.CruiseDetailsPageConstants.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 12/9/2016.
 */
public class CruiseDetailsPage extends SearchResultPage {

    public CruiseDetailsPage(WebDriver beanDriver) {
        super(beanDriver);
    }

    @FindBy(xpath = CRUISE_NAME)
    WebElement cruiseName;

    @FindBy(xpath = CRUISE_ID)
    WebElement cruiseId;

    @FindBy(xpath = CRUISE_PRICE)
    WebElement cruisePrice;

    @FindBy(xpath = CRUISE_DURATION)
    WebElement cruiseDuration;

    @FindBy(xpath = CRUISE_FIRST_PORT)
    WebElement cruiseFirstPort;

    @FindBy(xpath = CRUISE_BOOK_BUTTON)
    WebElement bookButton;

    @FindBy(xpath = CRUISE_DATE_PRICE_SECTION)
    WebElement datePriceSection;

    @FindBy(xpath = CRUISE_FEEDBACK_SECTION)
    WebElement feedbackSection;

    @FindBy(xpath = CRUISE_ROUTE_SETION)
    WebElement routeSection;

    @FindBy(xpath = CRUISE_SHIP_SECTION)
    WebElement shipSection;


    @Override
    protected void load() {
        refreshPage();
    }

    @Override
    protected void isLoaded() {
        assertTrue(webElementIsEnabled(cruiseName) && cruiseName.getText().length()>0);
        assertTrue(webElementIsEnabled(cruiseId) && cruiseId.getText().length()>0);
        assertTrue(webElementIsEnabled(cruisePrice));
        assertTrue(webElementIsEnabled(cruiseDuration));
        assertTrue(webElementIsEnabled(cruiseFirstPort) && cruiseFirstPort.getText().length()>0);
        assertTrue(webElementIsEnabled(bookButton));
        assertTrue(webElementIsEnabled(datePriceSection));
        assertTrue(webElementIsEnabled(feedbackSection));
        assertTrue(webElementIsEnabled(routeSection));
        assertTrue(webElementIsEnabled(shipSection));
    }

    @Override
    public CruiseDetailsPage get() {
        return (CruiseDetailsPage) super.get();
    }
    public BookingPage goToBooking(){
        logger.info("Going to booking");
        clickIfVisible(bookButton);
        return new BookingPage(driver).get();
    }
}
