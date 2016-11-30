package ua.com.tartustour.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ua.com.tartustour.pages.locators.SearchResultPageConstants.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 11/30/2016.
 */
public class SearchResultPage extends MainPage {

    @FindBy(xpath = VIEW_AS_MAP)
    WebElement resultViewMap;
    @FindBy(xpath = VIEW_AS_TABLE)
    WebElement resultViewTable;
    @FindBy(id = SORT_ITEM_LIST)
    WebElement sortItemsList;


    public SearchResultPage(WebDriver beanDriver) {
        super(beanDriver);
    }

    @Override
    protected void load() {
        refreshPage();
    }

    @Override
    protected void isLoaded() {
        super.isLoaded();
        assertTrue(webElementIsEnabled(resultViewMap));
        assertTrue(webElementIsEnabled(resultViewTable));
        assertTrue(webElementIsEnabled(sortItemsList));
    }

    public int getPageResultsCount(int page){
        //TODO: add logic to choose required page num
        return getElementsCount(By.xpath(RESULT_TABLE_RESULTS));
    }

    public WebElement getRandomCruiseFromResult(){
        if(getPageResultsCount(1)>0){
            return getRandomFromWebElements(By.xpath(RESULT_TABLE_RESULTS));
        }else{
            throw new RuntimeException("Missing any cruise in result table");
        }
    }

    public void goToRandomCruiseDetails(){
        click(getRandomCruiseFromResult().findElement(By.xpath(CRUISE_DETAILS_BUTTON)));
    }


    public class CruiseCard{
        public CruiseCard(){
                PageFactory.initElements(driver, this);
        }

    }


}
