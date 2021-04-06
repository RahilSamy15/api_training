package fr.esiea.ex4A.Proxy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserFromAgifyTest {

    @ParameterizedTest
    @CsvSource({
        "LEO, LEO",
        "NINA, NINA",
        "CR, CR"
    })
    void NameEqual(String wantedName, String expectedName){
        UserFromAgify UserFromAgify = new UserFromAgify(wantedName, 20, 5678, "FR");
        Assertions.assertThat(UserFromAgify.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "30, 30",
        "35, 35",
        "40, 40"
    })
    void AgeMatch(int wantedAge, int expectedAge){
        UserFromAgify UserFromAgify = new UserFromAgify("test", wantedAge, 10, "US");
        Assertions.assertThat(UserFromAgify.getAge()).isEqualTo(expectedAge);
    }

    @ParameterizedTest
    @CsvSource({
        "112, 112",
        "89, 89",
        "111, 111"
    })
    void CountsMatch(int wantedCount, int expectedCount){
        UserFromAgify UserFromAgify = new UserFromAgify("test", 20, wantedCount, "US");
        Assertions.assertThat(UserFromAgify.getCount()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
        "Fr, Fr",
        "DZ, DZ",
        "GR, GR"
    })
    void CounrtyMatch(String wantedCountry, String expectedCountry){
        UserFromAgify UserFromAgify = new UserFromAgify("test", 20, 234, wantedCountry);
        Assertions.assertThat(UserFromAgify.getCountry_id()).isEqualTo(expectedCountry);
    }

}
