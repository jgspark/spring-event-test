package com.example.springeventtest.infra.repository;

import com.example.springeventtest.domain.event.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    Optional<History> findByMailId(Long mailId);
}
