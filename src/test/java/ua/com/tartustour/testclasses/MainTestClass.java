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

    @Test
    public void goToCruiseDetails() {
        mainPage = navigateMainPage();
        searchForm=mainPage.new SearchForm();
        /*String yes=searchForm.setRandomAvailableRegion();
        System.out.println("Chosen region/subregion: "+yes);
        resultPage=searchForm.performSearch();
        resultPage.goToRandomCruiseDetails();*/
        //searchForm.chooseRiverCruise();
        searchForm.setSpecifiedRegion("Европа");
        searchForm.setSpecifiedSubRegion("Европа");
        searchForm.setStartDateFieldAsCurrent();
        searchForm.setNextStartDateFieldCustomed("day",15);
        searchForm.openDetailsSearch();
        searchForm.hideDetailedSearch();
        searchForm.clearFilledData();
        searchForm.chooseSeaCruise();
        searchForm.goToSearchHistory();
        searchForm.returnToSearchFromHistory();
        searchForm.performSearch();
        TestHelper.waitSeconds(4);
    }

}

