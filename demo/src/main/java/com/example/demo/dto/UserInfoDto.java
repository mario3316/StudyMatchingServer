package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 회원정보를 매핑 시킬 객체
public class UserInfoDto {
    private String email;
    private String password;
    private String auth;
}
