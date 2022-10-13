// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import frc.robot.Autos.OneBall;
import frc.robot.Autos.TwoBall;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.commands.Index;
import frc.robot.commands.Lift;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Lifter;
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  DriveTrain driveTrain = new DriveTrain();
  Indexer indexer = new Indexer();
  Climber climber = new Climber();
  Lifter lifter = new Lifter();

  Drive drive;
  Index index;
  Climb climb;
  Lift lift;

  SendableChooser<CommandGroupBase> autoChooser;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    autoChooser = new SendableChooser<>();

    autoChooser.addOption("OneBall", new OneBall());
    autoChooser.addOption("TwoBall", new TwoBall());

    SmartDashboard.putData(autoChooser);



    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    XboxController controller = new XboxController(0);
    Joystick joystick = new Joystick(1);

    drive = new Drive(driveTrain, () -> controller.getRightX(), () -> controller.getLeftY());
    index = new Index(indexer, () -> joystick.getRawButton(2), () -> joystick.getRawButton(1));
    climb = new Climb(climber, () -> controller.getLeftBumper(), () -> controller.getRightBumper());
    lift = new Lift(lifter, () -> joystick.getRawButton(3), () -> joystick.getRawButton(4));

    driveTrain.setDefaultCommand(drive);
    indexer.setDefaultCommand(index);
    climber.setDefaultCommand(climb);
    lifter.setDefaultCommand(lift);
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

}