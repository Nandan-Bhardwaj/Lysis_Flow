package com.lysisflow.repository;

import com.lysisflow.model.Query;
import com.lysisflow.model.QueryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
    List<Query> findByStatus(QueryStatus status);
}
