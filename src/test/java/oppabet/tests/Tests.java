package oppabet.tests;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import oppabet.Elements;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Tests {

    @BeforeClass
    public void setUp() {
        Configuration.startMaximized = true;

    }


    @Test
    public void registerByEmail() {
        open("https://www.oppabet.com/");
        $(By.xpath("//span[@class='register_button_main']")).click();
        Elements.EnterDataToRegisterForm("work19@gmail.com", "Maksim", "Samol", "Maks1999");
        Elements.verifyLoginDialog();
        Elements.verifyDataInMyAccount("work19@gmail.com", "Maksim", "Samol", "Maks1999");
    }

}
