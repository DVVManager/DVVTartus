package ua.com.tartustour.pages.locators;

/**
 * Created by Administrator on 12/9/2016.
 */
public class BookingPageLocators {
    //BOOKING PAGE HEADER
    public static final String BACK_TO_CRUISE=".//ul[@class='order-progress']//a[contains(.,'Круизы')]";
    public static final String CURRENT_STEP=".//ul[@class='order-progress']/li[@class='current-step']//span";
    public static final String PASSANGERS_STEP=".//ul[@class='order-progress']//span[contains(.,'Пассажиры')]";
    public static final String CABIN_STEP=".//ul[@class='order-progress']//span[contains(.,'Каюты')]";
    public static final String SERVICES_STEP=".//ul[@class='order-progress']//span[contains(.,'Услуги')]";
    public static final String BOOKING_STEP=".//ul[@class='order-progress']//span[contains(.,'Бронирование')]";
    public static final String FINAL_STEP=".//ul[@class='order-progress']//span[contains(.,'Готово')]";

    //PASSANGERS STEP 1
    public static final String CABIN_BY_NUM=".//ul[@class='rooms-select']//span[contains(.,'%d')]";
    public static final String CABIN_LIST=".//ul[@class='rooms-select']//span";

    public static final String ADULT_PERSON_BUTTON=".//ul[@class='person-select person1']//label[@for='adult-%d']";
    public static final String AGED_PERSON_BUTTON=".//ul[@class='person-select person2']//label[@for='aged-%d']";
    public static final String CHILDREN_PERSON_BUTTON=".//ul[@class='person-select person3']//label[@for='children-%d']";
    public static final String BABY_PERSON_BUTTON=".//ul[@class='person-select person4']//label[@for='baby-%d']";

    public static final String CHILDREN_AGE_DROPDOWN="childrenAges-1";//id locator
    public static final String BABIES_AGE_DROPDOWN="babyAges-1";//id locator
    public static final String GO_TO_CABIN_CHOOSE_STEP=".//input[@value='Перейти к выбору кают']";

    public static final String CRUISE_NAME=".//span[@class='cruise-title']";
    public static final String CURRENCY_TYPES=".//span[@class='passengers-info']/label[contains(.,'%s')]";
    //CABIN STEP 2

    public static final String ALL_CABINS_CATEGORIES=".//div[@class='room-box inner-room']/h3";
    public static final String ALL_CABINS_NAMES=".//div[@class='title-wrap']/span[@class='title']";

    public static final String ALL_CABINS_CHOOSE_BUTTON=".//div[@class='price-wrap']/label";
    public static final String APPEND_BY_BUTTON_TYPE="/a[contains(.,'%s')]";
    public static final String ALL_CABINS_WITH_PRICE=".//div[@class='price-wrap']/span[not(@style)and contains(.,'%s')]";
    public static final String APPEND_BY_PRICE="/following-sibling::label/a";

    public static final String CONFIRM_CHOSEN_CABIN=".//button[contains(.,'Выбрать эту каюту')]";
    public static final String RETURN_TO_CABINS=".//div[@class='order-tabs-wrap'][1]/a[@class='prev-step']";
    //SERVICE STEP 3
    public static final String GO_TO_PASSANGERS_DATA=".//input[contains(@value,'Ввести')]";
    //PASSANGERS DATA STEP 4
    public static final String SECOND_NAME=".//input[contains(@name,'[%d].surname')]";
    public static final String NAME=".//input[contains(@name,'[%d].name')]";
    public static final String BIRTHDAY=".//input[contains(@name,'[%d].birthDay')]";
    public static final String SELECT_COUNTRY=".//select[contains(@class,'countries-list')]";
    public static final String DOCUMENT_NUM=".//span[contains(.,'документа')]/following-sibling::input[contains(@name,'[%d].document')]";
    public static final String DOCUMENT_VALIDITY=".//input[contains(@name,'[%d].documentDate')]";
    public static final String PAY_AS_AGENCY=".//label[@for='client-type-agency']";
    public static final String PAY_AS_PRIVATE=".//label[@for='client-type-private']";
    public static final String CUSTOMER_SURNAME=".//input[@name='customer.surname']";
    public static final String CUSTOMER_NAME=".//input[@name='customer.name']";
    public static final String CUSTOMER_PHONE=".//input[@name='customer.phone']";
    public static final String CUSTOMER_EMAIL=".//input[@name='customer.email']";
    public static final String CUSTOMER_COMMENT=".//input[@name='customer.comment']";
    public static final String BOOK_CRUISE=".//input[contains(@value,'забронировать')]";

}
