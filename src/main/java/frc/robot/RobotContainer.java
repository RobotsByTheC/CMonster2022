// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*; 
import frc.robot.subsystems.*; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


//imports the pheonix products 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


//Spark max imports (to import, install vendor library online and put this link in https://software-metadata.revrobotics.com/REVLib.json)
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//Pneumatic imports
/**import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;**/




/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  //declares driving motors
  public static WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(1);
  public static WPI_VictorSPX leftBackVictor = new WPI_VictorSPX(3);
  public static WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(2); 
  public static WPI_VictorSPX rightBackVictor = new WPI_VictorSPX(4);

 //declares system motors
 public static WPI_TalonSRX intakeTalon = new WPI_TalonSRX(5);

 //declares spark max
 public static CANSparkMax leftShooterSpark = new CANSparkMax(6, MotorType.kBrushless);
 public static CANSparkMax rightShooterSpark = new CANSparkMax(7, MotorType.kBrushless);

 public static CANSparkMax leftClimberSpark = new CANSparkMax(8,MotorType.kBrushless);
 public static CANSparkMax rightClimberSpark = new CANSparkMax(9,MotorType.kBrushless);

//Compressors
 //public static Compressor robotCompressor;

 //Solenoids
 //public static DoubleSolenoid intakeSolenoid = new DoubleSolenoid();



 public static DriveBase driveBase; 
 public static DriveWithJoystick driveWithJoystick;
 public static ShooterBase shooterBase; 
 public static IntakeBase intakeBase; 
 public static ClimberBase climberBase; 
 
 //declares joystickis
 public static Joystick leftJoystick;
 public static Joystick rightJoystick;
 public static Joystick logitech;
 
 //declare joystick button
 public static JoystickButton switchButton; 
 public static JoystickButton shootButton; 
 public static JoystickButton intakeButton; 
 public static JoystickButton climberButton; 
 
   /** The container for the robot. Contains subsystems, OI devices, and commands. */
   public RobotContainer() {
 
     leftJoystick = new Joystick (0);
     rightJoystick = new Joystick (1);
     logitech = new Joystick (2); 
 
     switchButton = new JoystickButton(leftJoystick,1);
     shootButton = new JoystickButton(logitech, 4);
     intakeButton = new JoystickButton(logitech, 1);
     climberButton = new JoystickButton(logitech, 3);
 
 
 
     driveBase = new DriveBase();
     driveWithJoystick = new DriveWithJoystick();
     CommandScheduler.getInstance().setDefaultCommand(driveBase, driveWithJoystick);
 
     shooterBase = new ShooterBase();
     intakeBase = new IntakeBase();
     climberBase = new ClimberBase(); 
 
 // decalres functions of buttons
    switchButton.whenPressed(new Inversion());
    
     shootButton.whileHeld(new ShootBall());
     shootButton.whenReleased(new StopBall());

     intakeButton.whileHeld(new IntakeStart());
     intakeButton.whenReleased(new IntakeStop());

     climberButton.whileHeld(new ClimberStart());
     climberButton.whenReleased(new ClimberStop());
 
 
 
     // Configure the button bindings
     configureButtonBindings();
   }
 
   /**
    * Use this method to define your button->command mappings. Buttons can be created by
    * instantiating a {@link GenericHID} or one of its subclasses ({@link
    * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
    * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
    */
   private void configureButtonBindings() {}
 
   /**
    * Use this to pass the autonomous command to the main {@link Robot} class.
    *
    * @return the command to run in autonomous
    */
   public Command getAutonomousCommand() {
     // An ExampleCommand will run in autonomous
     return m_autoCommand;
   }
 
   public static Joystick getRightJoystick(){
     return rightJoystick;
   }
 
   public static Joystick getLeftJoystick(){
     return leftJoystick;
   }

   public static Joystick getLogitech(){
     return logitech; 
   }

   public static JoystickButton getSwitchButton(){
    return switchButton; 
  }
 
 }

 