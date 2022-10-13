package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lifter;

public class Lift extends CommandBase {

    public Lifter indexer;
    public BooleanSupplier aButton;
    public BooleanSupplier bButton;
    public boolean finished;

    public Lift(Lifter i, BooleanSupplier a, BooleanSupplier b) {
        indexer = i;
        aButton = a;
        bButton = b;

        addRequirements(indexer);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if (aButton.getAsBoolean()) {
            indexer.lift();
        } else if (bButton.getAsBoolean()) {
            indexer.lower();
        } else {
            indexer.off();
        }
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return finished;
    }

}
