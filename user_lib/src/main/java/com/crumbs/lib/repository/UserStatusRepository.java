package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Owner;
import com.crumbs.lib.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, String> {
}
