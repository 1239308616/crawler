package cn.itcast.crawler.autohome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("cn.itcast.crawler.autohome.mapper")
@ComponentScan("cn.itcast.crawler.autohome")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
