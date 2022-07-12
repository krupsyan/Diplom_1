package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnsCorrectValue() {
        //Arrange
        Bun bun = new Bun("с маком", 1.0f);
        String expectedName = "с маком";

        //Act
        String actualName = bun.getName();

        //Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        //Arrange
        Bun bun = new Bun("с маком", 1.001f);
        float expectedPrice = 1.001f;

        //Act
        float actualPrice = bun.getPrice();

        //Assert
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
