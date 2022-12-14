package com.github.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class GithubIssuesTests extends TestBase {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final String ISSUENAME = "e.sh";

    @Test
    void checkIssuesTabInRepoTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        githubRepoPage
                .openPage()
                .searchAndOpenRepo(REPOSITORY)
                .findAndClickOnIssuesTab()
                .checkIssueInIssuesList(ISSUENAME);

    }
}
