package frc.robot.autocommands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveBase;

public class Run extends CommandBase{

    private double input;

    public Run(){
        input = 1.0;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        RobotContainer.rightFrontTalon.set(ControlMode.PercentOutput, input++);
        RobotContainer.rightBackVictor.set(ControlMode.PercentOutput, input++);

        RobotContainer.leftFrontTalon.set(ControlMode.PercentOutput, -1.0);
        RobotContainer.leftBackVictor.set(ControlMode.PercentOutput, -1.0);


    }

    public void end(boolean interrupted) {
      //  if(input == 1.5){
            RobotContainer.rightFrontTalon.set(0);
            RobotContainer.rightBackVictor.set(0);
    
            RobotContainer.leftFrontTalon.set(0);
            RobotContainer.leftBackVictor.set(0);

       // }
      }
    
}
