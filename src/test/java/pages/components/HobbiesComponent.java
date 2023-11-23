package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {
    public void setHobbies(String value1, String value2, String value3) {
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
    }
}
