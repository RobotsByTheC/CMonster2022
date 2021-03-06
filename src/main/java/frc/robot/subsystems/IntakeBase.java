// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotContainer; 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsBase;
import edu.wpi.first.wpilibj.*;


public class IntakeBase extends SubsystemBase {
  public boolean intakeToggle = false;

  public static WPI_TalonSRX IntakeMotor = RobotContainer.intakeMotor;   
  public static DoubleSolenoid IntakeSolenoid = RobotContainer.intakeSolenoid;
  /** Creates a new IntakeBase. */

  public IntakeBase() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeStart(){
    IntakeMotor.set(1);
  }

  public void intakeReverse(){
    IntakeMotor.set(-1);
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

  
  //Auto code for intake
  public void intakeToggleAuto(){
    if (intakeToggle)
    {
    IntakeSolenoid.set(DoubleSolenoid.Value.kForward);
    intakeToggle = !intakeToggle;
    }
    else
    {
    IntakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    intakeToggle = !intakeToggle;
    }
  }


  public void intakeStartAuto()
  {
    IntakeMotor.set(1);
  }
  public void intakeStopAuto()
  {
    IntakeMotor.set(0);
  }
}
