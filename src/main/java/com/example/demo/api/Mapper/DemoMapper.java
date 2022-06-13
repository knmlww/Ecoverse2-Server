package com.example.demo.api.Mapper;

import com.example.demo.api.DemoDTO.DemoDTO;
import com.example.demo.api.VO.City.CityVO;
import com.example.demo.api.VO.Map.MapVO;
import com.example.demo.api.VO.Notification.NotiVO;
import com.example.demo.api.VO.Profile.ProfileResponse;
import com.example.demo.api.VO.Profile.ProfileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DemoMapper{
    List<DemoDTO> test1();

    int test2(HashMap<String, String> dataMap);

    int test3(HashMap<String, Object> dataMap);

    ProfileVO getUserAccount(String email);

    // 회원가입
    void saveUser(ProfileVO profileVo);

    int saveGame(ProfileVO profileVO);

    int checkEmail(String paramEmail);

    int withdrawMembership(String pid);

    ProfileResponse loadProfile(String pid);

    int uploadProfile(ProfileVO profileVo);

    CityVO loadCity(CityVO cityVo);

    int uploadCity(CityVO cityVo);

    MapVO loadMap(MapVO MapVo);

    int uploadMap(MapVO mapVo);

    List<Map<String, Object>>  loadNotiList(NotiVO notiListVo);
}
