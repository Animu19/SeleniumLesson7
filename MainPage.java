package org.example.Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@id='pizzas']//article")
    private List<WebElement> PizzaList;


    @FindBy(xpath = "//button")
    private WebElement ButtonSelectProduct;

    @FindBy(xpath = "//button[text()='Корзина']")
    private WebElement ButtonIntoToCart;

    @Step("Выбор пиццы по названию")
    public SelectioIngredientsForPizza SelectOrderByName(String productName) {
        PizzaList.stream().filter(d -> d.getText()
                        .contains(productName))
                .findFirst()
                .get()
                .click();
        return new SelectioIngredientsForPizza(driver);
    }

    @Step("Нажатие на кнопку 'Корзина'")
    public Cart OpenCart() {
        ButtonIntoToCart.click();
        return new Cart(driver);
    }


}
