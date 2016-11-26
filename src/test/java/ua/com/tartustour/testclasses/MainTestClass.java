package ua.com.tartustour.testclasses;

import org.testng.annotations.Test;
import ua.com.tartustour.framemanagers.TestManager;
import ua.com.tartustour.pages.LoginPage;
import ua.com.tartustour.pages.MainPage;
import ua.com.tartustour.pages.ProfilePage;

/**
 * Created by Administrator on 11/5/2016.
 */

public class MainTestClass extends TestManager {

    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;

        @Test
        public void testM() {
            mainPage=navigateMainPage();
            loginPage=mainPage.goToLoginPage();
            profilePage=loginPage.login("dvvmanager@gmail.com", "p110892dvv", false);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

