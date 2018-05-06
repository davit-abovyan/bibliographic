package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Base64;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1.0/login")
public class APISecurityController extends APIController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{credentials}")
    public boolean login(HttpSession session, @PathVariable String credentials){
        String[] base64 = new String(Base64.getDecoder().decode(credentials)).split(":");
        String userName = base64[0];
        String password = base64[1];
        return userService.login(userName, password);
    }

}
