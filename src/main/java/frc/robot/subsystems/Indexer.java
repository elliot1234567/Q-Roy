package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
    CANSparkMax indexer;
    
    public Indexer() {
        indexer = new CANSparkMax(5, MotorType.kBrushless);

        indexer.setIdleMode(IdleMode.kBrake);

    }

    public void intake() {
        indexer.set(1);
    }

    public void exhaust() {
        indexer.set(-1);
    }
    
    public void off() {
        indexer.set(0);
    }
}