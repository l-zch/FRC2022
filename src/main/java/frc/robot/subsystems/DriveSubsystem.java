package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import java.lang.Math;
import static frc.robot.Constants.SolenoidPort.*;

import frc.robot.components.SparkMax;

import static frc.robot.Constants.MotorPort.*;

public class DriveSubsystem extends SubsystemBase {

  private final DifferentialDrive drive;
  private final MotorController leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor;
  private final DoubleSolenoid solenoid;
  private boolean speedDown = false;

  public DriveSubsystem() {
    leftFrontMotor  = new SparkMax(kDriveLeftFront);
    leftRearMotor   = new SparkMax(kDriveLeftRear);
    rightFrontMotor = new SparkMax(kDriveRightFront);
    rightRearMotor  = new SparkMax(kDriveRightRear);
    solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, kAntiFallForward.value, kAntiFallReverse.value);
    // leftEncoder  = new Encoder(MotorPort.kLeftFront);
    // rightEncoder = new Encoder(MotorPort.kRightFront);

    drive = new DifferentialDrive(
      new MotorControllerGroup(leftFrontMotor, leftRearMotor),
      new MotorControllerGroup(rightFrontMotor, rightRearMotor)
    );

    // odometry = new DifferentialDriveOdometry(gyro.getRotation2d());
    initialize();
  }
  
  private void initialize(){
    // gyro.reset();
    drive.setMaxOutput(0.5);
    drive.setDeadband(0.05);
    solenoid.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // var pose = odometry.update(gyro.getRotation2d(), leftEncoder.getPosition(), rightEncoder.getPosition());
  }

  public double convertSpeed(double x) {
    return (Math.pow(10, x) - Math.pow(9, x));
  }
  
  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(-leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double xSpeed, double zRotation){
    drive.arcadeDrive(xSpeed, zRotation);
  }

  public void antiFall(){
    solenoid.toggle();
  }
  
  public void speedChange(){
    if (speedDown){
      drive.setMaxOutput(0.5);
      speedDown = false;
    }
    else{
      drive.setMaxOutput(0.1);
      speedDown = true;
    }
  }
}
