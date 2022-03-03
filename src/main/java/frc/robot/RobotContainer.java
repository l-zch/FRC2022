// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.XboxController.Button;
import frc.robot.Constants.*;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveTrain = new DriveSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final FeederSubsystem feeder = new FeederSubsystem();
  private final ArmSubsystem arm = new ArmSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem(arm);
  private final XboxController xboxController = new XboxController(OIConstants.kXboxControllerPort);

  private Command autoCommand;
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveTrain.setDefaultCommand(
      new RunCommand(() ->
        driveTrain.arcadeDrive(-xboxController.getRightY(), xboxController.getRightX())
      , driveTrain
    ));
  
    intake.setDefaultCommand(
      new RunCommand(() ->
        intake.set(xboxController.getRightTriggerAxis(), xboxController.getLeftTriggerAxis())
      , intake
    ));
  }
  
  private void configureButtonBindings() {
    // Arm
    new POVButton(xboxController, 0)
    .whenPressed(
      () -> intake.up()
    );

    new POVButton(xboxController, 180)
    .whileHeld(
      new StartEndCommand(
        intake::down,
        intake::idle,
        intake
    ));


    // Feeder
    new JoystickButton(xboxController, Button.kRightBumper.value)
    .whileHeld(
      new StartEndCommand(
        feeder::in,
        feeder::stop,
        feeder
    ));

    new JoystickButton(xboxController, Button.kLeftBumper.value)
    .whileHeld(
      new StartEndCommand(
        feeder::out,
        feeder::stop,
        feeder
    ));


    // Shooter
    new JoystickButton(xboxController, Button.kY.value)
    .toggleWhenPressed(
      new StartEndCommand(
        shooter::shoot,
        shooter::stop,
        shooter
    ));


    // DriveTrain
    new JoystickButton(xboxController, Button.kX.value)
    .whenPressed(
      () -> driveTrain.antiFall()
    );

    new JoystickButton(xboxController, Button.kLeftStick.value)
    .whenPressed(
      () -> driveTrain.speedChange()
    );

    new POVButton(xboxController, 90)
    .whenPressed(
      () -> driveTrain.autoAim(true)
    )
    .whenReleased(
      () ->
      driveTrain.autoAim(false)
    );
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}