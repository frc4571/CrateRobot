package org.usfirst.frc.team4571.robot.web;

import static spark.Spark.get;
import static spark.SparkBase.port;

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
    	int port = 4571;
    	webserver.start(port);
    	logger.info( "RobotWebServer is up and running at port " + port );
    }
    
    public void start( int port ){
    	port( port );
        setupRoutes();
    }
    
    private void setupRoutes(){
    	get("/rambots", (req, res) -> "Hello Rambots!");
    }
}