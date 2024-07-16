package com.Mafiuz04.medical_proxy.configuration;

import feign.RetryableException;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig implements feign.Retryer {

    @Override
    public void continueOrPropagate(RetryableException e) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw e;
        }
    }

    @Override
    public Retryer clone() {
        return new FeignConfig();
    }

    @Bean
    public Retryer retryer() {
        return new FeignConfig();
    }
}
