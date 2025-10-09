import org.example.Table;
import org.example.TableRepository;
import org.example.TableService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockTableServiceTest {

    @Mock
    TableRepository mockRepository;

    @InjectMocks
    TableService realService;

    @Test
    public void getLargestTableTest() {
        //Arrange
        Table t1 = new Table(30,60,90);
        Table t2 = new Table(10,20,30, 25);
        when(mockRepository.findAll()).thenReturn(List.of(t1, t2));

        //Act
        Table largestTable = realService.getLargestTable();

        //Assert
        Assertions.assertEquals(t1, largestTable);
        Assertions.assertEquals(t1.getLength(), largestTable.getLength());
        Assertions.assertEquals(t1.getHeight(), largestTable.getHeight()); //vagy objektumokat vagy tulajsodnásgokat hasonlítsunk
        verify(mockRepository).findAll();
    }

    @Test
    public void getLargestTableNegativeTest() {
        when(mockRepository.findAll()).thenReturn(null);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> realService.getLargestTable());
        Assertions.assertEquals("No tables found in repository", exception.getMessage());
        verify(mockRepository).findAll();
    }

    @Test
    public void getTableCapacityTest() {

        Table newTable = new Table(120,180,30);
        //when(mockRepository.findById(123)).thenReturn(newTable);
        when(mockRepository.findById(anyInt())).thenReturn(newTable);

        int actualTableCapacity = realService.getTableCapacity(anyInt());

        //Assertions.assertEquals(newTable.getCapacity(), actualTableCapacity); Rossz megoldás a newTable.getCapacity() helyett számold ki rendesen
        Assertions.assertEquals(10, actualTableCapacity);
        verify(mockRepository, times(1)).findById(anyInt());
    }
}
