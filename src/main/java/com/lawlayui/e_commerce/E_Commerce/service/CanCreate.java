package com.lawlayui.e_commerce.E_Commerce.service;

import com.lawlayui.e_commerce.E_Commerce.dto.request.BaseRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;

public interface CanCreate<REQ extends BaseRequest, RES extends BaseResponse> {
    default RES create(REQ createRequest) throws Exception {return null;}
}
