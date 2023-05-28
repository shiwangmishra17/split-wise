package com.splitwiseimpl.splitwise.ras;

import com.splitwiseimpl.splitwise.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
