package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import static frc.robot.Constants.SolenoidPort.*;

import frc.robot.components.SparkMax;

import static frc.robot.Constants.MotorPort.*;

public class DriveSubsystem extends SubsystemBase {

  private final DifferentialDrive drive;
  private final MotorController leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor;
  private final DoubleSolenoid solenoid;
  private boolean speedDown = false, limeLightMode = false;

  public DriveSubsystem() {
    leftFrontMotor  = new SparkMax(kDriveLeftFront);
    leftRearMotor   = new SparkMax(kDriveLeftRear);
    rightFrontMotor = new SparkMax(kDriveRightFront);
    rightRearMotor  = new SparkMax(kDriveRightRear);
    solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, kAntiFallForward.value, kAntiFallReverse.value);

    drive = new DifferentialDrive(
      new MotorControllerGroup(leftFrontMotor, leftRearMotor),
      new MotorControllerGroup(rightFrontMotor, rightRearMotor)
    );

    initialize();
  }
  
  private void initialize() {
    drive.setMaxOutput(0.5);
    drive.setDeadband(0.05);
    solenoid.set(Value.kForward);
  }
  
  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(-leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    if(limeLightMode){
      if(xSpeed == 0) drive.tankDrive(getRotation(), -getRotation());
      else drive.arcadeDrive(getRotation(), xSpeed);
    }
    else
      drive.arcadeDrive(zRotation, xSpeed);
  }

  public void antiFall() {
    solenoid.toggle();
  }
  
  public void speedChange() {
    if (speedDown){
      drive.setMaxOutput(0.5);
      speedDown = false;
    }
    else{
      drive.setMaxOutput(0.25);
      speedDown = true;
    }
  }

  public void autoAim(boolean b) {
    limeLightMode = b;
  }

  private double getRotation() {
    final double STEER_K = 0.04;
    double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);

    if (tv < 1.0) return 0.0;
    return tx * STEER_K;
  }
}
