package ua.com.tartustour.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 11/6/2016.
 */
@Component
@Lazy
public class RestorePage extends LoginPage {

    @Autowired
    public RestorePage(WebDriver beanDriver) {
        super(beanDriver);
    }

    @Override
    public void isLoaded(){

    }

    @Override
    public void load(){

    }
}
