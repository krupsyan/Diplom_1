package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final IngredientType actualType;

    public IngredientTest(IngredientType ingredientType, IngredientType actualType) {
        this.ingredientType = ingredientType;
        this.actualType = actualType;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeByIngredientType() {
        return new Object[][] {
                //IngredientType       //Result
                {SAUCE,                 SAUCE},
                {FILLING,               FILLING},
        };
    }

    @Test
    public void getNameReturnsCorrectValue() {
        //Arrange
        Ingredient ingredient = new Ingredient(ingredientType, "горчичный", 1.0f);
        String expectedName = "горчичный";

        //Act
        String actualName = ingredient.getName();

        //Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        //Arrange
        Ingredient ingredient = new Ingredient(ingredientType, "горчичный", 1.001f);
        float expectedPrice = 1.001f;

        //Act
        float actualPrice = ingredient.getPrice();

        //Assert
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        //Arrange
        Ingredient ingredient = new Ingredient(ingredientType, "горчичный", 1.001f);
        IngredientType expectedType = ingredientType;

        //Act
        IngredientType actualType = ingredient.getType();

        //Assert
        assertEquals(expectedType, actualType);
    }
}
