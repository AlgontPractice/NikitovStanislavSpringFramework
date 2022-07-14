package practice.controllers;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.IGetterMetaData;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fragment")
public class ListController {

    @GetMapping
    public String getFragment(){
        return "fragment";
    }

    @PostMapping("/list")
    public String getList(@RequestParam(value = "date1") String data1Param,
                          @RequestParam(value = "date2") String data2Param,
                          Model model){
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(
                    new URL(getAPIUrlAddress()));

            IGetterMetaData userService = ProxyUtil.createClientProxy(
                    getClass().getClassLoader(),
                    IGetterMetaData.class,
                    client);

            String dateOne = getDate(data1Param);
            String dateTwo = getDate(data2Param);

            /*List<Map<String, Object>> listik = new ArrayList<>();
            listik.add(getHashMap(dateOne, dateTwo,
                    6, 1, "avi", 125,
                    "file:///D:/first.mp4", "user", "/CCCCCCCCCCCCCC"));
            listik.add(getHashMap("2022-07-06 11:30:47.0", "2022-07-06 20:30:47.0",
                    6, 1, "avi", 125,
                    "file:///D:/second.mp4", "user", "/CCCCCCCCCCCCCC"));*/
            List<Map<String, Object>> result = userService.selectRecord(dateOne, dateTwo);
            model.addAttribute("list", result);
            return  "fragment";

        } catch (Throwable t) {
            return "fragment";
        }
    }


    private static HashMap<String, Object> getHashMap(String dataStart, String dataStop,
                                                      Integer idChannel, Integer idRecord,
                                                      String recordExtension, Integer recordLength,
                                                      String recordPath, String recordType, String snapshotPath){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("datetime_start", dataStart);
        hashMap.put("datetime_stop", dataStop);
        hashMap.put("id_channel", idChannel);
        hashMap.put("id_record", idRecord);
        hashMap.put("record_extension", recordExtension);
        hashMap.put("record_length", recordLength);
        hashMap.put("record_path", recordPath);
        hashMap.put("record_type", recordType);
        hashMap.put("snapshot_path", snapshotPath);
        return hashMap;
    }

    private String getAPIUrlAddress(){
        return "http://192.168.35.57:1234/api_db_record";
    }

    private static String getDate(String param){
        LocalDateTime dateTime = LocalDateTime.parse(param);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String localDate = dateTime.format(formatter);

        return localDate;
    }
}
