package seccion6interceptoreshttp.seccion6interceptoreshttp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registy){
        /* registy.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "app/foo"); */
        registy.addInterceptor(timeInterceptor).excludePathPatterns("/app/bar");
    }
}
