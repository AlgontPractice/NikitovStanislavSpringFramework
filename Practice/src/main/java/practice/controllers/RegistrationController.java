package practice.controllers;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.IAuthService;

import java.net.URL;

@Controller
@RequestMapping("/signup")
public class RegistrationController {

    @GetMapping
    public String processSignUp(){
        return "signup";
    }
    @GetMapping("/Up")
    public String processSignUpFunc(@RequestParam(value = "login", required = true) String loginParam,
                                    @RequestParam(value = "password", required = true) String passwordParam){
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(
                    new URL(getAPIUrlAddress()));

            IAuthService userService = ProxyUtil.createClientProxy(
                    getClass().getClassLoader(),
                    IAuthService.class,
                    client);

            int result = userService.add(loginParam, passwordParam);
            if (result == 0){
                System.out.println(result);
                return "recorder";
            }
            else {
                return "signup";
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "signup";
    }
    private String getAPIUrlAddress(){
        return "http://localhost:8080/api";
    }

}
