package com.example.demo.config;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // Spring Security 를 설정하기 위해 WebSecurityConfigurerAdapter 를 상속받음

    private final UserService userService;

    @Override
    public void configure(WebSecurity web) { // 인증이 필요없는 경로는 인증에서 제외
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {  //http 인증 설정
        http
                .authorizeRequests()
                .antMatchers("/login", "/signup", "/user", "/", "/post").permitAll() // 누구나 접근 가능
                .antMatchers("/detail", "/update", "/write", "/post").hasRole("USER") // USER 권한 필요
                .antMatchers("/admin").hasRole("ADMIN") // ADMIN 권한 필요
                .anyRequest().authenticated() // 나머지 요청은 모두 권한 종류 상관없이 권한이 있어야 함
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/") // 로그인 페이지 설정, 로그인 후 "/"로 Redirect
                .and()
                .logout().logoutSuccessUrl("/login").invalidateHttpSession(true); // 로그아웃시 "/login" 으로 Redirect 하고 세션 날림
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 로그인시 필요한 정보 세팅
        auth.userDetailsService(userService)
                // 해당 서비스(userService)에서는 UserDetailsService를 implements해서
                // loadUserByUsername() 구현해야함 (서비스 참고)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
