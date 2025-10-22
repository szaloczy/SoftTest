import org.example.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockUserTest {

    @Mock
    User mockUser;

    @Test
    public void mockUserTest() {
        //define behaviour
        when(mockUser.getUserName()).thenReturn("TesztElek");
        when(mockUser.isLoggedIn()).thenReturn(true);
        when(mockUser.getPassword()).thenReturn("TOPSECRET");
        when(mockUser.getId()).thenReturn(123);

        String name = mockUser.getUserName();
        boolean isLoggedIn = mockUser.isLoggedIn();
        String password = mockUser.getPassword();
        int id = mockUser.getId();

        verify(mockUser).getUserName();
        verify(mockUser).isLoggedIn();
        verify(mockUser).getPassword();
        verify(mockUser).getId();
    }

}
