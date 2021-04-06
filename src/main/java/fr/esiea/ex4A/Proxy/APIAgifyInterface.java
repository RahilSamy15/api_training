package fr.esiea.ex4A.Proxy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIAgifyInterface {

    @GET("/")
    Call<UserFromAgify> getUser(@Query("name") String name, @Query("country_id") String userCountry);


}
