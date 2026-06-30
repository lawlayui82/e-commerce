package com.lawlayui.e_commerce.E_Commerce.service;

import com.lawlayui.e_commerce.E_Commerce.dto.request.BaseRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;

public interface CanUpdate<REQ extends BaseRequest, RES extends BaseResponse> {
    default RES update(REQ updateRequest, Long id) throws Exception {return null;}
}
