// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Acquisition extends SubsystemBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private PWMTalonSRX spinMotor;
    private CANSparkMax lowerMotor;
    private final CANDigitalInput limitUp;
    private final CANDigitalInput limitDown;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
    *
    */
    public Acquisition() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        spinMotor = new PWMTalonSRX(ACQUISITION_SPIN_MOTOR_CAN_ID);
        addChild("spinMotor", spinMotor);
        spinMotor.setInverted(false);

        lowerMotor = new CANSparkMax(ACQUISITION_LOWER_MOTOR_CAN_ID, MotorType.kBrushless);
        lowerMotor.setInverted(false);

        limitUp = lowerMotor.getReverseLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyOpen);
        limitDown = lowerMotor.getForwardLimitSwitch(SparkMaxLimitSwitch.Type.kNormallyOpen);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        boolean isUp = limitUp.get();
        boolean isDown = limitDown.get();

        SmartDashboard.putBoolean("limit switch up", isUp);
        SmartDashboard.putBoolean("limit switch down", isDown);

        
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void startAcquire(){
        lowerMotor.set(0.5);
        spinMotor.set(1.0);
    }

    public void endAcquire(){
        lowerMotor.set(-0.5);
        spinMotor.set(0);
    }

    public void pause(){
        lowerMotor.set(0);
        spinMotor.set(0);
    }

    public void starReverse(){
        lowerMotor.set(0);
        spinMotor.set(-1.0);
    }

}
