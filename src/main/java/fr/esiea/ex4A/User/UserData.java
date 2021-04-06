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
    public final String Id;
    public final String userEmail;
    public final String userName;
    public final String userTweeter;
    public final String userCountry;
    public final String userSex;
    public final String userSexPref;

    public UserData(@JsonProperty("userEmail") String userEmail,@JsonProperty("userName") String userName,@JsonProperty("userTweeter") String userTweeter,@JsonProperty("userCountry") String userCountry,@JsonProperty("userSex") String userSex,@JsonProperty("userSexPref") String userSexPref){

        this.userEmail= userEmail;
        this.userName=userName;
        this.userTweeter=userTweeter;
        this.userCountry= userCountry;
        this.userSex= userSex;
        this.userSexPref= userSexPref;
        this.Id = userEmail.concat("ID11");
    }
    public UserData(String name, String twitter) {
        this.userEmail = "";
        this.userCountry = "";
        this.userName = name;
        this.userSex="";
        this.userSexPref="";
        this.userTweeter = twitter;
        this.Id = userEmail.concat("ID11");
    }
    @Override
    public String toString() {
        return "{" +
            "\"userEmail\":\"" + userEmail + '"' +
            ",\"userName\":\"" + userName + '"' +
            ",\"userTweeter\":\"" + userTweeter + '"' +
            ",\"userCountry\":\"" + userCountry + '"' +
            ",\"userSex\":\"" + userSex + '"' +
            ",\"userSexPref\":\"" + userSexPref + '"' +
            '}';
    }

    public String getUserId(){ return this.Id; }
    public String getUserEmail() { return this.userEmail; }

    public String getUserName() {
        return userName;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getSex() {
        return userSex;
    }

    public String getSexPref() {
        return userSexPref;
    }

}
