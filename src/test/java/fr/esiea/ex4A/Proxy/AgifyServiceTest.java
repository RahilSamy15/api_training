package fr.esiea.ex4A.Proxy;

import fr.esiea.ex4A.User.UserData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;

import retrofit2.converter.jackson.JacksonConverterFactory;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AgifyServiceTest {
    APIAgifyInterface APIAgifyInterface() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io/").addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(APIAgifyInterface.class);
    }

    APIAgifyInterface mockAPIAgifyInterface = APIAgifyInterface();

    AgifyService agifyService = new AgifyService(mockAPIAgifyInterface);

    @Test
    void AddingUser() throws IOException {
        UserData UserData = new UserData("OE@gmail.com", "OE", "OE", "FR", "M", "F");
        agifyService.addUser(UserData);


        Assertions.assertThat(agifyService.UserRepository.ListOfUser.get("OE@gmail.comID11")).isEqualTo(UserData);

    }

    @Test
    void addingUsersLengthCheck() throws IOException {
        UserData UserData1 = new UserData("sam@gmail.fr", "Henri", "bHenri", "FR", "M", "M");
        UserData UserData2 = new UserData("yab@Hotmail.efr", "Juan", "juanjuan", "ES", "M", "F");
        agifyService.addUser(UserData1);
        agifyService.addUser(UserData2);
        Assertions.assertThat(agifyService.UserRepository.ListOfUser.get("sam@gmail.frID11")).isEqualTo(UserData1);
        Assertions.assertThat(agifyService.UserRepository.ListOfUser.get("yab@Hotmail.efrID11")).isEqualTo(UserData2);
        Assertions.assertThat(agifyService.UserRepository.getNumberOfUsers()).isEqualTo(2);
    }
}
