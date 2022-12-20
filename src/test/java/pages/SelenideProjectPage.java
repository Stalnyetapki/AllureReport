package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideProjectPage {

    @Step("Open '{project}' project")
    public SelenideProjectPage openPage(String project) {
        open(project);

        return this;
    }

    @Step("Open wiki tab")
    public SelenideProjectPage openWikiTab() {
        $("#wiki-tab").click();

        return this;
    }

    @Step("Check that 'Soft assertions' page exists in Wiki Tab")
    public SelenideProjectPage shouldBeSoftAssertionsPageInWikiTab() {
        $$("#wiki-pages-box .Box-row").shouldHave(itemWithText("SoftAssertions"));
        return this;
    }

    @Step("Check that 'Soft assertions' page exists in Wiki Tab")
    public SelenideProjectPage clickOnShowMorePageButton() {
        $(".Box-row button").click();

        return this;
    }

    @Step("Open '{pageName}' page in Wiki list")
    public SelenideProjectPage openPageFromWikiTab(String pageName) {
        $$("#wiki-pages-box .details-reset").findBy(text(pageName)).click();

        return this;
    }

    @Step("Check that page has example of code with '{frameworkName}' framework")
    public SelenideProjectPage shouldBeExampleOfCode(String frameworkName) {
        $$("h4").findBy(text(frameworkName)).sibling(0).shouldHave(cssClass("highlight"));

        return this;
    }

}
