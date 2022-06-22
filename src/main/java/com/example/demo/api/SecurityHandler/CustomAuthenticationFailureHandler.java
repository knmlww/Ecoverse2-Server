package com.example.demo.api.SecurityHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.SignStyle;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomAuthenticationFailureHandler
        implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

 /*   @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException, ServletException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        if(Objects.equals(exception.getMessage(), "UserDetailsService returned null, " +
                "which is an interface contract violation")){
            String errorMsg = "LOGIN_FAIL_NO_EMAIL";
            response.getOutputStream()
                    .println(objectMapper.writeValueAsString(errorMsg));
        } else if (Objects.equals(exception.getMessage(), "Bad credentials")) {
            String errorMsg = "LOGIN_FAIL";
            response.getOutputStream()
                    .println(objectMapper.writeValueAsString(errorMsg));
        }else{
            String errorMsg = "LOGIN_FAIL_ETC";
            response.getOutputStream()
                    .println(objectMapper.writeValueAsString(errorMsg));
        }


    }*/


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException accessException) throws IOException, ServletException {



        if (accessException instanceof AuthenticationServiceException) {
            request.setAttribute("error", "존재하지 않는 사용자입니다.");

        } else if(accessException instanceof BadCredentialsException) {
            request.setAttribute("error", "비밀번호가 틀립니다.");

        } else if(accessException instanceof LockedException) {
            request.setAttribute("error", "잠긴 계정입니다..");

        }


        // 로그인 페이지로 다시 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/access_denied");
        dispatcher.forward(request, response);

    }
}