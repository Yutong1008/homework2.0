package com.example.demo.LoggingController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class logging {

    @RequestMapping("/lombok")
    public String index() {

            log.trace("A TRACE Message");
            log.debug("A DEBUG Message");
            log.info("An INFO Message");
            log.warn("A WARN Message");
            log.error("An ERROR Message");

            return "Check out the Logs to see the output!";

    }
}
