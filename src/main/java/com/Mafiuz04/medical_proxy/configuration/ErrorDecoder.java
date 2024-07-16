package com.Mafiuz04.medical_proxy.configuration;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import org.springframework.stereotype.Component;

@Component
public class ErrorDecoder implements feign.codec.ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        FeignException exception = feign.FeignException.errorStatus(s,response);
        int status = response.status();
        if(status == 503){
            return  new RetryableException(
                    response.status(),
                    exception.getMessage(),response.request().httpMethod(),
                    exception,
                    50L,
                    response.request());
        }
        return exception;
    }
}
