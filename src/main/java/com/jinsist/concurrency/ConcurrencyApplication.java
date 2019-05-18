package com.jinsist.concurrency;

import com.jinsist.concurrency.filter.HttpFilter;
import com.jinsist.concurrency.interceptor.HttpInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyApplication.class, args);
    }

    /**
     * 配置注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new HttpFilter());
        // Url匹配拦截
        registrationBean.addUrlPatterns("/threadLocal/*");
        return registrationBean;
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置所有拦截
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/*");
    }
}
