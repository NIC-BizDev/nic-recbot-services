package com.egov.recbot.controller;

import com.egov.recbot.json.TestResponse;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path="/test", method=RequestMethod.GET)
    public TestResponse TestGet(@RequestParam(value="name", defaultValue="World") String name) {
        return new TestResponse(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
