// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// // import frc.robot.Constants.AutoConstants;
// import frc.robot.subsystems.DriveSubsystem;
// import frc.robot.subsystems.ShooterSubsystem;
// import edu.wpi.first.wpilibj2.command.InstantCommand;
// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// /** A complex auto command that drives forward, drives backward, and then shoot the ball. */
// public class ComplexAutoCommand extends SequentialCommandGroup {
//   /**
//    * Creates a new ComplexAutoCommand.
//    *
//    * @param driveSubsystem The drive subsystem this command will run on
//    * @param shooterSubsystem The hatch subsystem this command will run on
//    */

//   public ComplexAutoCommand(DriveSubsystem driveSubsystem, ShooterSubsystem shooterSubsystem, FeederSubsystem feeder) {
//     addCommands(
//         // Drive forward up to the front of the cargo ship
        
//         new InstantCommand(shooterSubsystem::shoot, shooter));
//         new InstantCommand(driveSubsystem::autoDriveForward, driveSubsystem).withTimeout(3),
//         // Drive backward the specified distance
//         // Shoot the ball
        
//         new InstantCommand(feederSubsystem::in, shooterSubsystem));
//   }

//   // @Override
//   // public void execute() {
//   //   ComplexAutoCommand(driveTrain, shooter);
//   // }
// }
