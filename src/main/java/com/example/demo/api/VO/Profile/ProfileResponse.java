package com.example.demo.api.VO.Profile;


import lombok.Data;

import java.util.Date;

@Data
public class ProfileResponse {
    private String pid;
    private String email;
    private String password;
    private String nickname;

    private String name;

    private int model;

    private String player_timezone;

    private String player_last_uptime;

    private String main_misson;

    private String sub_misson;

    private String last_pos;

    private String last_city;

    private int balance;

    private String badge_state;

    private String license_state;

    private String update_time;

    private String inventory;

    private String import_info;

    private String export_info;

    private String energy_import;

    private String fuel_info;

    private String vehicle_unlock;


}
