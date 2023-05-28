package com.splitwiseimpl.splitwise.ras;

import com.splitwiseimpl.splitwise.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
