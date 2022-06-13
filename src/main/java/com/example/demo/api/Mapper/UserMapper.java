package com.example.demo.api.Mapper;

import com.example.demo.api.VO.Profile.ProfileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    // 로그인
    ProfileVO getUserAccount(String userId);

    // 회원가입
    void saveUser(ProfileVO profileVo);

    int saveGame(ProfileVO profileVO);
}