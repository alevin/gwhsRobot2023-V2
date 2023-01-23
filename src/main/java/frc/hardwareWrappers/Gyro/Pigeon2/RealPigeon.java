package frc.hardwareWrappers.Gyro.Pigeon2;

// import com.kauailabs.navx.frc.AHRS;
import static frc.robot.Constants.DrivetrainConstants.CANIVORE_NAME;
import static frc.robot.Constants.DrivetrainConstants.PIGEON_ID;

import com.ctre.phoenix.sensors.WPI_Pigeon2;
import edu.wpi.first.math.util.Units;
// import edu.wpi.first.wpilibj.SPI.Port;
import frc.hardwareWrappers.Gyro.AbstractGyro;

public class RealPigeon extends AbstractGyro {

  // AHRS ahrs;
  private final WPI_Pigeon2 pigeon = new WPI_Pigeon2(PIGEON_ID, CANIVORE_NAME);

  public RealPigeon() {
    // ahrs = new AHRS(Port.kMXP);
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
}
