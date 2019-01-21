package org.silvasoft.tools.resizer;

public class ResizeException extends Throwable {
	private final int lastError;

	public ResizeException(int lastError) {

		this.lastError = lastError;
	}

	public int getLastError() {
		return lastError;
	}
}
