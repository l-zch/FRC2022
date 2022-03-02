package frc.robot.components;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants.MotorPort;
import frc.robot.Constants.MotorSpeed;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class Falcon implements MotorController{
    TalonFX speedController;

    public Falcon(MotorPort port){
        speedController = new TalonFX(port.value);
    }

    public void set(double speed){
        speedController.set(ControlMode.PercentOutput, speed);
    }

    
    public void set(MotorSpeed speedConst) {
        speedController.set(ControlMode.PercentOutput, speedConst.value);
    }

    public void setInverted(boolean invert){
        speedController.setInverted(invert);
    }

    public double get(){
        return 0;
    }

    public void disable(){
    }
    
    public boolean getInverted(){
        return speedController.getInverted();
    }

    public void stopMotor(){
        speedController.set(ControlMode.PercentOutput, 0);
    }
}
