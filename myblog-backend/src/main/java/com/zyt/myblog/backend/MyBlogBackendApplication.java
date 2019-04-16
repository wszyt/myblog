package com.zyt.myblog.backend;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(scanBasePackages = "com.zyt.myblog", exclude = {DataSourceAutoConfiguration.class})
@EnableHystrix
@EnableHystrixDashboard
public class MyBlogBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run (MyBlogBackendApplication.class, args);
        Main.main (args);
    }
}
