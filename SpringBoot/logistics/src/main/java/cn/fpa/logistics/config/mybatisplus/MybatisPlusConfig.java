package cn.fpa.logistics.config.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@MapperScan({"com.hospital.mapper"})
public class MybatisPlusConfig {
    /**
     * 增强sql
     * @return 增强注入
     */
    @Bean
    public EnhancementSqlInjector easySqlInjector() {
        return new EnhancementSqlInjector();
    }

     //spring内部解析视图的类,主要是解决微信登录无法重定向的原因
    @Bean
    public InternalResourceViewResolver viewResolver(){
        return new InternalResourceViewResolver();
    }
}
