package com.zyt.myblog.article.ui;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(scanBasePackages = "com.zyt.myblog", exclude = {DataSourceAutoConfiguration.class})
@EnableHystrix
@EnableHystrixDashboard
public class MyBlogArticleUIApplication {
    public static void main(String[] args) {
        SpringApplication.run (MyBlogArticleUIApplication.class, args);
        Main.main (args);
    }
}
