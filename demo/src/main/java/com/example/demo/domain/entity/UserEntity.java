package com.example.demo.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter

public class UserEntity implements UserDetails {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 고유 코드 자동 생성
    private Long code;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "auth")
    private String auth;

    @Builder
    public UserEntity(String email, String password, String auth) {
        this.email = email;
        this.password = password;
        this.auth = auth;
    }

    // GrantedAuthority를 상속받은 Subclass 들의 Collection 클래스로 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한이 중복되면 안되므로 Set을 사용
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // true이면 휴면 계정 아님
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // true 이면 잠금되지 않았음
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // true이면 패스워드 만료 아님
    }

    @Override
    public boolean isEnabled() {
        return true; // true 이면 계정 사용 가능
    }

}
