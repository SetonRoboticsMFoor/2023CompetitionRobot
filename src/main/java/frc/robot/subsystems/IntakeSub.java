
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {
  private CANSparkMax leftIntakeMotor = new CANSparkMax(Constants.leftIntakeMotorCh, MotorType.kBrushless);
  private RelativeEncoder leftIntakeMotorEncoder = leftIntakeMotor.getEncoder();

  private CANSparkMax rightIntakeMotor = new CANSparkMax(Constants.rightIntakeMotorCh, MotorType.kBrushless);
  private RelativeEncoder rightIntakeMotorEncoder = rightIntakeMotor.getEncoder();
  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Intake Encoder: ", leftIntakeMotorEncoder.getPosition());
    SmartDashboard.putNumber("Right Intake Encoder: ", rightIntakeMotorEncoder.getPosition());
  }

  public void setIntakeSpeed(double intakeSpeed) {
    leftIntakeMotor.set(intakeSpeed);
    rightIntakeMotor.set(-intakeSpeed);
  }
}
