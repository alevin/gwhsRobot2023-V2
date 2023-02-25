// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm;

import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystems.BoreEncoder;
import frc.robot.subsystems.ArmSubsystems.Claw;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClawOpenClose extends CommandBase {

  private Claw claw;
  private double angle;
  private int amps;

  public ClawOpenClose(double angle, int amps, Claw claw) {
    this.claw = claw;
    this.angle = angle;
    this.amps = amps;
    addRequirements(claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    claw.setLimit(amps);
    claw.setPosition(angle);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    claw.brake();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
