package practice;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebMvc
public class ApplicationConfig {
    @Bean
    public BeanNameUrlHandlerMapping autoJsonRpcServiceImplExporter() {
        return new BeanNameUrlHandlerMapping();
    }

    @Bean
    public AuthServiceAPI authServiceAPI(){
        return new AuthServiceAPI();
    }

    @Bean(name = "/api")
    public JsonServiceExporter jsonServiceExporter(){
        JsonServiceExporter exp = new JsonServiceExporter();
        exp.setService(authServiceAPI());
        exp.setServiceInterface(IAuthService.class);
        return exp;
    }

}
