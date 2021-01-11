package oppabet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Elements {

    public static void EnterDataToRegisterForm(String email, String firstName, String surname, String password) {
        $(By.xpath("//div[@class='c-registration']")).shouldBe(visible);
        $(By.xpath("//input[@id='popup_registratio_email']")).setValue(email);
        $(By.xpath("//input[@id='popup_registratio_name']")).setValue(firstName);
        $(By.xpath("//input[@id='popup_registratio_surname']")).setValue(surname);
        $(By.xpath("//input[@id='popup_registratio_password']")).setValue(password);
        $(By.xpath("//input[@id='popup_registratio_password_again']")).setValue(password);
        $(By.xpath("//div[@class='c-registration__button button button_light submit_registration']")).click();
    }

    public static void verifyLoginDialog() {
        $(By.xpath("//input[@id='userPasswordFast']")).shouldBe(not(Condition.empty));
        $(By.xpath("//input[@placeholder='Your ID']")).shouldBe(not(Condition.empty));
        $(By.xpath("//button[@class='c-registration__button']")).click();
    }

    public static void verifyDataInMyAccount(String email, String firstName, String surname, String password) {
        $(By.xpath("//button[contains(@class,'auth-button auth-button--block')]")).click();
        $(By.xpath("//a[@class='submenu_link ']")).click();
        $(By.xpath("//div[@class='box-modal_close arcticmodal-close']")).click();
        $(By.xpath("(//span[@class='apm-form-value__text'])[4]")).shouldHave(text(email));
        $(By.xpath("(//span[@class='apm-form-value__text'])[5]")).shouldHave(text(surname));
        $(By.xpath("(//span[@class='apm-form-value__text'])[6]")).shouldHave(text(firstName));
        $(By.xpath("(//span[@class='apm-form-value__text'])[2]")).shouldBe(not(Condition.empty));
    }
}
