package fr.esiea.ex4A.User;
import fr.esiea.ex4A.Proxy.AgifyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController()
public class UserController {
    private final AgifyService agifyService;

    public UserController(AgifyService agifyService) {
        this.agifyService = agifyService;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserData user) throws IOException {

        this.agifyService.addUser(user);
    }


    @GetMapping(path = "/api/matches", produces= MediaType.APPLICATION_JSON_VALUE )
    public List<UserData> Matching(@RequestParam(name = "userName") String userName, @RequestParam(name = "userCountry") String userCountry  ) {
        List<UserData> userList = this.agifyService.matchUser(userName, userCountry);
        return userList;

    }



}
