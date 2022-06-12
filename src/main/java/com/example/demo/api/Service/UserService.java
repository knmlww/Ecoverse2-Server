package com.example.demo.api.Service;

import com.example.demo.api.Mapper.DemoMapper;

import com.example.demo.api.VO.Profile.ProfileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    @Autowired
   // private UserMapper userMapper;
    private DemoMapper demoMapper;

    @Transactional
    public String joinUser(ProfileVO profileVo){
        String paramEmail = profileVo.getEmail();
        String result = null;
        int checkEmail = demoMapper.checkEmail(paramEmail);
        if(checkEmail==0){
            demoMapper.saveUser(profileVo);
            result =  "SIGNUP_SUCCESS";
        } else if (checkEmail==1) {
            result =  "SIGNUP_FAIL_EMAIL";
        }
        return result;
    }

    @Override
    public ProfileVO loadUserByUsername(String email) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증

    return demoMapper.getUserAccount(email);
    }

    @Transactional
    public int saveGame(ProfileVO profileVo) throws UsernameNotFoundException{
        return demoMapper.saveGame(profileVo);
    }


    public int withdrawMembership(ProfileVO profileVo) {
       String pid = profileVo.getPid();
       return demoMapper.withdrawMembership(pid);
    }

    public ProfileVO downloadOneMember(ProfileVO profileVo) {
        String pid = profileVo.getPid();
        return demoMapper.downloadOneMember(pid);
    }
}