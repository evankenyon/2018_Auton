package org.usfirst.frc.team868.robot.subsystems;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Spark mLeft = new Spark(RobotMap.DRIVE_LEFT_MOTOR);
	Spark mRight  = new Spark(RobotMap.DRIVE_RIGHT_MOTOR);
	Encoder left = new Encoder(RobotMap.ENC_LEFT_A, RobotMap.ENC_LEFT_B);
	Encoder right = new Encoder(RobotMap.ENC_RIGHT_A, RobotMap.ENC_RIGHT_B);

	Solenoid shift   = new Solenoid(0);
	private int leftOfs = 0;
	private int rightOfs = 0;
	
	
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public DriveSubsystem() {
    	mRight.setInverted(RobotMap.DRIVE_RIGHT_IS_INVERTED);
    	mLeft.setInverted(RobotMap.DRIVE_LEFT_IS_INVERTED);
    	left.setDistancePerPulse(4*Math.PI/2048);
    	right.setDistancePerPulse(1);
    	left.reset();
    	right.reset();
    	
    	left.setName("Drive", "LeftEnc");
    	right.setName("Drive", "RighEnc");
    	
    	mLeft.setName("Drive", "LeftMotor");
    	mRight.setName("Drive", "RightMotor");

    	zeroDashboard();
    }
    
    public void zeroDashboard() {
    	leftOfs = left.getRaw();
    	rightOfs = right.getRaw();
    }
    
    public void updateDashboard() {
    	SmartDashboard.putNumber("Left Counts", left.getRaw() - leftOfs);
    	SmartDashboard.putNumber("Right Counts", right.getRaw() - rightOfs);
    }
    
    public void setMotors(double left, double right) {
    	mLeft.set(right);
    	mRight.set(left);
    }
    
    public void resetEncoders() {
    	right.reset();
    	left.reset();
    }
    
    public void getRightEncoder() {
    	
    }

}

