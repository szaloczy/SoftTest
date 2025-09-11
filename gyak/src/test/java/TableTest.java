import org.example.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
