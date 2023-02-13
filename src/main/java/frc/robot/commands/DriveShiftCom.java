package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShifterSub;

public class DriveShiftCom extends CommandBase {
  private final ShifterSub m_subsystem;


  public DriveShiftCom(ShifterSub subsystem) {
    this.m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.driveShift(true);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveShift(false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
