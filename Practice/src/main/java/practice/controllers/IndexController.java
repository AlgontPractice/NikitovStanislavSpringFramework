package practice.controllers;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.googlecode.jsonrpc4j.spring.rest.JsonRpcRestClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.IAuthService;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexNorm(){
        return "index";
    }

    @GetMapping("/In")
    public String processSignInFunc(@RequestParam(value = "login", required = true) String loginParam,
                                    @RequestParam(value = "password", required = true) String passwordParam){
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(
                    new URL(getAPIUrlAddress()));

            IAuthService userService = ProxyUtil.createClientProxy(
                    getClass().getClassLoader(),
                    IAuthService.class,
                    client);

            int result = userService.check(loginParam, passwordParam);
            if (result == 0){
                System.out.println(result);
                return "recorder";
            }
            else {
                return "index";
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "index";
    }
    private String getAPIUrlAddress(){
        return "http://localhost:8080/api";
    }
}
