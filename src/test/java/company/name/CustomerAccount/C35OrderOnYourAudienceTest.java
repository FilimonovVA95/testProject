package company.name.CustomerAccount;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import company.name.character.clients.ClientForC35;
import company.name.listener.ScreenshotListener;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static company.name.helpers.DriverHelper.byTestId;
import static io.qameta.allure.Allure.step;


@Listeners({ScreenshotListener.class})
public class C35OrderOnYourAudienceTest {

    ClientForC35 user = new ClientForC35();
    private String deleteField = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Epic("1.Личный кабинет клиента")
    @Feature("1.5 Создание тестов")
    @Story("C35 1.5.6 Заказ теста на своей аудитории(веб-сайт), тариф 'Бесплатный'")
    @Description(value = "C35 1.5.6 Заказ теста на своей аудитории(веб-сайт), тариф 'Бесплатный'")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(description = "C35 1.5.6 Заказ теста на своей аудитории(веб-сайт), тариф 'Бесплатный'", groups = {"include", "C35", "1.5.6", "1.5"})
    public void OrderOnYourAudienceTest() {

        step("Step 1. Перейти на страницу сайта https://preprod.uxcrowd.ru/", () -> {
            Selenide.open(user.stand);
        });

        step("Step 2. Нажать кнопку 'Войти'", () -> {
            if ($(byTestId("Logout button")).isDisplayed())
                $(byTestId("Logout button")).click();
            $(byTestId("Login menu button")).click();
        });

        step("Step 3. Авторизируемся", () -> {
            $(byTestId("Email input")).shouldHave(visible);
            $(byTestId("Email input")).sendKeys(user.email);
            $(byTestId("Password input")).sendKeys(user.password);
            $(byTestId("Login button")).click();
        });

        step("Step 4. Нажать на 'Создать новый тест'", () -> {
            $(byTestId("New test client menu button")).click();
        });

        step("Step 5. Вводим название теста, адрес сайта и вводную информацию", () -> {
            $(byTestId("Test name input")).setValue(user.nameTest);
            $(byTestId("Address site input")).setValue(user.siteTest);
            $(byTestId("Information textarea")).setValue(deleteField);
            $(byTestId("Information textarea")).setValue(user.information);
        });

        step("Step 6. Нажать кнопку 'К выбору аудитории'", () -> {
            $(byTestId("Submit button")).click();
        });

        step("Step 7. Выбрать вкладку 'Найду пользователей сам' и ввести 3 пользователей", () -> {

         //   $(byTestId("Client users button")).click();
            $(byXpath("//div[@class='sc-uJMKN eAWZZu']//label[2]//div[1]")).click();
            $(byTestId("Users count input")).setValue(deleteField);
            $(byTestId("Users count input")).setValue("3");
            user.unusedTheirUsers -= 3;
        });

        step("Step 8. Нажать кнопку 'К заданиям'", () -> {
            $(byTestId("Tasks button")).click();
        });

        step("Step 9. Добавить задания", () -> {
            $(byTestId("Tasks task question")).setValue("Опишите свое первое впечатление от сайта.");
            $(byTestId("Tasks submit task")).click();

            $(byXpath("//label[2]//div[1]")).click();
//            $(byTestId("Tasks type switcher_1")).click();
            $(byTestId("Tasks task question")).setValue("Я буду часто использовать этот сайт.");
            $(byTestId("Tasks rating variant 0")).setValue("Совершенно не согласен");
            $(byTestId("Tasks rating variant 1")).setValue("Полностью согласен");
            $(byTestId("Tasks submit task")).click();

            $(byXpath("//label[3]//div[1]")).click();
//            $(byTestId("Tasks type switcher_2")).click();
            $(byTestId("Tasks task question")).setValue("Удалось ли вам выполнить задание?");
            $(byTestId("Tasks variant 0")).setValue("Да");
            $(byTestId("Tasks variant 1")).setValue("Нет");
            $(byTestId("Tasks variant 2")).setValue("Не уверен");
            $(byTestId("Tasks submit task")).click();

            $(byXpath("//label[4]//div[1]")).click();
//            $(byTestId("Tasks type switcher_3")).click();
            $(byTestId("Tasks task question")).setValue("Какие типы мобильных приложений вы используете чаще всего?");
            $(byTestId("Tasks variant 0")).setValue("Социальные сети");
            $(byTestId("Tasks variant 1")).setValue("Игры/развлечения");
            $(byTestId("Tasks variant 2")).setValue("Новости");
            $(byTestId("Tasks variant 3")).setValue("Погода");
            $(byTestId("Tasks variant 4")).setValue("Карты");
            $(byTestId("Tasks variant 5")).setValue("Планирование (календарь, список дел)");
            $(byTestId("Tasks variant 6")).setValue("Инструменты (калькулятор, переводчик, словарь и т. п.)");
            $(byTestId("Tasks variant 7")).setValue("Другие");
            $(byTestId("Tasks submit task")).click();

            $(byXpath("//label[5]//div[1]")).click();
//            $(byTestId("Tasks type switcher_4")).click();
            $(byTestId("Tasks task question")).setValue("Какими тремя словами можно лучше всего описать этот сайт?");
            $(byTestId("Tasks submit task")).click();

            // Не добавлена метрика т.к. нет testId
        });

        step("Step 10. Нажать на кнопку 'Проверка и запуск'", () -> {
            $(byTestId("Check button")).click();

            // Проверка параметров не выполнена т.к. нет определенности какие именно параметры проверять, а так же
            // отсутсвуют testId на полях, которые необходимо проверить
        });

        step("Step 11. Нажать кнопку 'Запустить бесплатный тест'", () -> {
            $(byTestId("Checkout start button")).click();
        });
    }

    @AfterMethod
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

}
