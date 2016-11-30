package ua.com.tartustour.testclasses;

import org.testng.annotations.Test;
import ua.com.tartustour.framemanagers.TestManager;
import ua.com.tartustour.pages.LoginPage;
import ua.com.tartustour.pages.MainPage;
import ua.com.tartustour.pages.ProfilePage;
import ua.com.tartustour.pages.SearchResultPage;
import ua.com.tartustour.utils.TestHelper;

/**
 * Created by Administrator on 11/5/2016.
 */

public class MainTestClass extends TestManager {

    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    MainPage.SearchForm searchForm;
    SearchResultPage resultPage;

/*
    @Test
    public void login() {
        mainPage = navigateMainPage();
        loginPage = mainPage.goToLoginPage();
        profilePage = loginPage.login("dvvmanager@gmail.com", "p110892dvv", false);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Interrupted");
        }

    }*/

    @Test
    public void goToCruiseDetails() {
        mainPage = navigateMainPage();
        searchForm=mainPage.new SearchForm();
        //resultPage=searchForm.performSearch();
        //resultPage.goToRandomCruiseDetails();
        searchForm.setStartDateFieldAsCurrent();
        searchForm.setNextStartDateFieldCustomed("day",2);

    }

}

