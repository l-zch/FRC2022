package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.components.SparkMax;

import static frc.robot.Constants.MotorSpeed;
import static frc.robot.Constants.MotorPort.*;

public class ShooterSubsystem extends SubsystemBase {
    private final SparkMax shootMotor1, shootMotor2;

    public ShooterSubsystem() {
        shootMotor1 = new SparkMax(kShoot1);
        shootMotor2 = new SparkMax(kShoot2);
    }

    public void shoot() {
        try{
            shootMotor2.set(MotorSpeed.shooter);
            shootMotor1.set(MotorSpeed.shooter.rev);
        } catch(NullPointerException e){
            System.out.println(e);
        }
    }

    public void stop() {
        try{
            shootMotor2.stopMotor();
            shootMotor1.stopMotor();
        } catch(NullPointerException e){
            System.out.println(e);
        }
    }
}
