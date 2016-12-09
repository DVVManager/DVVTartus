package ua.com.tartustour.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.com.tartustour.utils.TestHelper;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
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

    private List<CruiseCard> cruiseCards;
    private List<String> cruisesInComparison=new ArrayList<>();


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

    @Override
    public SearchResultPage get(){
        return (SearchResultPage)super.get();
    }
    //TODO: return mapView page
    public void clickMapView(){
        clickIfVisible(resultViewMap);
    }
    public void clickTableView(){
        clickIfVisible(resultViewTable);
    }

    public void sortByDateAsc(){
        selectDropDownElementByValue(sortItemsList, "1");
        TestHelper.waitSeconds(1);
    }

    public void sortByDateDesc(){
        selectDropDownElementByValue(sortItemsList, "2");
        TestHelper.waitSeconds(1);
    }

    public void sortByPriceAsc(){
        selectDropDownElementByValue(sortItemsList,"3");
        TestHelper.waitSeconds(1);
    }

    public void sortByPriceDesc(){
        selectDropDownElementByValue(sortItemsList,"4");
        TestHelper.waitSeconds(1);
    }

    public List<String> addToCompareCruiseWithName(String name){
        refreshPage();
        TestHelper.waitSeconds(1);
        WebElement cruise=getElementBy(By.xpath(String.format(CRUISE_NAME,name)));
        WebElement compare=getElementByAppend(cruise,By.xpath(COMPARE_BY_NAME));
        clickWithJS(compare);
        TestHelper.waitSeconds(1);
        refreshPage();
        cruise=getElementBy(By.xpath(String.format(CRUISE_NAME, name)));
        WebElement inComparison=getElementByAppend(cruise, By.xpath(IN_COMPARISON_BY_NAME));
        assertEquals("В сравнении",inComparison.getText());
        cruisesInComparison.add(name);
        return cruisesInComparison;
    }

    public List<String> addToCompareCruiseWithId(String id){
        refreshPage();
        TestHelper.waitSeconds(1);
        WebElement cruise=getElementBy(By.xpath(String.format(CRUISE_ID,id)));
        WebElement compareButton=getElementByAppend(cruise,By.xpath(COMPARE_BY_ID));
        clickWithJS(compareButton);
        TestHelper.waitSeconds(1);
        refreshPage();
        cruise=getElementBy(By.xpath(String.format(CRUISE_ID, id)));
        WebElement inComparison=getElementByAppend(cruise, By.xpath(IN_COMPARISON_BY_ID));
        assertEquals("В сравнении", inComparison.getText());
        cruisesInComparison.add(id);
        return cruisesInComparison;
    }

    public int getPageResultsCount(int page){
        moveToResultPage(page);
        return getElementsCount(By.xpath(RESULT_TABLE_RESULTS));
    }

    public int getPagesCount(){
        return Integer.valueOf(getElementBy(By.xpath(PAGES_COUNT)).getText());
    }

    public void moveToResultPage(int pageNum){
        int pagesCount=getPagesCount();
        if(pageNum>pagesCount){
            throw new RuntimeException("No such page at Result's table.");
        }
        WebElement requiredPage=getElementBy(By.xpath(String.format(RESULT_TABLE_PAGE, pageNum + 1)));
        clickWithJS(requiredPage);
    }

    public int getCurrentPageNum(){
        WebElement currentPageNum=getElementBy(By.xpath(CURRENT_PAGE));
        return Integer.valueOf(currentPageNum.getText());
    }

    public void moveToResultPageWithArrow(int pageNum){
        int pagesCount=getPagesCount();
        if(pageNum>pagesCount){
            throw new RuntimeException("No such page at Result's table.");
        }
        // currentPageNum=getCurrentPageNum();
        while(getCurrentPageNum()>pageNum){
            moveToPrevPage();
            TestHelper.waitSeconds(1);
        }
        while(getCurrentPageNum()<pageNum){
            moveToNextPage();
            TestHelper.waitSeconds(1);
        }
    }

    public void moveToNextPage(){
        clickWithJS(getElementBy(By.xpath(NEXT_PAGE_ARROW)));
    }

    public void moveToPrevPage(){
        clickWithJS(getElementBy(By.xpath(PREV_PAGE_ARROW)));
    }

    public WebElement getRandomCruiseFromResult(){
        if(getPageResultsCount(1)>0){
            return getRandomFromWebElements(By.xpath(RESULT_TABLE_RESULTS));
        }else{
            throw new RuntimeException("Missing any cruise in result table");
        }
    }
    //TODO:return detailsPage
    public void goToRandomCruiseDetails(){
        WebElement randomCruise=getRandomCruiseFromResult();
        TestHelper.waitSeconds(1);
        clickWithJS(randomCruise.findElement(By.xpath(CRUISE_DETAILS_BUTTON)));
    }
    //TODO:retrun detailsPage
    public void goToCruiseDetailsByName(String cruiseName){
        WebElement cruiseTitlename=getElementBy(By.xpath(String.format(CRUISE_NAME,cruiseName)));
        cruiseTitlename.click();
    }

    public List<CruiseCard> getFoundCruisCards(){
         cruiseCards=new ArrayList();
        List<WebElement> cruisesFound=getElementsBy(By.xpath(RESULT_TABLE_RESULTS));
        for(WebElement el:cruisesFound){
            CruiseCard card=new CruiseCard();
            String cruiseName=el.findElement(By.xpath(CRUISE_APPEND_NAME)).getText();
            card.setCruiseName(cruiseName);
            String cruiseId=el.findElement(By.xpath(CRUISE_APPEND_ID)).getText();
            card.setCruiseId(cruiseId);
            String cruisePrice=el.findElement(By.xpath(CRUISE_APPEND_PRICE)).getText();
            card.setCruisePrice(cruisePrice);
            String cruiseDuration=el.findElement(By.xpath(CRUISE_APPEND_DURATION)).getText();
            card.setCruiseDuration(cruiseDuration);
            cruiseCards.add(card);
        }
      /*  int cruiseCount=getPageResultsCount(1);
        while(cruiseCount>0){
            CruiseCard card=new CruiseCard();
            String cruiseName=getElementBy(By.xpath(RESULT_TABLE_RESULTS +"["+cruiseCount+"]"+CRUISE_APPEND_NAME)).getText();
            card.setCruiseName(cruiseName);
            String cruiseId=getElementBy(By.xpath(RESULT_TABLE_RESULTS + "[" + cruiseCount + "]"+CRUISE_APPEND_ID)).getText();
            card.setCruiseId(cruiseId);
            String cruisePrice=getElementBy(By.xpath(RESULT_TABLE_RESULTS +"["+cruiseCount+"]"+CRUISE_APPEND_PRICE)).getText();
            card.setCruisePrice(cruisePrice);
            String cruiseDuration=getElementBy(By.xpath(RESULT_TABLE_RESULTS +"["+cruiseCount+"]"+CRUISE_APPEND_DURATION)).getText();
            card.setCruiseDuration(cruiseDuration);
            cruiseCards.add(card);
            cruiseCount--;
        }*/
        return cruiseCards;
    }
    //TODO:retrun comparison page
    public void goToComparePage(){
        clickIfVisible(getElementBy(By.xpath(CRUISES_IN_COMPARISON_ICON)));
    }

    public String getCruisesInComparisonCount(){
        WebElement compareIcon=getElementBy(By.xpath(CRUISES_IN_COMPARISON_ICON));
        return compareIcon.getText();
    }



    public class CruiseCard{
        public CruiseCard(){

        }

        private String cruiseName;
        private String cruisePrice;
        private String cruiseDuration;
        private String startDate;
        private String lastDate;
        private String cruiseId;
        private String firstPort;

        public void setCruiseName(String cruiseName) {
            this.cruiseName = cruiseName;
        }

        public void setCruisePrice(String cruisePrice) {
            this.cruisePrice = cruisePrice;
        }

        public void setCruiseDuration(String cruiseDuration) {
            this.cruiseDuration = cruiseDuration;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public void setLastDate(String lastDate) {
            this.lastDate = lastDate;
        }

        public void setCruiseId(String cruiseId) {
            this.cruiseId = cruiseId;
        }

        public void setFirstPort(String firstPort) {
            this.firstPort = firstPort;
        }



        public String getCruiseName() {
            return cruiseName;
        }

        public String getCruisePrice() {
            return cruisePrice;
        }

        public String getCruiseDuration() {
            return cruiseDuration;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getLastDate() {
            return lastDate;
        }

        public String getCruiseId() {
            return cruiseId;
        }

        public String getFirstPort() {
            return firstPort;
        }

        @Override
        public String toString(){
            return "Name: "+this.cruiseName+" Duration: "+this.cruiseDuration+" Id: "+this.cruiseId+" Price: "+this.cruisePrice+
                    " Port: "+this.firstPort+ " Stardt date: "+this.startDate+" Last date: "+this.lastDate+"!";
        }
    }


}
