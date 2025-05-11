package com.tracktainment.reviewmanager.mapper;

import com.tracktainment.reviewmanager.exception.BusinessException;
import com.tracktainment.reviewmanager.exception.ExceptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ExceptionMapperEntryPointRest {

    ExceptionDto toExceptionDto(BusinessException e);
}
