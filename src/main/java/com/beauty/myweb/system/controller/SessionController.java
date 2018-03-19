package com.beauty.myweb.system.controller;

import com.beauty.myweb.core.annotation.MustLogin;
import com.beauty.myweb.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.beauty.myweb.system.dto.SessionDto;
import com.beauty.myweb.system.service.SessionService;

/**
 * session会话控制器
 */
@RestController
@RequestMapping("/sys")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping("/genSession")
    @ResponseBody
    @MustLogin(false)
    public Result genSession(){
        SessionDto sessionDto = sessionService.genSession();
        return Result.SUCCESS().setData(sessionDto);
    }
}
