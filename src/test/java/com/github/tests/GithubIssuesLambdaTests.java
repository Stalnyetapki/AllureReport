package com.github.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GithubIssuesLambdaTests {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final String ISSUENAME = "e.sh";


    @Test
    @Feature("Issues в репозитории")
    @Story("Работа вкладки Issues")
    @Owner("Aleksei Tupikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия задач в выбранном репозитории")
    void checkIssuesTabInRepoByLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем и переходим в репозиторий: " + REPOSITORY, () -> {
            $("input[name=q]").setValue(REPOSITORY).pressEnter();
            $(linkText(REPOSITORY)).click();
        });
        step("Переходим во вкладку Issues '" + REPOSITORY + "' репозитория", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие задачи '" + ISSUENAME + "' в репозитории '" + REPOSITORY + "'", () -> {
            $$(".js-navigation-container a[data-hovercard-type=issue]").findBy(text(ISSUENAME)).shouldBe(visible);

        });

    }
}
