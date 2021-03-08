package com.example.demo.service;

import com.example.demo.domain.entity.UserEntity;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    // Email 로 유저를 찾아서 반환하는 method
    // UsernameNotFoundException : 찾는 유저가 없을때 발생하는 예외
    public UserEntity loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    //회원 정보 저장
    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(UserEntity.builder()
                .email(infoDto.getEmail())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword()).build()).getCode();
    }
}
