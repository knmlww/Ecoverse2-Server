package com.example.demo.api.Controller;

import com.example.demo.api.Service.UserService;
import com.example.demo.api.VO.ProfileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * localhost:8080 시 login 으로 redirect
     * @return
     */
    @GetMapping
    public String root() {
        return "redirect:/login";
    }

    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/signUp")
    public String signUpForm() {
        return "signUp";
    }

    /**
     * 로그인 실패 폼
     * @return
     */
    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

    /**
     * 회원가입 진행
     * @param profileVo
     * @return
     */
    @PostMapping("/signUp")
    public String signUp(@RequestBody ProfileVO profileVo) {

        userService.joinUser(profileVo);
        return "redirect:/login";
    }

    /**
     * 유저 페이지
     * @param model
     * @param authentication
     * @return
     */
    @GetMapping("/user_access")
    public Object userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        ProfileVO profileVO = (ProfileVO) authentication.getPrincipal();  //userDetail 객체를 가져옴

        HashMap<String,Object> dataMap = new HashMap<>();
        dataMap.put("pid", profileVO.getPid());
        dataMap.put("email", profileVO.getUsername());
        dataMap.put("password", profileVO.getPassword());
        dataMap.put("nickname", profileVO.getUserName());
        dataMap.put("coin", profileVO.getCoin());
        dataMap.put("character", profileVO.getCharacter());
        dataMap.put("last_character", profileVO.getLast_character());
        //model.addAttribute("info", userVo.getUserId() +"의 "+ userVo.getUserName()+ "님");      //유저 아이디
        //return "user_access";
        //jenkins Test
        return dataMap;

    }

    /**
     * 유저 정보 저장
     * @param profileVO
     * @return 1
     */
    @PostMapping("/saveGame")
    public Object saveGame(@RequestBody ProfileVO profileVO) {
        return userService.saveGame(profileVO);

    }
}
