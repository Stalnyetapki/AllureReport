package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GithubIssuesWebSteps {

    @Step("Открываем главную страницу")
    public GithubIssuesWebSteps openMainPage() {
        open("https://github.com/");

        return this;
    }

    @Step("Ищем и кликаем по ссылке в репозиторий: {repo}")
    public GithubIssuesWebSteps searchAndOpenRepository(String repo) {
        $("input[name=q]").setValue(repo).pressEnter();
        $(linkText(repo)).click();

        return this;
    }

    @Step("Переходим во вкладку Issues")
    public GithubIssuesWebSteps openIssuesTab() {
        $("#issues-tab").click();

        return this;
    }

    @Step("Проверяем наличие задачи {issuename} в репозитории")
    public GithubIssuesWebSteps shouldSeeIssueWithName(String issuename) {
        $$(".js-navigation-container a[data-hovercard-type=issue]").findBy(text(issuename)).shouldBe(visible);

        return this;
    }
}
