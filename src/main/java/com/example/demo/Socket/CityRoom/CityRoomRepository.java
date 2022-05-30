package com.example.demo.Socket.CityRoom;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class CityRoomRepository {
    private Map<String, CityRoom> cityRoomMap;

    @PostConstruct
    private void init(){
        cityRoomMap = new LinkedHashMap<>();
    }

    public List<CityRoom> findAllRoom(){
        List cityRooms = new ArrayList<>(cityRoomMap.values());
        Collections.reverse(cityRooms);
        return cityRooms;
    }

    public CityRoom findRoomById(String id){
        return cityRoomMap.get(id);
    }

    public CityRoom createChatRoom(String pid){
//        System.out.println("createChatRoom");
        CityRoom cityRoom = CityRoom.create(pid);
        cityRoomMap.put(cityRoom.getRoomId(), cityRoom);
        System.out.println("===============BEGIN==========================");
        cityRoomMap.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("================END==========================");
        return cityRoom;
    }

    public Object deleteChatRoom(String pid){
        cityRoomMap.remove(pid);
        System.out.println("===============BEGIN==========================");
        cityRoomMap.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("================END==========================");
        return cityRoomMap;
    }
}