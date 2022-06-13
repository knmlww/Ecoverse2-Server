package com.example.demo.api.VO.Profile;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class ProfileVO implements UserDetails {

    private String pid;

    private String email;

    private String password;

    private String nickname;

    private String name;

    private int model;

    private String player_timezone;

    private String player_last_uptime;

    private int main_misson;

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


    private String auth = "USER";


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public String getPid() {
        return this.pid;
    }

    // 시큐리티의 userName
    // -> 따라서 얘는 인증할 때 id를 봄
    @Override
    public String getUsername() {
        return this.email;
    }

    // Vo의 userName !
    public String getUserName(){
        return this.nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setAuth(String user) {
        this.auth = user;
    }
}