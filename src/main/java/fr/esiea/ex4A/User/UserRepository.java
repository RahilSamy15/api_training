package fr.esiea.ex4A.User;
import fr.esiea.ex4A.Proxy.UserFromAgify;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    public final HashMap<String, UserData> ListOfUser = new HashMap<>();
    public final HashMap<String, UserFromAgify> ListOfUserWithAge = new HashMap<>();

    public  int getNumberOfUsers(){
        return this.ListOfUser.size();
    }

    public void addNewUser(UserData UserData, UserFromAgify userDataWithAge){
        this.ListOfUser.put(UserData.getUserId(), UserData);
        this.ListOfUserWithAge.put(UserData.getUserId(), userDataWithAge);
    }

    public boolean seeIfUserExists(UserData UserData){
        return this.ListOfUser.containsKey(UserData.getUserId());
    }

    public UserData getUser(String userName, String countryId){
        return this.ListOfUser.get(userName.concat(countryId));
    }

    public ArrayList<UserData> matchUser(UserData UserData){
        ArrayList<UserData> matchingUsers = new ArrayList<>();
        for(Map.Entry<String, UserFromAgify> userEntry : this.ListOfUserWithAge.entrySet()){
            if(Math.abs(userEntry.getValue().getAge() - this.ListOfUserWithAge.get(UserData.getUserId()).getAge()) <= 4){
                UserData possiblyMatchingUser = this.ListOfUser.get(userEntry.getValue().getUserId());
                if(possiblyMatchingUser.getSex().equals(UserData.getSexPref()) && UserData.getSex().equals(possiblyMatchingUser.getSexPref())) {
                    matchingUsers.add(this.ListOfUser.get(userEntry.getValue().getUserId()));
                }
            }
        }
        return matchingUsers;
    }

}
