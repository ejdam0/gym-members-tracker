package pl.adam.database.rest;

public class GymMemberNotFoundException extends RuntimeException {

	public GymMemberNotFoundException() {

	}

	public GymMemberNotFoundException(String message) {
		super(message);

	}

	public GymMemberNotFoundException(Throwable cause) {
		super(cause);

	}

	public GymMemberNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public GymMemberNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
