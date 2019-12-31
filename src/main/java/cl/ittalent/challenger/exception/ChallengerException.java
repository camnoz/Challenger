package cl.ittalent.challenger.exception;

import org.springframework.http.HttpStatus;

public class ChallengerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final HttpStatus httpStatus;
	private String message;

	public ChallengerException(String message, HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
		this.setMessage(message);

	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
