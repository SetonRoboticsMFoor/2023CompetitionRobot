package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShifterSub extends SubsystemBase {

  private Solenoid shiftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.shiftSolenoidCh);

  public ShifterSub() {
  }

  public void driveShift(boolean shiftState) {
    shiftSolenoid.set(true);
  }


  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Shifter State: ", shiftSolenoid.get());

  }
}
