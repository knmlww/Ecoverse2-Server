package com.example.demo.api.Mapper;

import com.example.demo.api.DemoDTO.DemoDTO;
import com.example.demo.api.VO.ProfileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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
}
