package fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
@Repository
public class UserRepository {

    final  List<UserData> list= new ArrayList<UserData>();
    boolean AddUser(UserData user){
        if (user != null){
            list.add(user);

            return true;
        }
        return false;
    }



}
