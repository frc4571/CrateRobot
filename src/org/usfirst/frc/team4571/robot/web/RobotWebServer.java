package org.usfirst.frc.team4571.robot.web;

import static spark.Spark.*;

/**
 * Shell class to set up a sparkjava web server on the robot
 * 
 * @author arjunrao
 *
 */
public class RobotWebServer {
    
    public static void main(String[] args) {
    	RobotWebServer webserver = new RobotWebServer();
    	webserver.start();
    }
    
    public void start(){
    	port( 4571 );
        setupRoutes();
    }
    
    private void setupRoutes(){
    	get("/rambots", (req, res) -> "Hello Rambots!");
    }
}