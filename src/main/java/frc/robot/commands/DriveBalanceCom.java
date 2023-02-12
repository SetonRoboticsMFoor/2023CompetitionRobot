// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSub;

public class DriveBalanceCom extends CommandBase {
  private final DriveTrainSub m_DriveTrainSub;
  private final PIDController m_PidController;

  public DriveBalanceCom(DriveTrainSub m_DriveTrainSub, double setPoint) {
    this.m_DriveTrainSub = m_DriveTrainSub;
    this.m_PidController = new PIDController(Constants.drivekP, Constants.drivekI, Constants.drivekD);
    m_PidController.setSetpoint(setPoint);
    addRequirements(m_DriveTrainSub);

  }

  @Override
  public void initialize() {
    m_PidController.reset();
  }


  @Override
  public void execute() {
    double speed = m_PidController.calculate(m_DriveTrainSub.getNavX());
    m_DriveTrainSub.driveTrainDrive(0, speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_DriveTrainSub.driveTrainDrive(0, 0);
  }

 
  @Override
  public boolean isFinished() {
    return false;
  }
}
