/**
 * 
 */
package com.amol.ems.bean;

/**
 * @author MACK-WORLD
 *
 */
public class EMSErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	/**
	 * @param status
	 * @param message
	 * @param timeStamp
	 */
	public EMSErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	/**
	 * 
	 */
	public EMSErrorResponse() {
		super();
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "EMSErrorResponse [status=" + status + ", " + (message != null ? "message=" + message + ", " : "")
				+ "timeStamp=" + timeStamp + "]";
	}
}
