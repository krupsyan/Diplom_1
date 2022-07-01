package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Mock
    Burger burger;

    @Test

    public void setBunsSetsCorrectValue() {
        //Arrange
        Burger burger = new Burger();
        Bun bun = new Bun("с маком", 1.01f);

        //Act
        burger.setBuns(bun);

        //Assert
        assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredientWorksCorrectly() {
        //Arrange
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "горчичный", 1.0f);

        //Act
        burger.addIngredient(ingredient);
        Ingredient actualIngredient = burger.ingredients.get(0);

        //Assert
        assertEquals(actualIngredient, ingredient);
    }

    @Test
    public void removeIngredientWorksCorrectly() {
        //Arrange
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "горчичный", 1.0f);

        //Act
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        //Assert
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientWorksCorrectly() {
        //Arrange
        Burger burger = new Burger();
        Ingredient firstIngredient = new Ingredient(SAUCE, "горчичный", 1.01f);
        Ingredient secondIngredient = new Ingredient(FILLING, "перчик", 1.02f);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        //Act
        burger.moveIngredient(0, 1);
        Ingredient actualFirstIngredient = burger.ingredients.get(0);
        Ingredient actualSecondIngredient = burger.ingredients.get(1);

        //Assert
        assertEquals(firstIngredient, actualSecondIngredient);
        assertEquals(secondIngredient, actualFirstIngredient);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        //Arrange
        Burger burger = new Burger();
        float expectedPrice = 6.032f;

        Mockito.when(bun.getPrice()).thenReturn(2.001f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(1.01f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(1.02f);

        //Act
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        float actualPrice = burger.getPrice();

        //Assert
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptReturnsCorrectValue() {
        //Arrange
        Burger burger = new Burger();
        String expectedReceipt = "(==== с кунжутом ====)\n" +
                "= sauce горчичный =\n" +
                "= filling перчик =\n" +
                "(==== с кунжутом ====)\n" +
                "\n" +
                "Price: 6.032000" +
                "\n";

        Mockito.when(bun.getName()).thenReturn("с кунжутом");
        Mockito.when(firstIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(secondIngredient.getType()).thenReturn(FILLING);
        Mockito.when(firstIngredient.getName()).thenReturn("горчичный");
        Mockito.when(secondIngredient.getName()).thenReturn("перчик");
        Mockito.when(bun.getPrice()).thenReturn(2.001f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(1.01f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(1.02f);

        //Act
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String actualReceipt = burger.getReceipt();

        //Assert
        assertEquals(expectedReceipt, actualReceipt);
    }
}
