package com.usopenblog.usopen_blog_backend_20240515.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.usopenblog.usopen_blog_backend_20240515.common.ResponseCode;
import com.usopenblog.usopen_blog_backend_20240515.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {

	private String code;
	private String message;

	public static ResponseEntity<ResponseDto> databaseError() {
		ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
	}

}
