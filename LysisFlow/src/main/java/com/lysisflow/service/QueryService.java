package com.lysisflow.service;

import com.lysisflow.model.Query;
import com.lysisflow.model.QueryStatus;
import com.lysisflow.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;

    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }

    public List<Query> getQueriesByStatus(QueryStatus status) {
        return queryRepository.findByStatus(status);
    }

    public Optional<Query> getQueryById(Long id) {
        return queryRepository.findById(id);
    }

    public Query saveQuery(Query query) {
        return queryRepository.save(query);
    }
}
