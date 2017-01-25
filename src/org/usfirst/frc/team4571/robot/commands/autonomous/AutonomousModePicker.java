package org.usfirst.frc.team4571.robot.commands.autonomous;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 * Pick autonomous modes to run via smart dashboard
 * 
 * @author arjunrao87
 *
 */
public final class AutonomousModePicker implements LiveWindowSendable {

	protected static final String AUTONOMOUS_MODE = "Autonomous Mode";
	
	private ITable table;
	private ITableListener listener;
	private Map<String, AutonomousMode> modes;
	
	public AutonomousModePicker(){
		this.modes = new HashMap<>();
		this.listener = initTableListener();
	}

	private ITableListener initTableListener() {
		return new ITableListener() {
			
			@Override
			public void valueChanged( ITable source, String key, Object value, boolean isNew ) {
				if( AUTONOMOUS_MODE.equals(key) ){
					
				} else{
					
				}
			}
		};
	}

	public void addAutonomousMode( AutonomousMode mode ){
		this.modes.put( mode.name(), mode );
	}
	
	@Override
	public void initTable(ITable subtable) {
		if (this.table != null)
		      this.table.removeTableListener(listener);	
		}

	@Override
	public ITable getTable() {
		return table;
	}

	@Override
	public String getSmartDashboardType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startLiveWindowMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopLiveWindowMode() {
		// TODO Auto-generated method stub
		
	}
}