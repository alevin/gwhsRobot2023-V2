package frc.lib5507.gyro;

import org.w3c.dom.Element;


import frc.lib5507.gyro.gyrotypes.Analog_Gyro;
import frc.lib5507.gyro.gyrotypes.Pigeon;
import frc.lib5507.gyro.gyrotypes.Navx;

public class GyroWrapper implements GyroBase{
    Element m_gyroElement;
    GyroBase m_gyro;
    public GyroWrapper(Element element){
        m_gyroElement = element;
        String id = m_gyroElement.getAttribute("id");
        int port = Integer.parseInt(m_gyroElement.getAttribute("port"));
        String can_bus = m_gyroElement.getAttribute("can_bus");
        m_gyro = getGyroType(m_gyroElement.getAttribute("type"), port,can_bus);

        if (m_gyro == null) {
            System.out.println("For motor: " + id + " motor controller type: " + m_gyroElement.getAttribute("controller") + " was not found!");
            return;
        }

        
    }
    private GyroBase getGyroType(String controllerType, int port, String can_bus) {
         if(controllerType.equals("AnalogGyro")){
            return new Analog_Gyro();
        }else if(controllerType.equals("navX")){
            return new Navx();
        }else if(controllerType.equals("pigeon") || controllerType.equals("Pigeon")){
            return new Pigeon(port,can_bus);
        }else{
            return null;
        }
    }
    public double getGyroAccel(String axis){
        return m_gyro.getGyroAccel(axis);
    }
    @Override
    public double getGyroAngle(String axis) {
        if(axis != null){
            return m_gyro.getGyroAngle(axis);
        }else{
            return m_gyro.getGyroAngle();
        }
        
    }
    @Override
    public double getGyroRate(String axis) {
        if(axis != null){
            return m_gyro.getGyroRate(axis);
        }else{
            return m_gyro.getGyroRate();
        }
    }
    @Override
    public double getMagneticField(String axis) {
        return m_gyro.getMagneticField(axis);
    }
    @Override
    public double getGyroRate() {
        return m_gyro.getGyroRate();
    }
    @Override
    public double getGyroAngle() {
        return m_gyro.getGyroAngle();
    }

}
