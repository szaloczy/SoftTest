import org.example.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    @DisplayName("Test User")
    public void testUser() {
        //Arrange
        User user = new User();

        //Act  + Assert
        Assertions.assertNotNull(user);
        Assertions.assertNull(user.getUserName());
        Assertions.assertNull(user.getPassword());
        Assertions.assertEquals(0, user.getId());
        Assertions.assertEquals(0, user.getLoginCount());
    }

    @Test
    @DisplayName("Test that exception is thrown")
    public void testExceptionThrow() {
        //Arrange
        User user = new User();

        //Act + Assert
        Assertions.assertThrows(UnsupportedOperationException.class, () -> user.updatePwd("SDs", false));
    }

    @Test
    @DisplayName("Test isLoggedIn false")
    public void testIsLoggedIn() {
        User user = new User();
        user.login();

        Assertions.assertTrue(user.isLoggedIn());
        Assertions.assertEquals(1, user.getLoginCount());
    }

    @Test
    @DisplayName("Test login")
    public void loginTest() {
        //Arrange
        User user = new User();

        //Act
        user.login();

        //Assert
        Assertions.assertTrue(user.isLoggedIn());
    }

    @Test
    @DisplayName("Test proper login counting")
    public void testLoginCount() {
        //Arrange
        User user = new User();

        //Act
        user.login();

        //Assertion
        Assertions.assertEquals(1, user.getLoginCount());
    }

    @Test
    @DisplayName("Test logout")
    public void testLogout() {
        //Arrange
        User user = new User();

        //Act
        user.login();

        //Assertions
        Assertions.assertTrue(user.isLoggedIn());

        user.logout();

        Assertions.assertFalse(user.isLoggedIn());

    }
}
