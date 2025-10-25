import org.example.TableService;
import org.example.User;
import org.example.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockUserTest {

    @Mock
    User mockUser;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    TableService realService;

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

    @Test
    public void setPasswordTest() {
        User newUser = new User();
        when(mockUser.getId()).thenReturn(123);

        UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> userRepository.setPassword(mockUser.getId(), "asd"));
        Assertions.assertEquals("not implemented yet", exception.getMessage());
        verify(userRepository).setPassword(mockUser.getId(), "asd");
        //when(userRepository.setPassword(newUser.getId(), "newpwd")).thenReturn(true);
    }

}
