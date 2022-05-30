package com.example.demo.api.Controller;

import com.example.demo.Socket.Config.WebSocketConfigImpl;
import com.example.demo.api.DemoDTO.DemoDTO;
import com.example.demo.api.Service.DemoService;
import com.example.demo.api.VO.paramVO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    private WebSocketConfigImpl webSocketConfig;

    @Autowired  // spring 4.3 버전 이상부터는 생략 가능
    public DemoController(DemoService demoService) {

        this.demoService = demoService;
    }
    /**
     * DB select 메서드
     * @return json
     */
    @PostMapping(path="/test1")
    public Object test1() throws Exception {
        return demoService.test1();
    }



    /**
     * DB insert 메서드
     * @param param
     * @return 1
     */
    @PostMapping(path="/test2")
    public int test2(@RequestBody paramVO.test2 param) throws Exception {
        return demoService.test2(param) ;
    }
    /**
     * DB update 메서드
     * @param param
     * @return 1
     */
    @PostMapping(path="/test3")
    public int test3(@RequestBody paramVO.test3 param) throws Exception {
        return demoService.test3(param) ;
    }
    /**
     * 현재 시간 return 메서드
     * @return DateTime
     */
    @PostMapping(path="/checkNowTime")
    public Object nowTime() throws Exception{

        LocalDateTime dateTime = LocalDateTime.now();
     //   String nowTime1 = sdf1.format(now);
        System.out.println(dateTime);
        return dateTime;
    }

    /**
     *
     * @return String
     */
    @PostMapping(path="/serverStatus")
    public String serverStatus () throws Exception{
        return "hello";
    }

}
