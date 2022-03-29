// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;
//import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

public class DriveBase extends SubsystemBase {

  WPI_TalonSRX leftTalon = RobotContainer.leftFrontTalon;
  WPI_TalonSRX rightTalon = RobotContainer.rightFrontTalon;
  WPI_VictorSPX leftVictor = RobotContainer.leftBackVictor;
  WPI_VictorSPX rightVictor = RobotContainer.rightBackVictor;
 
  double leftMotorSpeed = 0;
  double rightMotorSpeed = 0; 
  public boolean isInverted = false;



  /** Creates a new DriveBase. */
  public DriveBase() {}


  public void JoystickInputs(Joystick rightJoystick, Joystick leftJoystick){
 
    //SWITCHES DIRECTION OF MOTOR CONTROL - WHILE BUTTON NOT HELD, NORMAL, WHILE BUTTON HELD, REVERSED
    if(!(isInverted))
    {
      leftMotorSpeed = leftJoystick.getY();//get values from joystick
      rightMotorSpeed = rightJoystick.getY()*-1;
    }
    else
    {
      leftMotorSpeed = rightJoystick.getY();//get values from joystick
      rightMotorSpeed = leftJoystick.getY()*-1;
    }
    /**leftTalon.set(leftMotorSpeed);
    leftVictor.set(leftMotorSpeed);
    rightTalon.set(rightMotorSpeed);
    rightVictor.set(rightMotorSpeed);**/

    leftTalon.set(leftMotorSpeed);
    leftVictor.set(leftMotorSpeed);
    rightTalon.set(rightMotorSpeed*0.95);
    rightVictor.set(rightMotorSpeed*0.95);

  }

  public void Input(double input){
    leftTalon.set(input);
    leftVictor.set(input);
    rightTalon.set(input);
    rightVictor.set(input);

  }

  public void driveAuto(double input){
    if (input < 0)
    //go BACKWARDS
    {
       leftTalon.set(-.2);
       rightTalon.set(.2);
       leftVictor.set(-.2);
       rightVictor.set(.2);
    }
    else
    //go FORWARDS
    {
       leftTalon.set(-.5);
       leftVictor.set(-.5);
       rightTalon.set(.5);
       rightVictor.set(.5);
    }
    }
  public void driveStopAuto()
  {
    leftTalon.set(0);
    rightTalon.set(0);
    leftVictor.set(0);
    rightVictor.set(0);
  }

  public void driveTurnAuto(double input)
  {
    if(input < 0)
    //turn LEFT
    {
      leftTalon.set(0.5);
      rightTalon.set(0.5);
      leftVictor.set(0.5);
      rightVictor.set(0.5);
  
    }
    else
    //turn RIGHT
    {
      leftTalon.set(-0.5);
      rightTalon.set(-0.5);
      leftVictor.set(-0.5);
      rightVictor.set(-0.5);

    }
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
