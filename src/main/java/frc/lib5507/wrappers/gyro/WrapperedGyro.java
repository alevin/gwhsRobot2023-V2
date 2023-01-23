package frc.lib5507.wrappers.gyro;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.lib5507.wrappers.gyro.navx.RealNavx;
import frc.lib5507.wrappers.gyro.pigeon2.RealPigeon;

public class WrapperedGyro {

  AbstractGyro gyro;
  double offsetRad = 0;

  private double curAngleRad;

  public WrapperedGyro(String type) {
    if (type != null && type.equals("NAVX")) {
      gyro = new RealNavx();
    } else if (type != null && type.equals("PIGEON")) {
      gyro = new RealPigeon();
    } else {
      gyro = null;
    }
  }

  public void update() {
    // Gyros are inverted in reference frame (positive clockwise)
    // and we maintain our own offset in code when rezeroing.
    curAngleRad = gyro.getRawAngle() * -1.0 + offsetRad;
  }

  public void reset(double curAngleRad) {
    offsetRad = curAngleRad;
    gyro.reset();
  }

  public void calibrate() {
    gyro.calibrate();
  }

  public double getRateRadpersec() {
    return gyro.getRate();
  }

  public double getAngleRad() {
    return curAngleRad;
  }

  public boolean isConnected() {
    return gyro.isConnected();
  }

  public void setYaw(double angleDeg) {
    // new Rotation2d(this.getAngleRad());

  }

  public Rotation2d getRotation2d() {
    return new Rotation2d(this.getAngleRad());
  }
}
