package com.github.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.GithubIssuesWebSteps;

import static io.qameta.allure.Allure.step;

public class GithubIssuesWebStepsTests {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final String ISSUENAME = "e.sh";

    GithubIssuesWebSteps githubIssuesWebSteps = new GithubIssuesWebSteps();

    @Test
    void checkIssuesTabInRepoByWebStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        githubIssuesWebSteps.openMainPage()
                .searchAndOpenRepository(REPOSITORY)
                .openIssuesTab()
                .shouldSeeIssueWithName(ISSUENAME);

    }
}
