package org.usfirst.frc.team4571.robot.web;

import org.eclipse.jetty.server.Server;

/**
 * Shell class to set up a web server on the robot
 * 
 * @author arjunrao
 *
 */
public class RobotWebServer {
	
    private Server server;

    public RobotWebServer(){
    	
    }
    
    public void startServer() {
        if (server != null) {
            return;
        }
        server = new Server(4571);
    }
}