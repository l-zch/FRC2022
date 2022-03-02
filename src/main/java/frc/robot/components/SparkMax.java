package frc.robot.components;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants.MotorPort;
import frc.robot.Constants.MotorSpeed;

public class SparkMax implements MotorController{
    CANSparkMax speedController;

    public SparkMax(MotorPort port) {
        speedController = new CANSparkMax(port.value, MotorType.kBrushless);
        speedController.restoreFactoryDefaults();
    }

    public void set(double speed) {
        speedController.set(speed);
    }

    public void set(MotorSpeed speedConst) {
        speedController.set(speedConst.value);
    }

    public void setInverted(boolean invert) {
        speedController.setInverted(invert);
    }

    public double get() {
        return 0;
    }

    public void disable() {
        speedController.disable();

    }
    
    public boolean getInverted() {
        return speedController.getInverted();
    }

    public void stopMotor() {
        speedController.stopMotor();
    }

}
