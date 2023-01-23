package frc.lib5507.gyro.gyrotypes;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import frc.lib5507.gyro.GyroBase;

public class Navx implements GyroBase{
    AHRS m_gyro;
    public Navx(){
        m_gyro = new AHRS(SPI.Port.kMXP);
    }

    @Override
    public double getGyroAccel(String axis) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getGyroAngle(String axis) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getGyroRate(String axis) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getMagneticField(String axis) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getGyroRate() {
        return m_gyro.getRate();
    }

    @Override
    public double getGyroAngle() {
        return m_gyro.getAngle();
    }
}