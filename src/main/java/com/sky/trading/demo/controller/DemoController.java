package com.sky.trading.demo.controller;

import com.sky.trading.demo.model.Message;
import com.sky.trading.demo.service.DemoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Api(tags = "demo")
@RestController
@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @ApiOperation("Demo operation")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "Message to process", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Message.class)
    })
    @GetMapping("/{message}")
    public CompletableFuture<Message> getMessage(@PathVariable String message) {
        return demoService.getMessage(message);
    }
}
