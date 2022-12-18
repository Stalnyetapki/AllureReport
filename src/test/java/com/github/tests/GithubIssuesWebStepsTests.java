package com.github.tests;

import org.junit.jupiter.api.Test;
import pages.GithubIssuesWebSteps;

public class GithubIssuesWebStepsTests {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final String ISSUENAME = "e.sh";

    GithubIssuesWebSteps githubIssuesWebSteps = new GithubIssuesWebSteps();

    @Test
    void checkIssuesTabInRepoByWebStepsTest() {
        githubIssuesWebSteps.openMainPage()
                .searchAndOpenRepository(REPOSITORY)
                .openIssuesTab()
                .shouldSeeIssueWithName(ISSUENAME);

    }
}
