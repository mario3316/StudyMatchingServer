package main.java.com.studymatching.demo.dto;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

@Getter
@Setter
// 회원정보를 매핑 시킬 객체
public class UserInfoDTO {
    private String email;
    private String password;
    private String auth;
}
