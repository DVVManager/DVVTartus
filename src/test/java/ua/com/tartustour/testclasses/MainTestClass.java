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


     /*   searchForm.setSpecifiedRegion("Европа");
        searchForm.setSpecifiedSubRegion("Европа");
        searchForm.setStartDateFieldAsCurrent();
        searchForm.setNextStartDateFieldCustomed("day", 15);
        searchForm.openDetailsSearch();
        searchForm.hideDetailedSearch();
        searchForm.clearFilledData();
        searchForm.chooseSeaCruise();
        searchForm.goToSearchHistory();
        searchForm.returnToSearchFromHistory();
        searchForm.performSearch();
        searchForm.openDetailsSearch();
        searchForm.chooseRiverCruise();
        searchForm.setSecifiedPortRegion("Европа");
        searchForm.setSpecifiedCity("Страсбург");
        searchForm.chooseWithFreeForChildren();
        searchForm.chooseWithRussianGroup();
        searchForm.chooseWithSales();
        searchForm.setRandomAvailableCompany();
        searchForm.setCurrency("RUB");
        searchForm.setPrice(10);
        searchForm.performSearchWithEmptyResult();*/
        resultPage=searchForm.performSearch();
        //resultPage.getFoundCruisCards().forEach(s-> System.out.println(s.toString()));
        //resultPage.moveToResultPage(2);
        //resultPage.moveToResultPageWithArrow(1);
        /*resultPage.sortByPriceDesc();
        resultPage.sortByDateAsc();
        resultPage.sortByPriceAsc();
        resultPage.sortByDateDesc();*/
        resultPage.addToCompareCruiseWithId("518215");
        System.out.println(resultPage.getCruisesInComparisonCount());
        resultPage.goToComparePage();

        TestHelper.waitSeconds(4);
    }

}

