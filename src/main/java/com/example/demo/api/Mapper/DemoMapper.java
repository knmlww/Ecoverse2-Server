package com.example.demo.api.Mapper;

import com.example.demo.api.DemoDTO.DemoDTO;
import com.example.demo.api.VO.City.CityDataRequest;
import com.example.demo.api.VO.City.CityDataVO;
import com.example.demo.api.VO.City.CityVO;
import com.example.demo.api.VO.City.ListUpCity;
import com.example.demo.api.VO.Friends.FriendVO;
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
    int saveUser(ProfileVO profileVo);

    void saveCity(String pid);

    void saveMap(String pid);

    int saveGame(ProfileVO profileVO);

    int checkEmail(String paramEmail);

    int withdrawMembership(String pid);

    ProfileResponse loadProfile(String pid);

    int uploadProfile(ProfileVO profileVo);

    int updatePlayerModel(ProfileVO profileVo);

    int passwordReset(ProfileVO profileVo);

    List<String> listUpCity(ListUpCity listUpCity);

    CityVO loadCity(CityVO cityVo);

    int uploadCity(CityVO cityVo);

    int updateDonation(CityVO cityVo);
    
    int uploadCityData(CityDataVO cityDataVo);

    List<Map<String, Object>> loadCityData(CityDataRequest cityDataRequest);

    MapVO loadMap(MapVO MapVo);

    int uploadMap(MapVO mapVo);

    List<Map<String, Object>>  loadNotiList(NotiVO notiListVo);

    NotiVO loadNotiDetail(NotiVO notiListVo);

    int uploadNotiDetail(NotiVO notiListVo);

    int deleteNoti(NotiVO notiListVo);

    int updateNotiIsread(NotiVO notiListVo);

    int requestFriend(NotiVO notiListVo);

    int acceptFriend(FriendVO friendVo);

    int acceptFriend2(FriendVO friendVo);

    int deleteFriend(FriendVO friendVo);

    int deleteFriend2(FriendVO friendVo);

    List<Map<String, Object>> loadFriendList(FriendVO friendVo);


}
