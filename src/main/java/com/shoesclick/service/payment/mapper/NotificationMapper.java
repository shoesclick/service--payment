package com.shoesclick.service.payment.mapper;

import com.shoesclick.notification.avro.NotificationAvro;
import com.shoesclick.service.payment.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface NotificationMapper {

    NotificationAvro map(Notification notification);
}
