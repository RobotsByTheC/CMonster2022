// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.revrobotics.CANSparkMax;

public class ShooterBase extends SubsystemBase {

  //public static CANSparkMax LeftShooterSpark = RobotContainer.leftShooterSpark; 
  public static CANSparkMax RightShooterSpark = RobotContainer.rightShooterSpark; 


  /** Creates a new ShooterBase. */
  public ShooterBase() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

 public void ShootBallOn(){
   // LeftShooterSpark.set(0.7);
    RightShooterSpark.set(0.7);
  }
  public void ShootBallOff(){
   // LeftShooterSpark.set(0);
    RightShooterSpark.set(0);
  }
  public void AutoShootBallOn(){
 // LeftShooterSpark.set(0.7);
  RightShooterSpark.set(0.7);
  }
  public void AutoShootBallOff(){
   // LeftShooterSpark.set(0);
    RightShooterSpark.set(0);
  }

  


}