package ua.com.tartustour.pages.locators;

/**
 * Created by Administrator on 11/5/2016.
 */
public class LoginPageConstants {
    public static final String PAGE_TITLE="Вход пользователя";
    public static final String EMAIL_FIELD=".//*[@id='email']";
    public static final String PASSWORD_FIELD=".//*[@id='password']";
    public static final String REMEMBER_CHECKBOX=".//input[@value='Remember Me']";
    public static final String LOGIN_BUTTON=".//button[@translate='Login']";
    public static final String REGISTRATION_LINK=".//a[contains(text(),'Регистрация')]";
    public static final String FORGOT_PASS_LINK=".//a[contains(text(),'Забыли пароль?')]";
    public static final String BACK_TO_HOMEPAGE=".//a[contains(text(),'На главную')]";
}
