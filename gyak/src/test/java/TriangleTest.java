import org.example.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.DecimalFormat;
import java.util.stream.Stream;

public class TriangleTest {

    @Test
    @DisplayName("Generic Triangle")
    public void TestGenericTriangle() {
        //Arrange
        Triangle myTirangle = new Triangle(3, 3, 3);

        //Act
        boolean value = myTirangle.isEquilateral();
        boolean isIsosceles = myTirangle.isIsosceles();

        //Assert
        Assertions.assertTrue(value);
        Assertions.assertTrue(isIsosceles, "Expected to be isosceles");
        //Assertions.assertEquals(9, myTirangle.getArea());

        //double area = myTirangle.getArea();
        //Assertions.assertEquals(9,area);
    }

    @Test
    @DisplayName("Test that exception is thrown")
    public void testException() {
        //Arrange
        Triangle triangle = new Triangle(3,4,5);

        //Act + assert
        Assertions.assertThrows(UnsupportedOperationException.class, () -> triangle.getArea());

    }

    private static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(1,3,3,7, true),
                Arguments.of(10,30,30,70, true),
                Arguments.of(5,5,5,15, true)
        );
    }

    @ParameterizedTest(name="Data-driven triangle test")
    @MethodSource("getTestData")
    public void testParameterized(int a, int b, int c, int expectedPerimeter, boolean expectedIsosceles) {
        Triangle triangle = new Triangle(a,b,c);
        int perimeter = triangle.getPerimeter();
        boolean isosceles = triangle.isIsosceles();

        Assertions.assertEquals(expectedPerimeter, perimeter);
        Assertions.assertEquals(expectedIsosceles, isosceles);
    }

    @Test()
    @DisplayName("Test is right-angled")
    public void testIsRightAngled() {
        Triangle triangle = new Triangle(3,4, 5);

        Assertions.assertTrue(triangle.isRightAngled(triangle));
    }

    @Test()
    @DisplayName("Test is not right-angled")
    public void testIsNotRightAngled() {
        Triangle triangle = new Triangle(2,2,2);

        Assertions.assertFalse(triangle.isRightAngled(triangle));
    }

    @Test()
    @DisplayName("Test triangle area")
    public void testGetArea() {

        Triangle triangle = new Triangle(4, 6, 5);

        Assertions.assertEquals(10.0, triangle.getArea());
    }
}