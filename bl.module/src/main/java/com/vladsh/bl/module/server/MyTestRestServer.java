package com.vladsh.bl.module.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladimir Sharapov
 */
@RestController
public class MyTestRestServer {

    RestResponses responses = RestResponses.json();

    private final MyService myService;

    public MyTestRestServer(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(value = "/resttest", method = RequestMethod.GET)
    public ResponseEntity<Long> myrestapi() {
        myService.test();
        return responses.ok(1L);
    }
}
