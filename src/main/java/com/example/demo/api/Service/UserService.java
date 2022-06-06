package com.example.demo.api.Service;

import com.example.demo.api.Mapper.DemoMapper;

import com.example.demo.api.VO.ProfileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);
    @Autowired
   // private UserMapper userMapper;
    private DemoMapper demoMapper;

    @Transactional
    public void joinUser(ProfileVO profileVo){
        demoMapper.saveUser(profileVo);
    }

    @Override
    public ProfileVO loadUserByUsername(String email) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
    ProfileVO profileVo = demoMapper.getUserAccount(email);
    profileVo.setAuth("USER");
        System.out.println("password is "+profileVo.getPassword());
        if (profileVo == null){
            System.out.println("ERROR");

            throw new UsernameNotFoundException("User not authorized.");
        }
        return profileVo;
    }

    @Transactional
    public int saveGame(ProfileVO profileVO) throws UsernameNotFoundException{
        return demoMapper.saveGame(profileVO);
    }
}