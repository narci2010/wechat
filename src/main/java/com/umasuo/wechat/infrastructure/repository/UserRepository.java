package com.umasuo.wechat.infrastructure.repository;

import com.umasuo.wechat.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * cart repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>,
    CrudRepository<User, String> {

}
