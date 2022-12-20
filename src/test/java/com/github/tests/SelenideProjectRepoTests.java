package com.github.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SelenideProjectPage;

import static com.github.tests.TestData.selenideUrlProject;

public class SelenideProjectRepoTests extends TestBase{

    SelenideProjectPage selenideProjectPage = new SelenideProjectPage();

    @Test
    @Feature("Wiki page")
    @Story("'Soft assertions' content availability")
    @Owner("Aleksei Tupikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check existing of JUnit5 example code in 'Soft assertions' page from Wiki tab")
    void checkExistingOfJUnitExampleCodeInSoftAssertionsPageTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        selenideProjectPage.openPage(selenideUrlProject)
                .openWikiTab()
                .clickOnShowMorePageButton()
                .shouldBeSoftAssertionsPageInWikiTab()
                .openPageFromWikiTab("SoftAssertions")
                .shouldBeExampleOfCode("JUnit5");

    }
}
