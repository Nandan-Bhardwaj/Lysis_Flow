package com.lysisflow.dto;

import com.lysisflow.model.QueryStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryDTO {
    private Long id;
    private String queryType;
    private String description;
    private QueryStatus status;
}
