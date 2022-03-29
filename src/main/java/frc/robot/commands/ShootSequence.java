// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class ShootSequence extends CommandBase {
  private Timer timer = RobotContainer.moveTimer;
  private double startTime;
  /** Creates a new ShootSequence. */
  public ShootSequence() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    RobotContainer.shooterBase.ShootBallOn();
    if (timer.get() >= startTime+.5)
    {
      RobotContainer.indexerBase.startIndexLower();
      RobotContainer.indexerBase.startIndexUpper();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
