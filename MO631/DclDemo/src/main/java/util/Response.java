package util;

public class Response {

	private String message;
	private boolean success;
	
	public Response(boolean success) {
		this.success = success;
	}

	public Response(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

    public void setMessage(String message){
    	this.message = message;
    }
	
	public boolean isSuccess() {
		return this.success;
	}
}
