package com.example.rest.controller;

import com.example.rest.model.IModel;
import com.example.rest.model.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/")
public interface ICreateModelController<I, U extends IModel<I>> {
    @PostMapping("create")
    ResponseEntity<BaseResponse<U>> createModel(@RequestBody @Valid U request);
}
