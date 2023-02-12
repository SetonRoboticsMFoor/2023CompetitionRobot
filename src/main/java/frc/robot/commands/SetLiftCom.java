
package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorLiftSub;


public class SetLiftCom extends PIDCommand {
 
  public SetLiftCom(ElevatorLiftSub m_ElevatorLiftSub, double setpoint) {
    super(
        
        new PIDController(Constants.liftkP, Constants.liftkI, Constants.liftkD),
        // This should return the measurement
        () -> m_ElevatorLiftSub.getElevatorEncoder(),
        // This should return the setpoint (can also be a constant)
        () -> setpoint,
        // This uses the output
        output -> {
          m_ElevatorLiftSub.setElevatorLift(setpoint);
        });
        addRequirements(m_ElevatorLiftSub);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
