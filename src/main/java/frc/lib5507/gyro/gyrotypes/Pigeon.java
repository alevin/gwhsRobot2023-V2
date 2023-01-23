package frc.lib5507.gyro.gyrotypes;
import com.ctre.phoenix.sensors.WPI_Pigeon2;

import frc.lib5507.gyro.GyroBase;

public class Pigeon implements GyroBase{
    WPI_Pigeon2 m_gyro;
    public Pigeon(int port, String can_bus){
        m_gyro = new WPI_Pigeon2(port,can_bus);
    }
    public void test(){
        
    }
    public double getGyroRate(){
        return m_gyro.getRate();
    }
    public double getGyroAngle(){
        return m_gyro.getAngle();
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
    
}
