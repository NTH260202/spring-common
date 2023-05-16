package com.example.rest.factory;

import com.example.rest.model.response.BaseResponse;
import com.example.rest.model.response.ErrorResponse;
import com.thanhha.exception.CustomException;
import org.springframework.http.ResponseEntity;

public interface IResponseService {
    ResponseEntity<ErrorResponse> error(CustomException exception);
    <D> ResponseEntity<BaseResponse<D>> success(D data);
}
