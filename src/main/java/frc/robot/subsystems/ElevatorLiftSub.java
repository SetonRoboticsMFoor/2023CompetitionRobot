
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorLiftSub extends SubsystemBase {
  private CANSparkMax elevatorLiftMotor = new CANSparkMax(Constants.eleLiftMotorCh, MotorType.kBrushless);
  private RelativeEncoder elevatorLiftEncoder = elevatorLiftMotor.getEncoder();
  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Elevator Pitch Encoder: ", elevatorLiftEncoder.getPosition());
  }

  public void setElevatorLift(double elevatorLiftSpeed) {
    elevatorLiftMotor.set(elevatorLiftSpeed);
  }

  public double getElevatorLiftEncoder() {
    return elevatorLiftEncoder.getPosition();
  }
}
