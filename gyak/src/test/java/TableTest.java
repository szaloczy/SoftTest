import org.example.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TableTest {

    @Test
    @DisplayName("Set height between 0 - 200")
    public void setHeightInvalidRange() {
        //Arrange
        Table table = new Table(60,60,100,80);

        //Act
        Assertions.assertThrows(IllegalArgumentException.class, ()->table.setHeight(-10));

        //Assert
        Assertions.assertEquals(80, table.getCurrentHeight());
    }

    @Test
    @DisplayName("Set height not adjustable table")
    public void setHeightInvalidTable() {
        //Arrange
        Table table = new Table(60,60,100);

        //Act
        Assertions.assertThrows(UnsupportedOperationException.class, ()->table.setHeight(150));

        //Assert
        Assertions.assertEquals(100, table.getCurrentHeight());
    }

    @Test
    @DisplayName("Test valid area")
    public void getValidArea() {
        //Arrange
        Table table = new Table(60, 60, 80);

        //Act + Assert
        Assertions.assertEquals(3600, table.area());
    }

    @Test
    @DisplayName("Test get valid capacity")
    public void getValidCapacity() {
        //Arrange
        Table table = new Table(60, 60, 80);

        //Act + Assert
        Assertions.assertEquals(4, table.getCapacity());
    }

    @Test
    @DisplayName("Test valid repaint")
    public void testRepaint() {
        //Arrange
        Table table = new Table(60, 60, 80, "red", 4);

        //Act
        table.repaint("green");

        //Assert
        Assertions.assertEquals("green", table.getColor());
    }

    private static Stream<Arguments>getTestData() {
        return Stream.of(
                Arguments.of(60,60,80, "red", 3, 240, true),
                Arguments.of(30,40,60, "green", 4, 140, true),
                Arguments.of(50,60,90, "yellow", 5, 220, true)
                );
    }

    @ParameterizedTest(name="Data-driven table test")
    @MethodSource("getTestData")
    public void testParameterized(int a, int b, int c, String color, int legs, int expectedPerimeter, boolean expectedIsStable) {
        Table table = new Table(a, b, c, color, legs);

        int perimeter = table.getPerimeter();
        boolean isStable = table.isStable();

        Assertions.assertEquals(expectedPerimeter, perimeter);
        Assertions.assertEquals(expectedIsStable, isStable);
    }

    @Test
    @DisplayName("Test table is stable")
    public void testTableIsStable() {
        //Arrange
        Table table = new Table(60, 60, 80, "red", 4);
    }
}
