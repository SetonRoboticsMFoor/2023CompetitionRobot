// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;


public class JoystickDriveCom extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainSub m_subsystem;
  private final Supplier <Double> speedFunction;
  private final Supplier <Double> turnFunction;


  public JoystickDriveCom(DriveTrainSub subsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.m_subsystem = subsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    
    addRequirements(subsystem);
  }

  
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();
    m_subsystem.driveTrainDrive(realTimeTurn, realTimeSpeed);
  }

  
  @Override
  public void end(boolean interrupted) {
    m_subsystem.driveTrainDrive(0, 0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
