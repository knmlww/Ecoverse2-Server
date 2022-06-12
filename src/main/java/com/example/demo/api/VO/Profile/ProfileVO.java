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