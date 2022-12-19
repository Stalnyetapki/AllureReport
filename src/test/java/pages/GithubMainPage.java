package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GithubMainPage {

    @Step("Open main page")
    public GithubMainPage openMainPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Open '{item}' header menu item")
    public GithubMainPage openMenuItem(String item) {
        $$(".HeaderMenu-link").find(text(item)).hover();

        return this;
    }

    @Step("Open '{page}' link from header open menu")
    public GithubMainPage openPageByMenuList(String item, String text) {
        $$(".HeaderMenu-dropdown-link").find(text(item)).click();
        $(".application-main").shouldHave(text(text));
        return this;
    }

}
