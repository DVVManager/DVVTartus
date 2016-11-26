package ua.com.tartustour.pages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 11/4/2016.
 */
public abstract class AbstractPage<T extends AbstractPage<T>> extends LoadableComponent<T> {

    private static Logger logger = Logger.getLogger(AbstractPage.class);
    protected static WebDriver driver;
    protected WebDriverWait wait ;

    @Autowired
    public AbstractPage(WebDriver beanDriver){
        driver=beanDriver;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        wait= new WebDriverWait(driver,15);

    }

    public void navigateUrl(String url) {
        logger.info("| Going to navigate " + url + " |");
        driver.get(url);

    }

    public static void quiteAndCloseDriver(){
        driver.quit();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clearAndInputText(WebElement inputElement,String inputText) {
        inputElement.clear();
        inputElement.sendKeys(inputText);

    }

    public void clearFieldNonJS(WebElement element){
        element.sendKeys(Keys.CONTROL+"A"+Keys.DELETE);
    }

    public void typeText(WebElement element,String text){
        element.sendKeys(text);
    }

    public void click(WebElement clickElement) {
        clickElement.click();
    }

    public boolean webElementIsEnabled(WebElement element){
        return element.isEnabled();
    }

    public void waitElementToBeClickable(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void navigatePageBack(){
        driver.navigate().back();
    }

    public void navigatePageForward(){
        driver.navigate().forward();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void submit(WebElement element){
        element.submit();
    }
    public void cancelAlertPopUp(){
        String alertString="";
        try {
            Alert alert = driver.switchTo().alert();
            alertString = alert.getText();
            alert.dismiss();
            logger.info(alertString+" - Alert text");
        } catch (NoAlertPresentException e) {
            logger.info("Alert pop-uo doesn't exist");
        }
    }
    public void acceptAlertPopUp(){
        String alertString="";
        try {
            Alert alert = driver.switchTo().alert();
            alertString = alert.getText();
            alert.accept();
            logger.info(alertString + " - Alert text");
        } catch (NoAlertPresentException e) {
            logger.info("Alert pop-uo doesn't exist");
        }
    }

    public void executeJSCommand(String command){
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript(command);
    }

    public void selectDropDownElementByText(WebElement element,String text){
        Select mydrpdwn = new Select(element);
        mydrpdwn.selectByVisibleText(text);
    }

    public void selectDropDownElementByValue(WebElement element,String value){
        Select mydrpdwn = new Select(element);
        mydrpdwn.selectByValue(value);
    }

    public void selectDropDownElementByIndex(WebElement element,int index){
        Select mydrpdwn = new Select(element);
        mydrpdwn.selectByIndex(index);
    }

    public void deselectAllValuesInDropDown(WebElement element){
        Select mydrpdwn = new Select(element);
        mydrpdwn.deselectAll();
    }

    public List<WebElement> getDropDownSelectedOptions(WebElement element){
        Select mydrpdwn = new Select(element);
        return mydrpdwn.getAllSelectedOptions();
    }

    public List<WebElement> getAllDropDownOptions(WebElement element){
        Select mydrpdwn = new Select(element);
       return  mydrpdwn.getOptions();
    }

    public boolean isDropDownMultiple(WebElement element){
        Select mydrpdwn = new Select(element);
        return mydrpdwn.isMultiple();
    }

    public void deselectDropDownOptionByText(WebElement element,String text){
        Select mydrpdwn = new Select(element);
        mydrpdwn.deselectByVisibleText(text);
    }

    public boolean checkElementExists(String xpath){
        return  driver.findElements(By.xpath(xpath)).size()!= 0;
    }

    public void takeScreenShot(){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String picName= "screen_"+RandomStringUtils.random(8,true,true);
            FileUtils.copyFile(screenshot, new File("src/target/classes/"+picName+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void load() {
    }
    @Override
    protected void isLoaded() throws Error {
    }
}
