// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public enum MotorPort {
    // DriveTrain
    kDriveLeftFront  (34),
    kDriveLeftRear   (33),
    kDriveRightFront (36),
    kDriveRightRear  (31),

    // Intake
    kIntake (26),

    // Shooter
    kFeed   (39),
    kShoot1 (41),
    kShoot2 (35),

    // Hang
    kHang (40);

    public final int value;
    MotorPort(int value) {
      this.value = value;
    }
  }

  public enum SolenoidPort {
    kLeftForward  (0),
    kLeftReverse  (1),
    kRightForward (4),
    kRightReverse (5),
    kAntiFallForward (2),
    kAntiFallReverse (3),
    kClose1 (6),
    kClose2 (7);
  
    public final int value;
    SolenoidPort(int value) {
      this.value = value;
    }
  }
  
  public static final class OIConstants {
    public static final int kXboxControllerPort = 0;
  }

  public enum MotorSpeed {
    shooter   (0.6),

    feeder    (-0.5),
    feederRev (0.2),

    intake    (0.5),
    intakeRev (-0.5),

    hang      (-0.9),

    driveSpeed (0.6);

    public final double value, rev;
    MotorSpeed(double value) {
      this.value = value;
      rev = -value;
    }
  }
}
