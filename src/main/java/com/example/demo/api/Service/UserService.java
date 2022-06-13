package com.example.demo.api.Service;

import com.example.demo.api.Mapper.DemoMapper;

import com.example.demo.api.VO.City.CityVO;
import com.example.demo.api.VO.Map.MapVO;
import com.example.demo.api.VO.Notification.NotiVO;
import com.example.demo.api.VO.Profile.ProfileResponse;
import com.example.demo.api.VO.Profile.ProfileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    @Autowired
   // private UserMapper userMapper;
    private DemoMapper demoMapper;

    /**
     * 회원가입 진행
     * @param profileVo
     * @return String
     */
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

    /**
     * 회원탈퇴
     * @param profileVO
     * @return 1
     */
    public int withdrawMembership(ProfileVO profileVo) {
       String pid = profileVo.getPid();
       return demoMapper.withdrawMembership(pid);
    }

    /**
     * 프로필 정보 불러오기
     * @param profileVO
     * @return profileVO
     */
    public ProfileResponse loadProfile(ProfileVO profileVo) {
        String pid = profileVo.getPid();
        return demoMapper.loadProfile(pid);
    }

    /**
     * 프로필 정보 업로드
     * @param profileVO
     * @return 1
     */
    public int uploadProfile(ProfileVO profileVo) throws Exception {
        return demoMapper.uploadProfile(profileVo);
    }

    /**
     * 도시 정보 불러오기
     * @param CityVO
     * @return CityVO
     */
    public CityVO loadCity(CityVO cityVo) {
        return demoMapper.loadCity(cityVo);
    }

    /**
     * 도시 정보 업로드
     * @param CityVO
     * @return 1
     */
    public int uploadCity(CityVO cityVo) {
        return demoMapper.uploadCity(cityVo);
    }

    /**
     * 맵 정보 불러오기
     * @param MapVO
     * @return MapVO
     */
    public MapVO loadMap(MapVO MapVo) {
        return demoMapper.loadMap(MapVo);
    }

    /**
     * 맵 정보 업로드
     * @param MapVO
     * @return 1
     */
    public int uploadMap(MapVO MapVo) {
        return demoMapper.uploadMap(MapVo);
    }

    public List<Map<String, Object>> loadNotiList(NotiVO notiListVo) {
        return demoMapper.loadNotiList(notiListVo);
    }
}