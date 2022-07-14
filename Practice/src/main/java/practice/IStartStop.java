package practice;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;

import java.util.List;
import java.util.Map;

public interface IStartStop {
    @JsonRpcMethod(value = "launch_start")
    void launchStart();

    @JsonRpcMethod(value = "launch_end")
    void launchEnd();

}
