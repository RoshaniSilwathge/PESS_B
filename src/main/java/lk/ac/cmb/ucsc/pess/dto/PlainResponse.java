package lk.ac.cmb.ucsc.pess.dto;

public class PlainResponse {
	private String message;

	public PlainResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
