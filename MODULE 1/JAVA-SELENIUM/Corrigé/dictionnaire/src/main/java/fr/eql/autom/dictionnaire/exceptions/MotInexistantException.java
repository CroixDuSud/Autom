package fr.eql.autom.dictionnaire.exceptions;

public class MotInexistantException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2678426990607455752L;

	public MotInexistantException() {
		super();
	}

	public MotInexistantException(String message, Throwable cause) {
		super(message, cause);
	}

	public MotInexistantException(String message) {
		super(message);
	}

	public MotInexistantException(Throwable cause) {
		super(cause);
	}
}
