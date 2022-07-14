package practice;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

public class AuthServiceAPI implements IAuthService {

    @Override
    public int add(String loginParam, String passwordParam) {
        try{
            DBProccesor.insert(loginParam, passwordParam);
        }
        catch (PSQLException e){
            return 2;
        }
        catch (ClassNotFoundException e){
            return 3;
        }
        catch (SQLException e){
            return 3;
        }
        return 0;
    }

    @Override
    public int check(String loginParam, String passwordParam) {
        boolean marker;
        try{
            marker = DBProccesor.check(loginParam, passwordParam);
        }
        catch (ClassNotFoundException e){
            return 3;
        }
        catch (SQLException e){
            return 3;
        }
        if (marker){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public String echo(String message) {
        return message;
    }
}
