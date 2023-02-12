
package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorTiltSub;


public class SetTiltCom extends PIDCommand {

  public SetTiltCom(ElevatorTiltSub m_ElevatorTiltSub, double setpoint) {
    super(
        
        new PIDController(Constants.tiltkP, Constants.tiltkI, Constants.tiltkD),
       
        () -> m_ElevatorTiltSub.getElevatorTiltEncoder(),
        () -> setpoint,
        output -> {
          m_ElevatorTiltSub.setElevatorTilt(output);
        });
        addRequirements(m_ElevatorTiltSub);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
