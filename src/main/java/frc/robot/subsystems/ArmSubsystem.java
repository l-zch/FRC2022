package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

import static frc.robot.Constants.SolenoidPort.*;

public class ArmSubsystem extends SubsystemBase{
    private final DoubleSolenoid lSolenoid, rSolenoid;
    private Solenoid c1, c2;
    private Value value = Value.kReverse;
    public ArmSubsystem() {
        c1 = new Solenoid(PneumaticsModuleType.CTREPCM, 6);
        c1.set(false);
        c2 = new Solenoid(PneumaticsModuleType.CTREPCM, 7);
        c2.set(false);
        lSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, kLeftForward.value, kLeftReverse.value);
        rSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, kRightForward.value, kRightReverse.value);
    }

    @Override
    public void periodic(){
        lSolenoid.set(value);
        rSolenoid.set(value);
    }
    public void set(Value value){
        this.value = value;
    }
}
