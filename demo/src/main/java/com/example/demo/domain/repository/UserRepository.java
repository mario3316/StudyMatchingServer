package com.example.demo.domain.repository;

import com.example.demo.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JPA repository => 쿼리를 직접 짤 필요없이 상속받으면 알아서 find 해줌
// Optional 클래스 : null 일수도 있고 null 이 아닐수도 있는 객체를 담는 클래스
// Query 로 DB에서 꺼내오면 있을수도 있지만, 없으면 null 인데 이걸 조건문으로 null인지 아닌지 확인할 필요 없게 해줌
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
