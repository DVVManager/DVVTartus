package ua.com.tartustour.pages.locators;

/**
 * Created by Administrator on 12/9/2016.
 */
public class CruiseDetailsPageConstants {

    public static final String CRUISE_NAME=".//span[@class='cruise-title']";
    public static final String CRUISE_DURATION=".//ul[@class='short-info']/li[@class='term']//span[@class='nights-number']";
    public static final String CRUISE_PRICE=".//ul[@class='short-info']/li[@class='price-wrap']/span[contains(@class,'price')]";
    public static final String CRUISE_ID=".//span[@class='article xs-hidden']";
    public static final String CRUISE_FIRST_PORT=".//li[@class='from-place']/div/span[@class='city']";
    public static final String CRUISE_BOOK_BUTTON=".//a[@class='book']";
    public static final String CRUISE_ROUTE_SETION=".//a[@title='Программа маршрута']";
    public static final String CRUISE_DATE_PRICE_SECTION=".//a[@title='Дата и стоимость']/span";
    public static final String CRUISE_SHIP_SECTION=".//a[@title='Лайнер']/span";
    public static final String CRUISE_FEEDBACK_SECTION=".//a[@title='Отзывы']/span";
}


