package com.dali186.developermaker.repository;

import com.dali186.developermaker.entity.Developer;
import com.dali186.developermaker.type.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByMemberId(String memberId);

    List<Developer> findDeveloperByStatusCodeEquals(StatusCode statusCode);
}
