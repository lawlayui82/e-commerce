package com.lawlayui.e_commerce.E_Commerce.util.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.lawlayui.e_commerce.E_Commerce.dto.request.BaseRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;
import com.lawlayui.e_commerce.E_Commerce.entity.BaseEntity;

public interface GenericMapper<E extends BaseEntity, Req extends BaseRequest, UReq extends BaseRequest, Res extends BaseResponse>{
    E requestToEntity(Req request);
    Res entityToResponse(E entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UReq updateRequest, @MappingTarget E entity);

    List<Res> entityToResponses(List<E> entities);
}
