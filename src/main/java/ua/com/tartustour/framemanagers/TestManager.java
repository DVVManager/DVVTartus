package ua.com.tartustour.framemanagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import ua.com.tartustour.pages.AbstractPage;
import ua.com.tartustour.pages.MainPage;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 11/4/2016.
 */

@ContextConfiguration(locations = {"classpath*:bean.xml"})
@Lazy
public class TestManager extends AbstractTestNGSpringContextTests {
    @Autowired
    MainPage mainPage;

    @BeforeMethod
    public void beforeTestMethod(Method method){
        logger.info("|Going to start '"+ method.getName().toUpperCase()+"' method |" );
    }

    @AfterMethod
    public void afterTestMethod(Method method){
        logger.info("|Finishing '"+ method.getName().toUpperCase()+"' method |" );
    }

    @AfterTest
    public void afterTest(){
        logger.info("|Finishing execution of test class");
    }
    @AfterSuite
    public void afterSuite(){
        logger.info("| Going to finish TestSuite and close driver |");
        AbstractPage.quiteAndCloseDriver();
        System.exit(0);
    }

    public MainPage navigateMainPage(){
       return  mainPage.navigateMainPage();
    }
}
