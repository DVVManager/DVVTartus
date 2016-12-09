package ua.com.tartustour.pages.locators;

/**
 * Created by Administrator on 11/30/2016.
 */
public class SearchResultPageConstants {
    public static final String VIEW_AS_TABLE=".//ul[@class='view-list']//a[contains(.,'Таблица')]";
    public static final String VIEW_AS_MAP=".//ul[@class='view-list']//a[contains(.,'Карта')]";
    public static final String SORT_ITEM_LIST="sortItemsList";//id locator
    public static final String CRUISE_DETAILS_BUTTON="//a[@class='details']";
    public static final String EMPTY_RESULT=".//section[@class='content']";

    public static final String CRUISE_NAMES_LIST=".//div[@class='title-holder']/a[@class='cruise-title']";
    public static final String CRUISE_NAME=".//a[@class='cruise-title' and contains(.,'%s')]";
    public static final String CRUISE_ID=".//span[@class='article' and contains(.,'%s')]";
    public static final String RESULT_TABLE_RESULTS="//div[@id='tab-table']/div";
    public static final String CRUISE_APPEND_NAME=".//a[@class='cruise-title']";
    public static final String CRUISE_APPEND_DURATION=".//ul[@class='short-info']/li[@class='term']//span[@class='nights-number']";
    public static final String CRUISE_APPEND_PRICE=".//ul[@class='short-info']/li[@class='price-wrap']/span[contains(@class,'price')]";
    public static final String CRUISE_APPEND_ID=".//ul[@class='short-info']/following-sibling::span[@class='article']";

    public static final String PAGES_COUNT=".//div[@class='paging']/ul/li[last()-1]/a";
    public static final String RESULT_TABLE_PAGE=".//div[@id='tab-table']/following-sibling::div//div[@class='paging']/ul/li[position()=%d]/a";
    public static final String CURRENT_PAGE=".//div[@id='tab-table']/following-sibling::div//div[@class='paging']//li[@class='active']/a";
    public static final String NEXT_PAGE_ARROW=".//div[@id='tab-table']/following-sibling::div//div[@class='paging']//li[contains(@class,'next')]/a";
    public static final String PREV_PAGE_ARROW=".//div[@id='tab-table']/following-sibling::div//div[@class='paging']//li[contains(@class,'prev')]/a";

    public static final String COMPARE_BY_NAME="./parent::div/following-sibling::div/a[@class='compare']/span";
    public static final String COMPARE_BY_ID="./following-sibling::a[@class='compare']/span";
    public static final String IN_COMPARISON_BY_NAME="./parent::div/following-sibling::div/span[@class='compare']";
    public static final String IN_COMPARISON_BY_ID="./following-sibling::span[@class='compare']";
    public static final String CRUISES_IN_COMPARISON_ICON=".//a[@class='compare-ico']";
}
