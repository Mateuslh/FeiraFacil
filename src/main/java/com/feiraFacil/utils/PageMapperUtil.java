package com.feiraFacil.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class PageMapperUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <E, D> Page<D> toPageDTO(Page<E> entityPage, Class<D> dtoClass) {
        List<D> dtoList = entityPage.getContent().stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, entityPage.getPageable(), entityPage.getTotalElements());
    }
}
