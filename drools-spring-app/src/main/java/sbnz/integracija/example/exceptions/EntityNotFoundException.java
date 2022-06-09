package sbnz.integracija.example.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private String message;

	public EntityNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EntityNotFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
