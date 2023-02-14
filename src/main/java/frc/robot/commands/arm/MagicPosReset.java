// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystems.MagicMotion;

public class MagicPosReset extends CommandBase {
  private MagicMotion motor;

  public MagicPosReset(MagicMotion moto) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.motor = moto;

    addRequirements(moto);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motor.resetPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
