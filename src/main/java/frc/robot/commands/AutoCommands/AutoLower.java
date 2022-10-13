package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lifter;

public class AutoLower extends CommandBase {
    Lifter lifter;
    boolean finished;
    double seconds;

    Timer timer;
    
    public AutoLower(Lifter l, double s) {
        lifter = l;
        seconds = s;
        timer = new Timer();

        addRequirements(lifter);
    }

    @Override
    public void initialize() {
        timer.start();
        lifter.lower();
    }

    @Override
    public void execute() {
        if (timer.get() >= seconds) {
            finished = true;
        }
        lifter.lower();
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}