package com.showcase.springmicrometer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessLogicService {

    public void executeBusinessService() {
        TracingRequestContext.getTracingHeaders()
                .forEach((k, v) -> log.info("Request {} value {}", k, v));
    }
}
