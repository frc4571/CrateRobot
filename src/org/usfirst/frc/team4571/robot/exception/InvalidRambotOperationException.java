package org.usfirst.frc.team4571.robot.exception;

/**
 * 
 * @author arjrao
 *
 */
public class InvalidRambotOperationException extends RuntimeException {

	private static final long serialVersionUID = 1752793845719503028L;

	public InvalidRambotOperationException( String message ){
		super( message );
	}
	
    public InvalidRambotOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}