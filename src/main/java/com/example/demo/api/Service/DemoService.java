package com.example.demo.api.Service;

import com.example.demo.api.DemoDTO.DemoDTO;
import com.example.demo.api.Mapper.DemoMapper;
import com.example.demo.api.VO.paramVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoMapper demoMapper;

    /**
     * DB select 메서드
     * @param param
     * @return dataMap
     */
    public List<DemoDTO> test1() {

        return demoMapper.test1();
    }
    /**
     * DB insert 메서드
     * @param param
     * @return 1
     */
    public int test2 (paramVO.test2 param){
        HashMap<String,String> dataMap = new HashMap<>();

        dataMap.put("name", param.getName());
        dataMap.put("subject", param.getSubject());

        return demoMapper.test2(dataMap);
    }

    /**
     * DB update 메서드
     * @param param
     * @return 1
     */
    public int test3(paramVO.test3 param) {
        HashMap<String,Object> dataMap = new HashMap<>();
        dataMap.put("id",param.getId());
        dataMap.put("name", param.getName());
        dataMap.put("subject", param.getSubject());
        return demoMapper.test3(dataMap);
    }


}
