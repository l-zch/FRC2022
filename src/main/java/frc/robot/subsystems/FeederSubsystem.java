package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.components.SparkMax;

import static frc.robot.Constants.MotorSpeed;
import static frc.robot.Constants.MotorPort.*;

public class FeederSubsystem extends SubsystemBase {
    private final SparkMax feederMotor;

    public FeederSubsystem() {
        feederMotor = new SparkMax(kFeed);
    }

    public void stop() {
        feederMotor.stopMotor();
    }

    public void in() {
        feederMotor.set(MotorSpeed.feeder);
    }

    public void out() {
        feederMotor.set(MotorSpeed.feederRev);
    }

    
}
