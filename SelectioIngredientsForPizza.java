package org.example.Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class SelectioIngredientsForPizza extends BasePage {


    public SelectioIngredientsForPizza(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@data-testid, \"size\")]")
    private List<WebElement> SizePizzaList;

    @FindBy(xpath = "//*[contains(@data-testid, \"dough\")]")
    private List<WebElement> TestoSizeList;

    @FindBy(xpath = "(//button[@data-selected='false'])")
    private List<WebElement> IngredientsList;

    @FindBy(xpath = "//button[@data-size='big']")
    private WebElement ButtonAddToCart;

    @Step("Выбор размер пиццы")
    public SelectioIngredientsForPizza SelectSizePizza(String SizePizza) {
        SizePizzaList.stream().filter(d -> d.getText()
                        .contains(SizePizza))
                .findFirst()
                .get()
                .click();
        return new SelectioIngredientsForPizza(driver);
    }

    @Step("Выбор толщены теста для пиццы")
    public SelectioIngredientsForPizza SelectTestoSize(String TestoSize) {
        TestoSizeList.stream().filter(d -> d.getText()
                        .contains(TestoSize))
                .findFirst()
                .get()
                .click();
        return new SelectioIngredientsForPizza(driver);
    }

    @Step("Выбор дополнительной начинки для пиццы")
    public SelectioIngredientsForPizza SelectIngredients(String IngredientsName) {
        IngredientsList.stream().filter(d -> d.getText()
                        .contains(IngredientsName))
                .findFirst()
                .get()
                .click();
        return new SelectioIngredientsForPizza(driver);
    }

    @Step("Нажатие на кнопку 'Добавить в корзину'")
    public MainPage ButtonAddToCart() {
        ButtonAddToCart.click();
        return new MainPage(driver);
    }


}
