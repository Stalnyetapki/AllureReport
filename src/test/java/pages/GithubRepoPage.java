package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GithubRepoPage {

    SelenideElement searchInput = $("input[name=q]"),
                    tabIssues = $("#issues-tab");
    ElementsCollection issuesList = $$(".js-navigation-container a[data-hovercard-type=issue]");

    public GithubRepoPage openPage() {
        open("");

        return this;
    }

    public GithubRepoPage searchAndOpenRepo(String name) {
        searchInput.setValue(name).pressEnter();
        $(linkText(name)).click();

        return this;
    }

    public GithubRepoPage findAndClickOnIssuesTab() {
        tabIssues.click();

        return this;
    }
    public GithubRepoPage checkIssueInIssuesList(String issueName) {
        issuesList.findBy(text(issueName)).shouldBe(visible);

        return this;
    }


}
