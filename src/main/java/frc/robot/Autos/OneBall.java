package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoCommands.AutoDump;
import frc.robot.commands.AutoCommands.DriveDistance;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;

public class OneBall extends SequentialCommandGroup {
    Indexer indexer = new Indexer();
    DriveTrain driveTrain = new DriveTrain();
    
    public OneBall() {
        addCommands(new AutoDump(indexer, 3));
        addCommands(new DriveDistance(driveTrain, -100));
    }
}
