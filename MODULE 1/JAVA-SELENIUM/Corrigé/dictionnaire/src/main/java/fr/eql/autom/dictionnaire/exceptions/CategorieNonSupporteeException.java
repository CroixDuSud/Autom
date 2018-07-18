package fr.eql.autom.dictionnaire.exceptions;

public class CategorieNonSupporteeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4678604610942656313L;

	
	public CategorieNonSupporteeException(){
		super();
	}


	public CategorieNonSupporteeException(String message, Throwable cause) {
		super(message, cause);
	}


	public CategorieNonSupporteeException(String message) {
		super(message);
	}


	public CategorieNonSupporteeException(Throwable cause) {
		super(cause);
	}
	
	
}
