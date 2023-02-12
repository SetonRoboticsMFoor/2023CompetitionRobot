// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorTiltSub extends SubsystemBase {
  private CANSparkMax elevatorPitchMotor = new CANSparkMax(Constants.eleTiltMotorCh, MotorType.kBrushed);
  private RelativeEncoder elevatorPitchEncoder = elevatorPitchMotor.getEncoder();
  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Elevator Pitch Encoder: ", elevatorPitchEncoder.getPosition());
  }

  public void setElevatorTilt(double elevatorSpeed) {
    elevatorPitchMotor.set(elevatorSpeed);
  }
}