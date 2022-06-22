package com.example.demo.api.Service;

import com.example.demo.api.Mapper.DemoMapper;

import com.example.demo.api.VO.City.CityDataRequest;
import com.example.demo.api.VO.City.CityDataVO;
import com.example.demo.api.VO.City.CityVO;
import com.example.demo.api.VO.City.ListUpCity;
import com.example.demo.api.VO.Friends.FriendVO;
import com.example.demo.api.VO.Map.MapVO;
import com.example.demo.api.VO.Notification.NotiVO;
import com.example.demo.api.VO.Profile.LoginVO;
import com.example.demo.api.VO.Profile.ProfileResponse;
import com.example.demo.api.VO.Profile.ProfileVO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Transactional(rollbackFor = {Exception.class})
    public String joinUser(ProfileVO profileVo){
        String paramEmail = profileVo.getEmail();
        String result = null;
        int checkEmail = demoMapper.checkEmail(paramEmail);
        if(checkEmail==0){

                demoMapper.saveUser(profileVo);
                demoMapper.saveCity(profileVo.getPid());
                demoMapper.saveMap(profileVo.getPid());

            result =  "SIGNUP_SUCCESS";
        } else if (checkEmail==1) {
            result =  "SIGNUP_FAIL_EMAIL";
        }
        return result;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginVO loginVO = new LoginVO();

        loginVO.setEmail(email);

        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        ProfileVO profileVo = demoMapper.getUserAccount(email);

        if(profileVo==null){
           //throw new UserException("ERRORROR");

           // System.out.println("Hello");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
       // return demoMapper.getUserAccount(email);
            return profileVo;
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
     * 플레이어 모델 업데이트
     * @param profileVO
     * @return 1
     */
    public int updatePlayerModel(ProfileVO profileVo) {
        return demoMapper.updatePlayerModel(profileVo);
    }

    /**
     * 패스워드 초기화
     * @param profileVo
     * @return 1
     */
    public int passwordReset(@RequestBody ProfileVO profileVo) throws Exception{
        return demoMapper.passwordReset(profileVo);
    }

    /**
     * 도시 리스트업
     * @param listUpCity
     * @return List
     */
    public List<String> listUpCity(ListUpCity listUpCity) {

        return demoMapper.listUpCity(listUpCity);

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
     * 도시 기부금 업데이트
     * @param CityVO
     * @return 1
     */
    public int updateDonation(CityVO cityVo) {
        return demoMapper.updateDonation(cityVo);
    }

    /**
     * 기간 도시 척도 데이터 업로드
     * @param CityVO
     * @return 1
     */
    public int uploadCityData(CityDataVO CityDataVo) {
        return demoMapper.uploadCityData(CityDataVo);
    }
    /**
     * 기간 도시 척도 데이터 불러오기
     * @param CityVO
     * @return 1
     */
    public List<Map<String, Object>> loadCityData(CityDataRequest cityDataRequest) {
        return demoMapper.loadCityData(cityDataRequest);
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

    /**
     * 알림 리스트 불러오기
     * @param NotiVO
     * @return List
     */
    public List<Map<String, Object>> loadNotiList(NotiVO notiListVo) {
        return demoMapper.loadNotiList(notiListVo);
    }

    /**
     * 알림 세부내용 불러오기
     * @param NotiVO
     * @return NotiVO
     */
    public NotiVO loadNotiDetail(NotiVO notiListVo) {
        return demoMapper.loadNotiDetail(notiListVo);
    }

    /**
     * 알림 세부내용 저장
     * @param NotiVO
     * @return 1
     */
    public int uploadNotiDetail(NotiVO notiListVo) {
        return demoMapper.uploadNotiDetail(notiListVo);
    }

    /**
     * 알림 삭제
     * @param NotiVO
     * @return 1
     */
    public int deleteNoti(NotiVO notiListVo) {
        return demoMapper.deleteNoti(notiListVo);
    }

    /**
     * 알림 읽음 처리
     * @param NotiVO
     * @return 1
     */
    public int updateNotiIsread(NotiVO notiListVo) {
        return demoMapper.updateNotiIsread(notiListVo);
    }

    /**
     * 친구요청
     * @param NotiVO
     * @return 1
     */
    public int requestFriend(NotiVO notiListVo) {
        return demoMapper.uploadNotiDetail(notiListVo);
    }

    /**
     * 친구수락
     * @param
     * @return 1
     */
    @Transactional(rollbackFor = {Exception.class})
    public int acceptFriend(FriendVO friendVo) {
        int i = demoMapper.acceptFriend(friendVo);
        int j = demoMapper.acceptFriend2(friendVo);
        return i+j;
    }

    /**
     * 친구삭제
     * @param FriendVo
     * @return int
     */
    @Transactional(rollbackFor = {Exception.class})
    public int deleteFriend(FriendVO friendVo) {
        int i = demoMapper.deleteFriend(friendVo);
        int j = demoMapper.deleteFriend2(friendVo);

        return i+j;
    }

    public List<Map<String, Object>> loadFriendList(FriendVO friendVo) {
        return demoMapper.loadFriendList(friendVo);
    }



}