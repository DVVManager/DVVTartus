package ua.com.tartustour.pages.locators;

/**
 * Created by Administrator on 11/29/2016.
 */
public class SearchFormConstants {

    public static final String SEARCH_BUTTON=".//input[@class='submit' and @value='Поехали']";
    public static final String CRUISE_SEA_CATEGORY=".//input[@name='cruiseCategoryTypeId']/following-sibling::label[contains(.,'Морской круиз')]";
    public static final String CRUISE_RIVER_CATEGORY=".//input[@name='cruiseCategoryTypeId']/following-sibling::label[contains(.,'Речной круиз')]";
    public static final String CLEAR_SEARCH_BUTTON=".//a[@class='detailed-search clean-search']";
    public static final String HISTORY_BUTTON=".//a[@class='detailed-search search-history']";
    public static final String DETAILED_SEARCH_BUTTON=".//a[@class='detailed-search search-show-details-btn']";
    public static final String HIDE_DETAILED_SEARCH_BUTTON=".//a[@class='detailed-search search-hide-details-btn']";
    public static final String BACK_TO_SEARCH=".//a[@class='back-to-search']/span";

    public static final String CRUISE_REGION=".//input[@class='text region-text']/following-sibling::a";
    public static final String CRUISE_REGION_DEFAULT=".//div[@class='select-drop popup']/div[@class='other-reg']/input";
    public static final String CRUISE_REGION_LIST=".//ul[@class='reg-list']/li/input[@data-type='continentIds']";
    public static final String CRUISE_REGION_SPECIFIED=".//input[@data-type='continentIds' and @data-value='%s']";
    public static final String CRUISER_SUB_REGION_LIST=".//ul[@class='inner-drop']/li/input[@data-type='regionIds']";
    public static final String CRUISE_SUBREGION_SPECIFIED=".//ul[@class='inner-drop']//input[@data-type='regionIds' and @data-value='%s']";
    public static final String CRUISE_START_DATE=".//input[@class='text date-text start-date hasDatepicker']";
    public static final String CRUISE_NEXT_START_DATE=".//input[@class='text date-text end-date hasDatepicker']";
    public static final String CRUISE_PORT=".//input[@class='text city-text']/following-sibling::a";
    public static final String CRUISE_PORT_LIST=".//ul[@class='reg-list']/li/input[@data-type='regionIds']";
    public static final String CRUISE_PORT_REGION=".//ul[@class='reg-list']/li/input[@data-type='regionIds' and @data-value='%s']";
    public static final String CRUISE_PORT_CITIES_LIST=".//ul[@class='inner-drop']/li/input[@data-type='cityIds']";
    public static final String CRUISE_PORT_CITY=".//input[@data-type='cityIds' and @data-value='%s']";
    public static final String RIVER_FIELD="riverId";//id locator

    public static final String COMPANY_FIELD=".//input[@class='text company-text']/following-sibling::a";
    public static final String COMPANY_CATEGORY_LIST=".//input[@data-type='companyCategoryId']";///following-sibling::label
    public static final String COMPANY_CATEGORY=".//input[@data-type='companyCategoryId' and @data-value='%s']";
    public static final String COMPANY_NAME_LIST=".//ul[@class='inner-drop']/li/input[@data-type='companyId']/following-sibling::label";
    public static final String COMPANY_NAME=".//ul[@class='inner-drop']/li/input[@data-type='companyId' and @data-value='%s']";

    public static final String CURRENCY_DROPDOWN="currencyId";//id locator
    public static final String PRICE_SLIDE=".//input[@id='fader' and @name='price']";
    public static final String PRICE_SLIDE_BAR="fader";//id locator
    public static final String RUSSIAN_GROUP=".//input[@name='ruGroup']/following-sibling::label";
    public static final String SALES_ONLY=".//input[@name='sale']/following-sibling::label";
    public static final String CHILDREN_FREE=".//input[@name='children']/following-sibling::label";





}
