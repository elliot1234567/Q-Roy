package frc.robot.Autos;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoCommands.AngleCorrect;
import frc.robot.commands.AutoCommands.AutoIndex;
import frc.robot.commands.AutoCommands.AutoLower;
import frc.robot.commands.AutoCommands.DriveDistance;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Lifter;

public class TwoBall extends SequentialCommandGroup {
    DriveTrain driveTrain = new DriveTrain();
    Indexer indexer = new Indexer();
    Lifter lifter = new Lifter();

    public TwoBall() {
        addCommands(new AutoLower(lifter, 3));
        addCommands(new DriveDistance(driveTrain, Units.inchesToMeters(56)).alongWith(new RunCommand(() -> indexer.intake(), indexer)));
        addCommands(new InstantCommand(() -> indexer.off()));
        addCommands(new AngleCorrect(driveTrain, 135));
        addCommands(new DriveDistance(driveTrain, Units.inchesToMeters(100)).alongWith(new RunCommand(() -> lifter.lift(), lifter)));
        addCommands(new InstantCommand(() -> lifter.off()));
        addCommands(new AngleCorrect(driveTrain, 90));
        addCommands(new DriveDistance(driveTrain, Units.inchesToMeters(60)));
        addCommands(new AutoIndex(indexer, 3));
    }
}
