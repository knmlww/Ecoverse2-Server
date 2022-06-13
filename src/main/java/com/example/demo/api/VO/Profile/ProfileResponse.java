package com.example.demo.api.VO.Profile;


import lombok.Data;

@Data
public class ProfileResponse {
    private String pid;
    private String email;
    private String password;
    private String nickname;

    private String name;

    private int model;

    private String player_timezone;

    private String PLAYER_LAST_UPTIME;

    private String MAIN_MISSON;

    private String SUB_MISSON;

    private String LAST_POS;

    private String LAST_CITY;

    private int BALANCE;

    private String BADGE_STATE;

    private String LICENSE_STATE;

    private String UPDATE_TIME;

    private String INVENTORY;

    private String IMPORT_INFO;

    private String EXPORT_INFO;

    private String ENERGY_IMPORT;

    private String FUEL_INFO;

    private String VEHICLE_UNLOCK;

}
