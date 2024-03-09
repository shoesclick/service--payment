package com.shoesclick.service.payment.mapper;

import com.shoesclick.service.payment.entity.Log;
import com.shoesclick.service.payment.enums.TypeLog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mapping;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface LoggerMapper {

    @Mapping(target = "className", source = "className")
    @Mapping(target = "methodName", source = "methodName")
    @Mapping(target = "details", source = "message")
    @Mapping(target = "typeLog", source = "typeLog")
    Log map(String className, String methodName, String message, TypeLog typeLog);

}
