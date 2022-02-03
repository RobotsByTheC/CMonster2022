// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.revrobotics.CANSparkMax;

public class ClimberBase extends SubsystemBase {
  public static CANSparkMax LeftClimberSpark = RobotContainer.leftClimberSpark; 
  public static CANSparkMax RightClimberSpark = RobotContainer.rightClimberSpark; 

  /** Creates a new ClimberBase. */
  public ClimberBase() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void ClimberOn(){
    LeftClimberSpark.set(-1);
    RightClimberSpark.set(1);
  }
  public void ClimberOff(){
    LeftClimberSpark.set(0);
    RightClimberSpark.set(0);
  }

}
