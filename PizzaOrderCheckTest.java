package org.example.Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.example.Lesson7.AdditionalLogger;
import org.example.Lesson7.JunitExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

@Story("Добавление в корзину")
public class PizzaOrderCheckTest {

    WebDriver driver;


    @RegisterExtension
    JunitExtension testWatcher = new JunitExtension();


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        driver.get("https://dodopizza.ru/moscow");
        driver.manage().window().fullscreen();
    }

    @AfterEach
    void killbrowser() {
        testWatcher.setScreenshot(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }

    @Test
    @Feature("Корзина")
    @TmsLink("ТестКейс1")
    @Issue("Jira1")
    @DisplayName("Проверка добавления заказанной пиццы в корзину")
    void orderPizzaAndCheckCart() {
        new MainPage(driver).SelectOrderByName("Пепперони фреш")
                .SelectSizePizza("Маленькая")
                .SelectTestoSize("Традиционное")
                .SelectIngredients("Ветчина")
                .SelectIngredients("Свежие томаты")
                .ButtonAddToCart().OpenCart().CheckOrderInCart("Пепперони фреш");
    }


}
