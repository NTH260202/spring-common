package com.example.rest.factory.impl;

import com.example.rest.factory.IResponseService;
import com.example.rest.model.response.BaseResponse;
import com.example.rest.model.response.ErrorResponse;
import com.thanhha.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class BaseResponseService implements IResponseService {

    @Override
    public <D> ResponseEntity<BaseResponse<D>> success(D data) {
        BaseResponse<D> response = BaseResponse.
                <D>builder()
                .data(data)
                .success(true)
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        response
                );
    }

    @Override
    public ResponseEntity<ErrorResponse> error(CustomException exception) {
        return ResponseEntity
                //TODO: get status from exception
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        getErrorResponse(exception)
                );
    }

    protected ErrorResponse getErrorResponse(CustomException exception) {
        return ErrorResponse
                .builder()
                .build();
    }
}
