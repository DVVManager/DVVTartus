package ua.com.tartustour.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;
import static ua.com.tartustour.pages.locators.BookingPageLocators.*;

/**
 * Created by Administrator on 12/9/2016.
 */
public class BookingPage extends CruiseDetailsPage {

    public BookingPage(WebDriver beanDriver) {
        super(beanDriver);
    }
    @FindBy(xpath = BACK_TO_CRUISE)
    WebElement backToSearchResults;
    @FindBy(xpath = PASSANGERS_STEP)
    WebElement passangersStep;
    @FindBy(xpath = CABIN_STEP)
    WebElement cabinStep;
    @FindBy(xpath = SERVICES_STEP)
    WebElement servicesStep;
    @FindBy(xpath = BOOKING_STEP)
    WebElement bookingStep;
    @FindBy(xpath = FINAL_STEP)
    WebElement finalStep;

    @Override
    protected void load() {
        refreshPage();
    }

    @Override
    protected void isLoaded() {
        assertTrue(webElementIsEnabled(backToSearchResults));
        assertTrue(webElementIsEnabled(passangersStep));
        assertTrue(webElementIsEnabled(cabinStep));
        assertTrue(webElementIsEnabled(servicesStep));
        assertTrue(webElementIsEnabled(bookingStep));
        assertTrue(webElementIsEnabled(finalStep));
        assertTrue(getElementBy(By.xpath(CURRENT_STEP)).getText().equalsIgnoreCase(passangersStep.getText()));
    }

    @Override
    public BookingPage get() {
        return  (BookingPage) super.get();
    }

    public class PassangersStep{

        public PassangersStep() {
            PageFactory.initElements(driver, this);
        }
    }

    public class CabinsStep{

        public CabinsStep() {
            PageFactory.initElements(driver, this);
        }
    }

    public class ServicesStep{

        public ServicesStep() {
            PageFactory.initElements(driver, this);
        }
    }

    public class BookingStep{

        public BookingStep() {
            PageFactory.initElements(driver, this);
        }
    }

    public class FinalStep{

        public FinalStep() {
            PageFactory.initElements(driver, this);
        }
    }

}
