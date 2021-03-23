package fr.esiea.ex4A.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController()

public class UserController {
    private final UserRepository UserRepository;

    public UserController(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    @PostMapping(path = "/api/inscription")
    public ResponseEntity<?> inscription(@RequestBody UserData user) throws InterruptedException {

        if (this.UserRepository.AddUser(user)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }


    @GetMapping(path = "/api/matches", produces= MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> Matching(@RequestParam(name = "userName") String userName, @RequestParam(name = "userCountry") String userCountry  ) {
        List<Return> list = new ArrayList<Return>();
        list.add(new Return("machin","Machin45"));
        list.add(new Return("Leo","D1os"));

        return new ResponseEntity<>(list,HttpStatus.CREATED);

    }



}
