import org.example.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockTriangleTest {

    //Define Mock
    @Mock
    Triangle mockTriangle; //osztály szintű , összes teszteset láthatja

    @Test
    public void myFistMockitoTest() {
        //Triangle mockTriangleTest = Mockito.mock(Triangle.class);
        //Triangle mockTriangleTest2 = Mockito.mock(Triangle.class, Mockito.withSettings().useConstructor(3,4,5));

        //Define behavior
        when(mockTriangle.isIsosceles()).thenReturn(true);
        when(mockTriangle.getArea()).thenReturn(20.0);
        when(mockTriangle.getPerimeter()).thenReturn(10);


        boolean isIsoscelesResult = mockTriangle.isIsosceles();
        double getAreaResult = mockTriangle.getArea();
        int getPerimeter = mockTriangle.getPerimeter();

        verify(mockTriangle).isIsosceles(); //ellenőrzi hogy meghívódot-e

        Assertions.assertEquals(20.0, getAreaResult);

    }
}
