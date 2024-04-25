package frc.robot;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  private CANSparkMax turnMotor;
  private CANSparkMax driveMotor;
  
  private AnalogInput turnPot;
  private AnalogInput drivePot;
  
  public static final double TURN_SPEED = 0.1;
  public static final double DRIVE_SPEED = 0.1;
  
  @Override
  public void robotInit() {
    try {Thread.sleep(1000);} catch (Exception e) {}

    this.turnMotor = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);
    this.driveMotor = new CANSparkMax(2, CANSparkMax.MotorType.kBrushless);
    
    this.turnPot = new AnalogInput(0);
    this.drivePot = new AnalogInput(1);

    this.turnMotor.setInverted(true);
    this.driveMotor.setInverted(true);
  }

  @Override
  public void robotPeriodic() {
    double turnValue = this.turnPot.getVoltage() / RobotController.getVoltage5V();
    double driveValue = this.drivePot.getVoltage() / RobotController.getVoltage5V();

    this.turnMotor.set(turnValue * TURN_SPEED);
    this.driveMotor.set(driveValue * DRIVE_SPEED);
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
