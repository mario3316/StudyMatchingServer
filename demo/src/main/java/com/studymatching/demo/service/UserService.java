package com.studymatching.demo.service;

import com.studymatching.demo.domain.UserInfo;
import com.studymatching.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    // Email 로 유저를 찾아서 반환하는 method
    // UsernameNotFoundException : 찾는 유저가 없을때 발생하는 예외
    public UserInfo loadUserByUserName(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
