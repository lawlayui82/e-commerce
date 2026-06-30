package com.lawlayui.e_commerce.E_Commerce.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;

public interface CanRead<Res extends BaseResponse> {
    default Res getById(Long id) throws Exception {return null;}
    default List<Res> getAll(Pageable pageable) throws Exception{return null;}
}
