package fr.esiea.ex4A.Proxy;

import fr.esiea.ex4A.User.UserData;
import fr.esiea.ex4A.User.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    public final APIAgifyInterface APIAgifyInterface;
    public final UserRepository UserRepository = new UserRepository();

    public AgifyService(APIAgifyInterface APIAgifyInterface) {
        this.APIAgifyInterface = APIAgifyInterface;
    }

    public void addUser(UserData user) throws IOException {
        UserFromAgify userFromAgify;
        if(!UserRepository.seeIfUserExists(user)){
            userFromAgify = this.APIAgifyInterface.getUser(user.userName, user.userCountry).execute().body();
            UserRepository.addNewUser(user, userFromAgify);
        }
    }

    public ArrayList<UserData> matchUser(String userName, String country){
        UserData userRequestingMatch = UserRepository.getUser(userName, country);
        if(userRequestingMatch != null){
            return UserRepository.matchUser(userRequestingMatch);
        } else {
            return new ArrayList<>();
        }
    }
}
