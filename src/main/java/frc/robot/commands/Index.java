package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class Index extends CommandBase {

    public Indexer indexer;
    public BooleanSupplier aButton;
    public BooleanSupplier bButton;
    public boolean finished;

    public Index(Indexer i, BooleanSupplier a, BooleanSupplier b) {
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
            indexer.intake();
        } else if (bButton.getAsBoolean()) {
            indexer.exhaust();
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
