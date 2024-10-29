package com.feiraFacil.dto;

import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractDTO<E, DTO extends AbstractDTO<E, DTO>> {

    private static final ModelMapper modelMapper = new ModelMapper();
    private final Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractDTO(E e) {
        this.entityClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        modelMapper.map(e, this);
    }

    public E toEntity() {
        return modelMapper.map(this, entityClass);
    }
}