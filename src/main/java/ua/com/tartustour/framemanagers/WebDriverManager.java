package ua.com.tartustour.framemanagers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Administrator on 11/4/2016.
 */
@Lazy
@Component
@ContextConfiguration(locations = {"classpath*:bean.xml"})
public class WebDriverManager {

    public static Logger logger = Logger.getLogger(WebDriverManager.class);

    // ------------------------------------------------------------------------------------------

    @Lazy
    @Bean
    public WebDriver createDriver(){
        return createGenericDriver();
    }

    public WebDriver createGenericDriver() {

        logger.info("| Test preparation, setting " + ConfigManager.BROWSER + " as a driver |");
        /*switch(ConfigManager.BROWSER){
            case "chrome":return createChromeDriver();
            case "ffox": return  createFFoxDriver();
            case "ie": return createIEDriver();
            default: logger.warn("Wrong type of driver was choosing, setting Chrome as default");
                return createChromeDriver();
        }*/
        if(ConfigManager.BROWSER.equalsIgnoreCase("ffox")) {
            return createFFoxDriver();
        } else if (ConfigManager.BROWSER .equalsIgnoreCase("chrome")) {
            return createChromeDriver();
        } else {
            return createIEDriver();
        }
    }

    // ------------------------------------------------------------------------------------------

    private WebDriver createIEDriver() {
        System.setProperty("webdriver.ie.driver", "D:/Knowledge Centre/KCentre/WebDrivers/IEDriverServer.exe");
        return new InternetExplorerDriver();
    }

    private WebDriver createChromeDriver() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Knowledge Centre\\KCentre\\WebDrivers\\chromedriver.exe");
        return new ChromeDriver();
    }

    private WebDriver createFFoxDriver() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.dir", "D:/");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "mage/jpg, text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf");
        return new FirefoxDriver(firefoxProfile);
    }

    private static Logger getLoger() {
        return logger;
    }

    // ---------------------------------------------------------------------------------------------

}
