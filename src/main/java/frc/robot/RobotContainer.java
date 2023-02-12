// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveBalanceCom;
import frc.robot.commands.JoystickDriveCom;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.ElevatorLiftSub;
import frc.robot.subsystems.ElevatorTiltSub;
import frc.robot.subsystems.IntakeSub;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
 
  private final DriveTrainSub m_DriveTrainSub = new DriveTrainSub();
  private final ElevatorLiftSub m_ElevatorLiftSub = new ElevatorLiftSub();
  private final ElevatorTiltSub m_ElevatorTiltSub = new ElevatorTiltSub();
  private final IntakeSub m_IntakeSub = new IntakeSub();

  private final Joystick driveStick = new Joystick(Constants.driveStickCh);
  private final JoystickButton shiftBtn = new JoystickButton(driveStick, Constants.shiftBtn);
  private final JoystickButton balanceBtn = new JoystickButton(driveStick, Constants.balanceBtn);

  private final Joystick intakeStick = new Joystick(Constants.intakeStickCh);
  private final JoystickButton elevatorLiftUpBtn = new JoystickButton(intakeStick, Constants.elevatorUpBtn);
  private final JoystickButton elevatorLiftDownBtn = new JoystickButton(intakeStick, Constants.elevatorDownBtn);

  private final JoystickButton elevatorTiltInBtn = new JoystickButton(intakeStick, Constants.tiltInBtn);
  private final JoystickButton elevatorTiltOutBtn = new JoystickButton(intakeStick, Constants.tiltOutBtn);

 
  public RobotContainer() {
    m_DriveTrainSub.setDefaultCommand(new JoystickDriveCom(m_DriveTrainSub, () ->driveStick.getRawAxis(1), () ->driveStick.getRawAxis(2)));
    
    configureBindings();
  }


  private void configureBindings() {

    balanceBtn.toggleOnTrue(new DriveBalanceCom(m_DriveTrainSub, Constants.balanceSetpoint));
   
  }


  public Command getAutonomousCommand() {

    return null;
  }
}
