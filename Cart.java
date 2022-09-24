package org.example.Lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;
import java.util.List;

public class Cart extends BasePage {
    public Cart(WebDriver driver) {
        super(driver);
    }


    private static final String ButtonReadOrderInCartXpathLocator = "//button[contains(.,'К оформлению заказа')]";
    @FindBy(xpath = "//section[@data-testid='cart__list']//h3")
    private List<WebElement> OrderListIntoCar;

    @Step("Проверка наличия заказанной пиццы в корзине")
    public void CheckOrderInCart(String NameOrderinCart) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ButtonReadOrderInCartXpathLocator)));
        Assertions.assertEquals((OrderListIntoCar.stream().filter(d -> d.getText()
                        .contains(NameOrderinCart))
                .findFirst()
                .get()
                .getText()), NameOrderinCart);
    }


}
