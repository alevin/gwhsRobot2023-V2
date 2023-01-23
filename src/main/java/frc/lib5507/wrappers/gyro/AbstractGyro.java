package frc.lib5507.wrappers.gyro;

public abstract class AbstractGyro {

  public abstract void reset();

  public abstract void calibrate();

  public abstract double getRate();

  public abstract double getRawAngle();

  public abstract boolean isConnected();

  public abstract void setYaw(double angleDeg);
}

/**
 * pigeon.configMountPoseRoll(0); pigeon.configMountPoseYaw(0); return pigeon.getRotation2d(); // We
 * have to invert the angle of the NavX so that rotating the robot counter-clockwise makes // the
 * angle increase. // return Rotation2d.fromDegrees(360.0 - navx.getYaw());
 *
 * <p>public void setGyroscopeRotation(double angleDeg) { pigeon.setYaw(angleDeg);
 *
 * <p>public void resetGyro() { setGyroscopeRotation(0);
 */
