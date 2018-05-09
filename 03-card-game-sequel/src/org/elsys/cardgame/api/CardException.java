package org.elsys.cardgame.api;

public class CardException extends RuntimeException {

	String errMsg;
	
	public CardException(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getError() {
		return errMsg;
	}
	
	private static final long serialVersionUID = 8822513014262189134L;

}
