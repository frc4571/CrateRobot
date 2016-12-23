package org.usfirst.frc.team4571.robot.web;

import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shell class to set up a sparkjava web server on the robot
 * 
 * @author arjunrao
 *
 */
public class RobotWebServer {
    
	private static final Logger logger = LoggerFactory.getLogger( RobotWebServer.class );
	
    public static void main(String[] args) {
    	RobotWebServer webserver = new RobotWebServer();
    	int portNum = 4571;
    	webserver.start(portNum);
    	logger.info( "RobotWebServer is up and running at port " + portNum );
    }
    
    public void start( int portNum ){
    	port( portNum );
        setupRoutes();
    }
    
    private void setupRoutes(){
    	get("/rambots", (req, res) -> "Hello Rambots!");
    }
}