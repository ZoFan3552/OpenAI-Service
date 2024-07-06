package com.zeddic.interfaces;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public SaResult authenticate(@RequestParam String username, @RequestParam String password) {
            if ("zeddic".equals(username) && "123456".equals(password)) {
                StpUtil.login(10001);
                return SaResult.ok("登陆成功");
            }
            return SaResult.error("登陆失败");
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verify(){
        logger.info("验证token:{}" , StpUtil.getTokenInfo());
        if (StpUtil.isLogin()) {
            return ResponseEntity.ok(StpUtil.getTokenInfo());
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
