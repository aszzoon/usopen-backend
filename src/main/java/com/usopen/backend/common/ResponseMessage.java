package com.usopen.backend.common;

// respons 시 확인 되는 메세지를 공통으로 묶어 관리한다.
public interface ResponseMessage {
	// HTTP Status 200
	String SUCCESS = "Success.";

	// HTTP Status 400
	String VALIDATION_FAILED = "Validation failed.";
	String DUPLICATE_EMAIL = "Duplicate email.";
	String DUPLICATE_NICKNAME = "Duplicate nickname.";
	String DUPLICATE_TEL_NUMBER = "Duplicate tell number.";
	String NOT_EXISTED_USER = "This user does not exist.";
	String NOT_EXISTED_BOARD = "This board does not exist.";

	// HTTP Status 401
	String SIGN_IN_FAIL = "Login information mismatch.";
	String AUTHENTICATION_FAIL = "Authorization Failed.";

	// HTTP status 403
	String NO_PERMISSION = "Do not have permission.";

	// HTTP Status 500
	String DATABASE_ERROR = "Database error.";

}