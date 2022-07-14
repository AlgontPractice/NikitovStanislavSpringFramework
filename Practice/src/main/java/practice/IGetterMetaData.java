package practice;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;

import java.util.List;
import java.util.Map;

public interface IGetterMetaData {
    String echo(@JsonRpcParam(value="message") String message);
    @JsonRpcMethod(value = "select_record")
    List<Map<String, Object>> selectRecord(@JsonRpcParam(value = "datetime_start") String dateTimeStartParam, @JsonRpcParam(value = "datetime_stop") String dateTimeStopParam);
}