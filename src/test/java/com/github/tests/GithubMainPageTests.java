package com.github.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GithubMainPage;

import static com.github.tests.TestData.*;

public class GithubMainPageTests extends TestBase{

    GithubMainPage githubMainPage = new GithubMainPage();

    @Test
    @Feature("Main page")
    @Story("User go to Enterprise page by header menu")
    @Owner("Aleksei Tupikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check the availability to go Enterprise page by header menu")
    void goToEnterprisePageByHeaderMenuTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        githubMainPage.openMainPage()
                .openMenuItem(headerMenuItemList.get(1))
                .openPageByMenuList(solutionMenuItemList.get(0), enterpriseMainLogoText);


    }
}
