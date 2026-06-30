package com.lawlayui.e_commerce.E_Commerce.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime udpateAt;
}
