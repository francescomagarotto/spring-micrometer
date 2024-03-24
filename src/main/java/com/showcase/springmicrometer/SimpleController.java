package com.showcase.springmicrometer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
@Slf4j
public class SimpleController {

    @Autowired
    private BusinessLogicService businessLogicService;

    @PostMapping("/metric")
    public void metric() {
        log.info("Received request /simple/metric");
        businessLogicService.executeBusinessService();
    }
}
