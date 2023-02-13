package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSub extends SubsystemBase {

  private CANSparkMax highLeftMotor = new CANSparkMax(Constants.highLeftMotorCh, MotorType.kBrushless);
  private CANSparkMax highRightMotor = new CANSparkMax(Constants.highRightMotorCh, MotorType.kBrushless);
  private CANSparkMax lowLeftMotor = new CANSparkMax(Constants.lowLeftMotorCh, MotorType.kBrushless);
  private CANSparkMax lowRightMotor = new CANSparkMax(Constants.lowRightMotorCh, MotorType.kBrushless);

  private RelativeEncoder leftEncoder = highLeftMotor.getEncoder();
  private RelativeEncoder rightEncoder = highRightMotor.getEncoder();

  private MotorControllerGroup leftSide = new MotorControllerGroup(highLeftMotor, lowLeftMotor);
  private MotorControllerGroup rightSide = new MotorControllerGroup(highRightMotor, lowRightMotor);

  private DifferentialDrive driveTrain = new DifferentialDrive(leftSide, rightSide);

  private AHRS navX = new AHRS(SPI.Port.kMXP);


  

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drive Left Encoder Value: ", leftEncoder.getPosition());
    SmartDashboard.putNumber("Drive Right Encoder Value: ", rightEncoder.getPosition());
    SmartDashboard.putNumber("Gyro Heading: ", navX.getAngle());
    SmartDashboard.putNumber("Gyro Pitch: ", navX.getPitch());
  }

  

  public void driveTrainDrive (double turn, double drive) {
    driveTrain.arcadeDrive(turn, drive);
  }

  public double getNavX() {
    return navX.getPitch();
  }




}
