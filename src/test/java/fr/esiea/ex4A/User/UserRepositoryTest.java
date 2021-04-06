package fr.esiea.ex4A.User;

import fr.esiea.ex4A.Proxy.UserFromAgify;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private final UserRepository UserRepository = new UserRepository();

    @Test
    void NoUserVerification(){
        Assertions.assertThat(UserRepository.getNumberOfUsers()).isEqualTo(0);
    }

    @Test
    void VerifyUserAdded(){
        UserData UserData = new UserData("test", "test", "test", "test", "test", "test");
        UserFromAgify UserFromAgify = new UserFromAgify("test", 50, 500, "US");
        UserRepository.addNewUser(UserData, UserFromAgify);
        Assertions.assertThat(UserRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void CheckingLenUsers(){
        UserData userData1 = new UserData("az@er", "az", "az", "az", "az", "az");
        UserData userData2 = new UserData("er@er", "er", "er", "er", "er", "er");

        UserFromAgify UserFromAgify1 = new UserFromAgify("az", 50, 500, "FR");
        UserFromAgify UserFromAgify2 = new UserFromAgify("er", 52, 500, "DE");

        UserRepository.addNewUser(userData1, UserFromAgify1);
        UserRepository.addNewUser(userData2, UserFromAgify2);

        Assertions.assertThat(UserRepository.getNumberOfUsers()).isEqualTo(2);
        Assertions.assertThat(2).isEqualTo(2);
    }

}
