package fr.esiea.ex4A.User;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserDataTest {
    @ParameterizedTest
    @CsvSource({
        "Samy, Samy",
        "Lio, Lio",
        "Phillipe, Phillipe"
    })
    void VerifyName(String wantedName, String expectedName){
        UserData UserData = new UserData("",wantedName,"","","","");
        Assertions.assertThat(UserData.getUserName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "aze@aze.com, aze@aze.com",
        "qw@cze.fr, qw@cze.fr",
        "yt@cze.dz, yt@cze.dz"
    })
    void SameEmail(String wantedValue, String expectedValue){
        UserData UserData = new UserData(wantedValue, "test", "","","","");
        Assertions.assertThat(UserData.getUserEmail()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "john, john",
        "Amber, Amber"
    })
    void VerifyCount(String wantedValue, String expectedValue){
        UserData UserData = new UserData("", "test", wantedValue,"","","");
        Assertions.assertThat(UserData.getUserTweeter()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "GB, GB",
        "FR, FR",
        "JP, JP"
    })
    void VerifyCOuntry(String wantedValue, String expectedValue){
        UserData UserData = new UserData(wantedValue, "test", "",wantedValue,"","");
        Assertions.assertThat(UserData.getUserCountry()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "M, M",
        "F, F"
    })
    void VerifySex(String wantedValue, String expectedValue){
        UserData UserData = new UserData(wantedValue, "test", "","",wantedValue,"");
        Assertions.assertThat(UserData.getSex()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "F, F",
        "M, M"
    })
    void VerifyPrefSexes(String wantedValue, String expectedValue){
        UserData UserData = new UserData("wantedValue", "test", "","","",wantedValue);
        Assertions.assertThat(UserData.getSexPref()).isEqualTo(expectedValue);
    }

}
