package com.example.demo.api.Controller;

import com.example.demo.api.Service.UserService;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserController {

    private final UserService userService;

    /**
     * 서버 정상 작동여부 확인
     * @return
     */
    @PostMapping("/server_status")
    public String serverStatus() {
        return "SERVER_OK";
    };

    /**
     * 회원가입 진행
     * @param profileVo
     * @return String
     */
    @PostMapping("/login")
    public String Login(@RequestParam String email) {
        return email;
    }

    /**
     * 회원가입 진행
     * @param profileVo
     * @return String
     */
    @PostMapping("/register")
    public String signUp(@RequestBody ProfileVO profileVo) {
        return userService.joinUser(profileVo);
    }


    /**
     * 유저 페이지
     * @param authentication
     * @return String
     */
    @GetMapping("/user_access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        ProfileVO profileVO = (ProfileVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        return "LOGIN_SUCCESS/PID:"+profileVO.getPid();

    }

    @GetMapping("/access_denied")
    public String accessDenied(HttpServletRequest request, HttpServletResponse response) {

     //   System.out.println(loginVO.getEmail());
        return "error";
    }

    /**
     * 회원탈퇴
     * @param profileVo
     * @return 1
     */
    @PostMapping("/withdraw_membership")
    public int withdrawMembership(@RequestBody ProfileVO profileVo) {
        return userService.withdrawMembership(profileVo);

    }
    /**
     * 프로필 정보 불러오기
     * @param profileVo
     * @return profileVO
     */
    @PostMapping("/load_profile")
    public ProfileResponse loadProfile(@RequestBody ProfileVO profileVo) {
        return userService.loadProfile(profileVo);
    }

    /**
     * 프로필 정보 업로드
     * @param profileVo
     * @return 1
     */
    @PostMapping("/upload_profile")
    public int uploadProfile(@RequestBody ProfileVO profileVo) throws Exception{
        return userService.uploadProfile(profileVo);
    }

    /**
     * 플레이어 모델 업데이트
     * @param profileVo
     * @return 1
     */
    @PostMapping("/update_player_model")
    public int updatePlayerModel(@RequestBody ProfileVO profileVo) throws Exception{
        return userService.updatePlayerModel(profileVo);
    }

    /**
     * 패스워드 초기화
     * @param profileVo
     * @return 1
     */
    @PostMapping("/password_reset")
    public int passwordReset(@RequestBody ProfileVO profileVo) throws Exception{
        return userService.passwordReset(profileVo);
    }

    /**
     * 도시 리스트업
     * @param listUpCity
     * @return List
     */
    @PostMapping("/list_up_city")
    public List<String> listUpCity(@RequestBody ListUpCity listUpCity) {
        return userService.listUpCity(listUpCity);
    }

    /**
     * 도시 정보 불러오기
     * @param CityVO
     * @return CityVO
     */
    @PostMapping("/load_city")
    public CityVO loadCity(@RequestBody CityVO CityVo) {
        return userService.loadCity(CityVo);
    }

    /**
     * 도시 정보 업로드
     * @param CityVO
     * @return 1
     */
    @PostMapping("/upload_city")
    public int uploadCity(@RequestBody CityVO CityVo) {
        return userService.uploadCity(CityVo);
    }

    /**
     * 도시 기부금 업데이트
     * @param CityVO
     * @return 1
     */
    @PostMapping("/update_donation")
    public int updateDonation(@RequestBody CityVO CityVo) {
        return userService.updateDonation(CityVo);
    }

    /**
     * 기간 도시 척도 데이터 업로드
     * @param CityVO
     * @return 1
     */
    @PostMapping("/upload_city_data")
    public int uploadCityData(@RequestBody CityDataVO CityDataVo) {
        return userService.uploadCityData(CityDataVo);
    }

    /**
     * 기간 도시 척도 데이터 불러오기
     * @param FriendVo
     * @return List
     */
    @PostMapping("/load_city_data")
    public List<Map<String, Object>> loadCityData(@RequestBody CityDataRequest cityDataRequest) {
        return userService.loadCityData(cityDataRequest);
    }
    /**
     * 맵 정보 불러오기
     * @param MapVO
     * @return MapVO
     */
    @PostMapping("/load_map")
    public MapVO loadMap(@RequestBody MapVO MapVo) {
        return userService.loadMap(MapVo);
    }

    /**
     * 맵 정보 업로드
     * @param MapVO
     * @return 1
     */
    @PostMapping("/upload_map")
    public int uploadMap(@RequestBody MapVO MapVo) {
        return userService.uploadMap(MapVo);
    }

    /**
     * 알림 리스트 불러오기
     * @param NotiVO
     * @return List
     */
    @PostMapping("/load_noti_list")
    public List<Map<String, Object>> loadNotiList(@RequestBody NotiVO NotiListVo) {
        return userService.loadNotiList(NotiListVo);
    }

    /**
     * 알림 세부내용 불러오기
     * @param NotiVO
     * @return NotiVO
     */
    @PostMapping("/load_noti_detail")
    public NotiVO loadNotiDetail (@RequestBody NotiVO NotiListVo) {
        return userService.loadNotiDetail(NotiListVo);
    }

    /**
     * 알림 세부내용 저장
     * @param NotiVO
     * @return 1
     */
    @PostMapping("/upload_noti_detail")
    public int uploadNotiDetail (@RequestBody NotiVO NotiListVo) {
        return userService.uploadNotiDetail(NotiListVo);
    }

    /**
     * 알림 삭제
     * @param NotiVO
     * @return 1
     */
    @PostMapping("/delete_noti")
    public int deleteNoti (@RequestBody NotiVO NotiListVo) {
        return userService.deleteNoti(NotiListVo);
    }

    /**
     * 알림 읽음 처리
     * @param NotiVO
     * @return 1
     */
    @PostMapping("/update_noti_isread")
    public int updateNotiIsread (@RequestBody NotiVO NotiListVo) {
        return userService.updateNotiIsread(NotiListVo);
    }

    /**
     * 친구요청
     * @param NotiVO
     * @return 1
     */
    @PostMapping("/request_friend")
    public int requestFriend (@RequestBody NotiVO NotiListVo) {
        return userService.requestFriend(NotiListVo);
    }
    /**
     * 친구수락
     * @param FriendVo
     * @return 1
     */
    @PostMapping("/accept_friend")
    public int acceptFriend (@RequestBody FriendVO FriendVo) {
        return userService.acceptFriend(FriendVo);
    }

    /**
     * 친구삭제
     * @param FriendVo
     * @return int
     */
    @PostMapping("/delete_friend")
    public int deleteFriend  (@RequestBody FriendVO FriendVo) {
        return userService.deleteFriend(FriendVo);
    }
    /**
     * 친구 목록 불러오기
     * @param FriendVo
     * @return List
     */
    @PostMapping("/load_friend_list")
    public List<Map<String, Object>> loadFriendList(@RequestBody FriendVO FriendVo) {
        return userService.loadFriendList(FriendVo);
    }
}
