package fr.esiea.ex4A.User;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {
    private enum Sex{
        M("M"), F("F"), O("O");
        private final String gender;

        Sex(String value) {
            this.gender = value;
        }

        public String toString() {
            return this.gender;
        }
    }
    public final String userEmail;
    public final String userName;
    public final String userTweeter;
    public final String userCountry;
    public final Sex userSex;
    public final Sex userSexPref;
    public UserData(@JsonProperty(required = true,value = "userEmail") String userEmail,@JsonProperty(required = true,value ="userName") String userName,@JsonProperty(required = true,value ="userTweeter") String userTweeter,@JsonProperty(required = true,value ="userCountry") String userCountry,@JsonProperty(required = true,value ="userSex") String userSex,@JsonProperty(required = true,value ="userSexPref") String userSexPref){
        this.userEmail= userEmail;
        this.userName=userName;
        this.userTweeter=userTweeter;
        this.userCountry= userCountry;
        this.userSex= Sex.valueOf(userSex);
        this.userSexPref= Sex.valueOf(userSexPref);
    }



}
