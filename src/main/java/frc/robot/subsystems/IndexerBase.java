// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.DigitalInput; 
import com.revrobotics.CANSparkMax;

public class IndexerBase extends SubsystemBase {

  public static CANSparkMax IndexLower = RobotContainer.indexLower; 
  public static CANSparkMax IndexUpper = RobotContainer.indexUpper; 

  public boolean loaded = false;
  public boolean shooting = false;
  /** Creates a new IndexerBase. */
  public IndexerBase() {}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void startIndexLower()
  {
    IndexLower.set(1);
  }

  public void stopIndexLower()
  {
    IndexLower.set(0);
  }

  
  public void startIndexUpper()
  {
    if (!loaded && !shooting)
    {
      IndexUpper.set(1);
      loaded = true;
    }
  }


  public void stopIndexUpper()
  {
    if (!shooting)
    {
      IndexUpper.set(0);
    }
  }

}
