
package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorLiftSub;


public class SetLiftCom extends PIDCommand {
 
  public SetLiftCom(ElevatorLiftSub m_ElevatorLiftSub, double setpoint) {
    super(
        
        new PIDController(Constants.liftkP, Constants.liftkI, Constants.liftkD),
       
        () -> m_ElevatorLiftSub.getElevatorLiftEncoder(),
        () -> setpoint,
        output -> {
          m_ElevatorLiftSub.setElevatorLift(output);
        });
        addRequirements(m_ElevatorLiftSub);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
