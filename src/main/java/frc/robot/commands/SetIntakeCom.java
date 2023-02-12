
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSub;

public class SetIntakeCom extends CommandBase {
  private final IntakeSub m_subsystem;
  private final double speed;

  public SetIntakeCom(IntakeSub subsystem, double speed) {
    this.m_subsystem = subsystem;
    this.speed = speed;
    addRequirements(subsystem);

   
  }

 
  @Override
  public void initialize() {}


  @Override
  public void execute() {
    m_subsystem.setIntakeSpeed(speed);
  }

  
  @Override
  public void end(boolean interrupted) 
  {
    m_subsystem.setIntakeSpeed(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
