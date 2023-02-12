package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSub extends SubsystemBase {

  private CANSparkMax mainMotor = new CANSparkMax(Constants.mainMotorChannel, MotorType.kBrushless);
  private AHRS navX = new AHRS(SPI.Port.kMXP);

  public DriveTrainSub() {}





  @Override
  public void periodic() {
  }


}
