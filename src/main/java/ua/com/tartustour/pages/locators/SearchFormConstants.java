package ua.com.tartustour.pages.locators;

/**
 * Created by Administrator on 11/29/2016.
 */
public class SearchFormConstants {

    public static final String SEARCH_BUTTON=".//*[@class='submit' and @value='Поехали']";
    public static final String CRUISE_SEA_CATEGORY=".//input[@name='cruiseCategoryTypeId']/following-sibling::label[contains(.,'Морской круиз')]";
    public static final String CRUISE_RIVER_CATEGORY=".//input[@name='cruiseCategoryTypeId']/following-sibling::label[contains(.,'Речной круиз')]";
    public static final String CRUISE_REGION=".//input[@class='text region-text']";
    public static final String CRUISE_REGION_DEFAULT=".//div[@class='select-drop popup']/div[@class='other-reg']/input";
    public static final String CRUISE_REGION_LIST=".//ul[@class='reg-list']/li";
    public static final String CRUISE_START_DATE=".//input[@class='text date-text start-date hasDatepicker']";
    public static final String CRUISE_NEXT_START_DATE=".//input[@class='text date-text end-date hasDatepicker']";
    public static final String DETAILED_SEARCH_BUTTON=".//a[@class='detailed-search search-show-details-btn']";
    public static final String CLEAR_SEARCH_BUTTON=".//a[@class='detailed-search clean-search']";
    public static final String HISTORY_BUTTON=".//a[@class='detailed-search search-history']";
}
