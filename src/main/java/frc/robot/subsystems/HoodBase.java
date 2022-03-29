// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Servo; 

public class HoodBase extends SubsystemBase {
  public static Servo LeftShooterServo = RobotContainer.leftShooterServo;
  public static Servo RightShooterServo = RobotContainer.rightShooterServo;

  public double currentExtenstion;
  /** Creates a new HoodBase. */
  public HoodBase() {
    LeftShooterServo.setBounds(2.0,1.8,1.5,1.2,1.0);
    RightShooterServo.setBounds(2.0,1.8,1.5,1.2,1.0);
    LeftShooterServo.setAngle(0);
    RightShooterServo.setAngle(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setExtension(double extension){
    if (extension == 0) {
      LeftShooterServo.setAngle(0);
      RightShooterServo.setAngle(0);
      currentExtenstion = 0; 
    }
    else if (extension > 1 && extension < 180)
    {
      LeftShooterServo.setAngle(extension);
      RightShooterServo.setAngle(extension);
      currentExtenstion = extension; 
    }
    else {
      if(extension > 179){
        LeftShooterServo.setAngle(179);
        RightShooterServo.setAngle(179);
        currentExtenstion = 179; 
      }

      else{
        LeftShooterServo.setAngle(101);
        RightShooterServo.setAngle(101);
        currentExtenstion = 101; 
      }

    }

  }
}
