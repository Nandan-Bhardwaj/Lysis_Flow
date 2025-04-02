package com.lysisflow.controller;

import com.lysisflow.dto.QueryDTO;
import com.lysisflow.model.Query;
import com.lysisflow.model.QueryStatus;
import com.lysisflow.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/queries")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping
    public List<QueryDTO> getAllQueries() {
        List<Query> queries = queryService.getAllQueries();
        return queries.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public QueryDTO getQueryById(@PathVariable Long id) {
        Optional<Query> query = queryService.getQueryById(id);
        return query.map(this::convertToDTO).orElse(null);
    }

    @GetMapping("/status/{status}")
    public List<QueryDTO> getQueriesByStatus(@PathVariable QueryStatus status) {
        List<Query> queries = queryService.getQueriesByStatus(status);
        return queries.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping
    public Query createQuery(@RequestBody Query query) {
        return queryService.saveQuery(query);
    }
    
    private QueryDTO convertToDTO(Query query) {
        QueryDTO dto = new QueryDTO();
        dto.setId(query.getId());
        dto.setQueryType(query.getQueryType());
        dto.setDescription(query.getDescription());
        dto.setStatus(query.getStatus());
        return dto;
    }
}
