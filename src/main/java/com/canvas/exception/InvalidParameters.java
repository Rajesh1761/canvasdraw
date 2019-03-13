package com.canvas.exception;

public class InvalidParameters extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1626121544732081818L;
	private final String customMessage;

	public InvalidParameters(String message, String customMessage) {
		super(message);
		this.customMessage = customMessage;
	}

	/**
	 * @return the customMessage
	 */
	public String getCustomMessage() {
		return customMessage;
	}
}
