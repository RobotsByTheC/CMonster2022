// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.DigitalInput; 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IndexerBase extends SubsystemBase {

  public static WPI_TalonSRX FeederUpper = RobotContainer.feederUpper; 
  public static WPI_TalonSRX FeederLower = RobotContainer.feederLower; 
  public boolean loaded = false;
  public boolean shooting = false;
  /** Creates a new IndexerBase. */
  public IndexerBase() {}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void startFeederLower()
  {
    FeederLower.set(1);
  }

  public void stopFeederLower()
  {
    FeederLower.set(0);
  }

  
  public void startFeederUpper()
  {
    if (!loaded && !shooting)
    {
      FeederUpper.set(1);
      loaded = true;
    }
  }


  public void stopFeederUpper()
  {
    if (!shooting)
    {
      FeederUpper.set(0);
    }
  }

}
