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

    @InjectMocks
    User testUser;

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

        Assertions.assertEquals("TesztElek", name);
        Assertions.assertTrue(isLoggedIn);
        Assertions.assertEquals("TOPSECRET", password);
        Assertions.assertEquals(123, id);

        verify(mockUser).getUserName();
        verify(mockUser).isLoggedIn();
        verify(mockUser).getPassword();
        verify(mockUser).getId();
    }

    @Test
    public void setPasswordTest() {
        testUser.setId(123);

        when(userRepository.setPassword(123, "NEWPWD"))
            .thenThrow(new UnsupportedOperationException("not implemented yet"));

        UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            testUser.updatePwd("NEWPWD");
        });

        Assertions.assertEquals("not implemented yet", exception.getMessage());
        verify(userRepository).setPassword(123, "NEWPWD");
    }

}
