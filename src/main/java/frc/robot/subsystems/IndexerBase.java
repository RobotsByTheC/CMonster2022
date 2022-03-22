// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.revrobotics.CANSparkMax;

public class IndexerBase extends SubsystemBase {

  public static CANSparkMax IndexLower = RobotContainer.indexLower; 
  public static CANSparkMax IndexUpper = RobotContainer.indexUpper; 


  /** Creates a new IndexerBase. */
  public IndexerBase() {}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void startIndexLower()
  {
    IndexLower.set(-1);
  }

  public void stopIndexLower()
  {
    IndexLower.set(0);
  }

  
  public void startIndexUpper()
  {
      IndexUpper.set(1);
  }
  public void startIndexUpperDown()
  {
    IndexUpper.set(-1);
  }


  public void stopIndexUpper()
  {
      IndexUpper.set(0);
  }

  public void AutoStartIndexer()
  {
    IndexUpper.set(1);
    IndexLower.set(-1);
  }
  public void AutoStopIndexer()
  {
    IndexUpper.set(0);
    IndexLower.set(0);
  }
  public void AutoStartLowerIndexer()
  {
    IndexLower.set(-1);
  }
  public void AutoStopLowerIndexer()
  {
    IndexLower.set(0);
  }
}
