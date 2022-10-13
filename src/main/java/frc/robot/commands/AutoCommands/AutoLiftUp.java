package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lifter;

public class AutoLiftUp extends CommandBase {
    Lifter lifter;
    boolean finished;
    
    public AutoLiftUp(Lifter l) {
        lifter = l;

        addRequirements(lifter);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        finished = lifter.lift();
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}