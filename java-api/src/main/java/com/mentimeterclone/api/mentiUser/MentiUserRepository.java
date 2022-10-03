package com.mentimeterclone.api.mentiUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentiUserRepository extends JpaRepository<MentiUser, Long> {
}
