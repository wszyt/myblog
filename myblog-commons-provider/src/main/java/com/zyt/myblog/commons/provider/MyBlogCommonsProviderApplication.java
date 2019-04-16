package com.zyt.myblog.commons.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@EnableHystrixDashboard
@EnableHystrix
@MapperScan(basePackages = "com.zyt.myblog.commons.mapper")
@SpringBootApplication(scanBasePackages = "com.zyt.myblog")
public class MyBlogCommonsProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run (MyBlogCommonsProviderApplication.class, args);
        Main.main (args);
    }
}
