package practice;

import com.googlecode.jsonrpc4j.JsonRpcParam;

public interface IAuthService {
    int add(@JsonRpcParam(value="login") String loginParam, @JsonRpcParam(value="password") String passwordParam);
    int check(@JsonRpcParam(value="login") String loginParam, @JsonRpcParam(value="password") String passwordParam);
    String echo(@JsonRpcParam(value="message") String message);
}
