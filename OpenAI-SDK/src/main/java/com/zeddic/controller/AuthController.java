package com.zeddic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/verify")
    public ResponseEntity<String > verify(String token){
        logger.info("验证token:{}" , token);
        if ("success".equals(token)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/success")
    public String success(){
        return "success!test by zeddic";
    }
}
