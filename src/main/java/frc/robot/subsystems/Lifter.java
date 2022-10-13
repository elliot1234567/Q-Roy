package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lifter extends SubsystemBase {
    CANSparkMax lifter;

    DigitalInput topLimit = new DigitalInput(0);
    

    public Lifter() {
        lifter = new CANSparkMax(6, MotorType.kBrushless);
        lifter.setIdleMode(IdleMode.kBrake);
    }
    
    public void off() {
        lifter.set(0);
    }

    public boolean lift() {
        if (!topLimit.get()) {
            lifter.set(1);
            return false;
        }
        return true;

    }

    public void lower() {
        lifter.set(-1);
    }
}