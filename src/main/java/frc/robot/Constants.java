
package frc.robot;


public final class Constants {

    // Drive Train Constants////////////////////////
    public static int lowLeftMotorCh = 1;
    public static int lowRightMotorCh = 2;
    public static int highLeftMotorCh = 3;
    public static int highRightMotorCh = 4;

    public static int shiftSolenoidCh = 0;

    public static double drivekP = 0.01;
    public static double drivekI = 0.00;
    public static double drivekD = 0.00;
    public static int balanceSetpoint;

    // Elevator Contants ///////////////////////////
    public static int eleTiltMotorCh = 5;
    public static int eleLiftMotorCh = 6;

    public static double liftkP = 0.00;
    public static double liftkI = 0.00;
    public static double liftkD = 0.00;
    public static int liftTopSetpoint = 100;
    public static int liftBottomSetpoint = 0;

    public static double tiltkP = 0.00;
    public static double tiltkI = 0.00;
    public static double tiltkD = 0.00;
    public static int tiltInSetpoint = 0;
    public static int tiltOutSetpoint = 100;

    // Intake Contants /////////////////////////////
    public static int leftIntakeMotorCh = 7;
    public static int rightIntakeMotorCh = 8;

    //OI Contants //////////////////////////////////
    public static int driveStickCh = 0;
    
    public static int shiftBtn = 1;
    public static int balanceBtn = 2;

    public static int intakeStickCh = 1;

    public static int intakeInBtn = 1;
    public static int intakeOutBtn = 2;

    public static int elevatorUpBtn = 3;
    public static int elevatorDownBtn = 4;

    public static int tiltInBtn = 5;
    public static int tiltOutBtn = 6;
  }

