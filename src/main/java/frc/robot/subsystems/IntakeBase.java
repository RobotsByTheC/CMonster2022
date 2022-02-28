// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotContainer; 
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class IntakeBase extends SubsystemBase {
  public boolean intakeToggle = false;

  public static CANSparkMax IntakeMotor = RobotContainer.intakeMotor;   
  public static DoubleSolenoid IntakeSolenoid = RobotContainer.intakeSolenoid;
  /** Creates a new IntakeBase. */

  public IntakeBase() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeStart(){
    IntakeMotor.set(-0.75);
  }
  public void intakeStop(){
    IntakeMotor.set(0);
  }

  public void intakeSolenoidToggle(){
    if (intakeToggle)
    {
    IntakeSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    else
    {
    IntakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
