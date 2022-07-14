package practice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.googlecode.jsonrpc4j.spring.JsonProxyFactoryBean;
import practice.IAuthService;

@Configuration
@ComponentScan("practice")
@EnableWebMvc
public class AppContextConfig {
    /*@Bean
    public JsonProxyFactoryBean jsonProxyFactoryBean(){
        JsonProxyFactoryBean jsonProxyFactoryBean = new JsonProxyFactoryBean();
        jsonProxyFactoryBean.setServiceUrl("http://localhost:8080/api");
        jsonProxyFactoryBean.setServiceInterface(IAuthService.class);
        return jsonProxyFactoryBean;
    }*/
}
