package com.github.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.GithubRepoPage;

public class TestBase {

    GithubRepoPage githubRepoPage = new GithubRepoPage();

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }
}
