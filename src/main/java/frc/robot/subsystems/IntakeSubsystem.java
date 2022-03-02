package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorSpeed;
import frc.robot.components.Falcon;

import static frc.robot.Constants.MotorPort.*;

public class IntakeSubsystem extends SubsystemBase{
    
    private final Falcon motor;
    private final ArmSubsystem arm;

    public IntakeSubsystem(ArmSubsystem arm){
        this.arm = arm;
        motor = new Falcon(kIntake);
    }

    public void set(double in, double out){
        if(in > 0.5)
            motor.set(MotorSpeed.intake);
        else if(out > 0.5) 
            motor.set(MotorSpeed.intakeRev);
        else
            motor.stopMotor();
    }

    public void up(){
        arm.set(Value.kReverse);
    }

    public void down(){
        arm.set(Value.kForward);
    }

    public void idle(){
        arm.set(Value.kOff);
    }
}
