package com.example.demo.api.VO;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class ProfileVO implements UserDetails {

    private int pid;
    private String email;
    private String password;
    private String nickname;

    private int coin;

    private int character;

    private int last_character;
    private String auth;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public int getPid() {
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

    public int getCoin() {
        return coin;
    }

    public int getCharacter() {
        return character;
    }

    public int getLast_character() {
        return last_character;
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

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public void setLast_character(int last_character) {
        this.last_character = last_character;
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