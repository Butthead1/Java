package Page_Test;

import com.codeborne.selenide.Selenide;
import common.BaseElements;
import common.UrlStrings;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class Page_TestUI {
    // Необходимо добавить свой логин и пароль в 20 и 22 строку, обязательно!
    public void testYandex() throws InterruptedException {
        Selenide.open(UrlStrings.YANDEX);
        $(byXpath(BaseElements.Class("dzen-header-desktop__profileMenuButton-3D dzen-header-desktop__isUnauthorized-2e"))).click();
        $(byXpath(BaseElements.Class("login-content__yaButtonWrapper-15"))).click();
        $(byXpath(BaseElements.Input("login"))).setValue("     "); // Необходимо ввести свой логин
        $(byXpath(BaseElements.Class("Button2 Button2_size_l Button2_view_action Button2_width_max Button2_type_submit"))).click();
        $(byXpath(BaseElements.Input("passwd"))).setValue("     "); // Необходимо ввести свой пароль
        $(byXpath(BaseElements.Class("Button2 Button2_size_l Button2_view_action Button2_width_max Button2_type_submit"))).click();
        Thread.sleep(2000);
        Selenide.open("https://mail.yandex.ru/");
        Thread.sleep(3000);
        $(byXpath(BaseElements.Class("PSHeaderIcon-Image PSHeaderIcon-Image_Mail PSHeaderIcon-Image_theme_light PSHeaderIcon-Image_lang_ru"))).shouldBe(visible).click();
    }
    public void testGoogle() {
        Selenide.open(UrlStrings.GOOGLE);
        $(byXpath(BaseElements.Input("q"))).setValue("купить кофемашину bork c804").pressEnter();
        for (int i = 1; i <= 10; i++)
        {
            String s = $(byXpath("(//div[@class='yuRUbf']/a)[" + i +"]")).getAttribute("href");
            if (s.contains("mvideo.ru") == true) break;
            if ( i == 10)
            {
                Assert.fail("Ссылки 'mvideo.ru' нет на странице");
            }
        }
        if ($$x("//*[@id='rso']/div").size() < 10)
        {
            Assert.fail("На странице меньше 10 элементов");
        }
    }
}
