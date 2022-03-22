// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autocommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class shootTwoAuto extends SequentialCommandGroup {
  /** Creates a new basicAuto. */
  public shootTwoAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    

    //more commands will be added to sequence
      addCommands(new TimedMove(2), 
                  new TimedTurn(-.5), 
                  new AutoIntakeStart(), 
                  new TimedMove(2), 
                  new TimedMove(-2),
                  new AutoIntakeStop(),
                  new TimedTurn(.5),
                  new TimedMove(-2),
                  new TimedShooter(4)
                  );
  }
}
