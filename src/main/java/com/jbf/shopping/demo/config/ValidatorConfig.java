package com.jbf.shopping.demo.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 参数校验器
 * @author: LuAn
 * @date: 2024/6/21
 */
@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator() {
        try (ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败模式
                .failFast(true)
                .buildValidatorFactory()) {
            return validatorFactory.getValidator();
        }
    }
}
