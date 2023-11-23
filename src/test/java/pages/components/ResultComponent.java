package pages.components;

import com.codeborne.selenide.Condition;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    public ResultComponent checkResult(String key, String value) {
        $(".table-responsive").shouldHave(text(value));
        return this;
    }
    public ResultComponent negativeResult() {
        $(".table-responsive").shouldNotBe(Condition.visible);
        return this;
    }
}
