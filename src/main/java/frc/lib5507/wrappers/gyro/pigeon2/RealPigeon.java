package frc.lib5507.wrappers.gyro.pigeon2;

import static frc.robot.Constants.DrivetrainConstants.CANIVORE_NAME;
import static frc.robot.Constants.DrivetrainConstants.PIGEON_ID;

import com.ctre.phoenix.sensors.WPI_Pigeon2;
import edu.wpi.first.math.util.Units;
import frc.lib5507.wrappers.gyro.AbstractGyro;

public class RealPigeon extends AbstractGyro {

  private final WPI_Pigeon2 pigeon = new WPI_Pigeon2(PIGEON_ID, CANIVORE_NAME);

  public RealPigeon() {
    this.calibrate();
  }

  @Override
  public void reset() {
    pigeon.reset();
  }

  @Override
  public void calibrate() {
    System.out.println("======================================================");
    System.out.println("== GYRO: CALIBRATION IN PROCESS, DO NOT MOVE ROBOT...");
    pigeon.calibrate();
    System.out.println("== ... Complete!");
    System.out.println("======================================================");
  }

  @Override
  public double getRate() {
    return Units.degreesToRadians(pigeon.getRate());
  }

  @Override
  public double getRawAngle() {
    return Units.degreesToRadians(pigeon.getAngle());
  }

  @Override
  public boolean isConnected() {
    return true;
  }

  @Override
  public void setYaw(double angleDeg) {
    pigeon.setYaw(angleDeg);
  }
}
