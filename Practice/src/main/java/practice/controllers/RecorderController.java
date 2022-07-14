package practice.controllers;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.IAuthService;
import practice.IGetterMetaData;
import practice.IStartStop;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RecorderController {
    public RecorderController(){
        System.out.println("sdfs");
    }
    @GetMapping("/recorder")
    public String showIndex(){
        System.out.println("Returned");
        return "recorder";
    }

    @PostMapping("/recorder/start")
    @ResponseBody
    public void start() {
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(
                    new URL(getAPIUrlAddress()));

            IStartStop userService = ProxyUtil.createClientProxy(
                    getClass().getClassLoader(),
                    IStartStop.class,
                    client);
            userService.launchStart();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("SSSSSSSSSSSSTTTTTTTTTTTTTTTTTTTAAAAAAAAAAAAAAAAAAAARRRRRRRRRRTTTTTTTTTTTTTT");
    }

    @PostMapping("/recorder/stop")
    @ResponseBody
    public void stop(){
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(
                    new URL(getAPIUrlAddress()));

            IStartStop userService = ProxyUtil.createClientProxy(
                    getClass().getClassLoader(),
                    IStartStop.class,
                    client);
            userService.launchEnd();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("SSSSSSSSSSSSSTTTTTTTTTTTTTTTTOOOOOOOOOOOOOOOOOOOOOPPPPPPPPPPPPPPP");
    }
    //-------------------------------------------------------------------------------------------------------------------
    private static String getAPIUrlAddress(){
        return "http://192.168.35.96:1235/api_record";
    }
}
