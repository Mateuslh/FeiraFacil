package com.feiraFacil.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseDto<T> {
    private boolean success;
    private String message;
    private long total;
    private boolean hasNext;
    private List<T> content;

    public PaginatedResponseDto fromPage(Page<T> page) {
        this.setTotal(page.getTotalElements());
        this.setContent(page.getContent());
        this.setSuccess(true);
        return this;
    }
}
