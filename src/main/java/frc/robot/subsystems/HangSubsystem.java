package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorPort;
import frc.robot.Constants.MotorSpeed;
import frc.robot.components.SparkMax;

public class HangSubsystem extends SubsystemBase {
    private final SparkMax motor;

    public HangSubsystem() {
        motor = new SparkMax(MotorPort.kHang);
    }

    public void up() {
        motor.set(MotorSpeed.hang);
    }

    public void down() {
        motor.set(MotorSpeed.hang.rev);
    }
    
    public void stop() {
        motor.stopMotor();
    }
    
}
