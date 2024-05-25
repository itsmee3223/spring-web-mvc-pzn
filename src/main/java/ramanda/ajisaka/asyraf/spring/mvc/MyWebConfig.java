package ramanda.ajisaka.asyraf.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ramanda.ajisaka.asyraf.spring.mvc.interceptor.SessionInterceptor;
import ramanda.ajisaka.asyraf.spring.mvc.resolver.PartnerArgumentResolver;

import java.util.List;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Autowired
    private PartnerArgumentResolver partnerArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(partnerArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//      Untuk lebih detail, kita bisa cek di class AntPathMatcher
//      https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/AntPathMatcher.html
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/user/*");
    }


}
