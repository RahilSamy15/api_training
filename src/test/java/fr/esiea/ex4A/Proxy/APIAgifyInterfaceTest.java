package fr.esiea.ex4A.Proxy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.jackson.JacksonConverterFactory;

import static org.junit.jupiter.api.Assertions.*;

class APIAgifyInterfaceTest {
    private final APIAgifyInterface APIAgifyInterface;

    APIAgifyInterfaceTest() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create()).build();
        this.APIAgifyInterface = retrofit.create(APIAgifyInterface.class);
    }

    @ParameterizedTest
    @CsvSource({
        "GRIZ, Fr, 69",
        "Mahrez, DZ, 30",
        "LIO, ARG, 32",
        "CR7, PR, 36"
    })
    void getAgeFromNames(String userName, String userCountry, int expectedAge){
        Call<UserFromAgify> call = this.APIAgifyInterface.getUser(userName, userCountry);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<UserFromAgify> call, Response<UserFromAgify> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserFromAgify UserFromAgify = response.body();
                    getAge(UserFromAgify, expectedAge);
                }
            }

            @Override
            public void onFailure(Call<UserFromAgify> call, Throwable throwable) {
                System.out.println("Error on API");
            }
        });
    }

    private void getAge(UserFromAgify UserFromAgify, int expectedAge){
        Assertions.assertThat(UserFromAgify.getAge()).isEqualTo(expectedAge);
    }

}
