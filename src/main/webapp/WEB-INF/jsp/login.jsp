<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!--로그인 페이지-->
<!-- login.html-->
<!DOCTYPE html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<div class="container">
    <h1>로그인</h1>
    <form th:action="@{/test1}" method="post">
        <div class="form-group">
            <label th:for="username">아이디</label>
            <input type="text" name="email" class="form-control" placeholder="아이디를 입력해주세요">
        </div>
        <div class="form-group">
            <label th:for="password">비밀번호</label>
            <input type="password" class="form-control" name="password" placeholder="비밀번호를 입력해주세요">
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
        <button type="button" class="btn btn-primary" onClick="location.href='signUp'">회원 가입</button>
    </form>
    <br/>
</div>
</body>
