package com.usopen.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usopen.backend.entity.UserEntity;

//Repository 객체 지정
@Repository
//UserRepository 인터페이스는 Jpa를 통해 UserEntity를 상속 받음
public interface UserRepository extends JpaRepository<UserEntity, String> {

  // existsByEmail(쿼리메소드)를 이용하여, email이 존재하면 ture를 반환
  boolean existsByEmail(String email);
  boolean existsByNickname(String nickname);
  boolean existsByTelNumber(String TelNumber);

  UserEntity findByEmail(String email);
}
