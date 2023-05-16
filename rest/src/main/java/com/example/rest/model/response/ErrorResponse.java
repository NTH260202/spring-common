package com.example.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ErrorResponse extends BaseResponse<Object> {
    private String title;
    private String subTitle;
    private String message;
    private String code;
}
