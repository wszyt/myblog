package com.zyt.myblog.commons.provider.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
public class BeanValidatorConfiguration {
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean ();
    }

    @Bean
    public BeanValidator beanValidator(LocalValidatorFactoryBean localValidatorFactoryBean) {
        BeanValidator beanValidator = new BeanValidator ();
        beanValidator.setValidator (localValidatorFactoryBean);
        return beanValidator;
    }
}
