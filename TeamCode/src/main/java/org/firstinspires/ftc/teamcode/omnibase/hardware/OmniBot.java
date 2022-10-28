package org.firstinspires.ftc.teamcode.omnibase.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * A wrapper for an OmniBot's motors that adds support for custom motor names.
 * @author Calvin Larimore
 */
public class OmniBot {
    private final DcMotor frontRightDrive;
    private final DcMotor frontLeftDrive;
    private final DcMotor backRightDrive;
    private final DcMotor backLeftDrive;

    /**
     * Creates a new OmniBot using default motor names (formatted like "front_right_drive").
     * For custom motors see {@link OmniBot#OmniBot(DcMotor, DcMotor, DcMotor, DcMotor)} or {@link OmniBot#OmniBot(HardwareMap, String, String, String, String)}.
     * @param hardwareMap The {@link HardwareMap} to get the motors from
     */
    public OmniBot(HardwareMap hardwareMap) {
        this(
            hardwareMap.get(DcMotor.class, "front_right_drive"),
            hardwareMap.get(DcMotor.class, "front_left_drive"),
            hardwareMap.get(DcMotor.class, "back_right_drive"),
            hardwareMap.get(DcMotor.class, "back_left_drive")
        );
    }

    /**
     * Creates a new OmniBot using the motor names passed to it.
     * For default motors see {@link OmniBot#OmniBot(HardwareMap)}.
     * For passing motor objects see {@link OmniBot#OmniBot(DcMotor, DcMotor, DcMotor, DcMotor)}.
     * @param hardwareMap The {@link HardwareMap} to get the motors from.
     * @param frontRightDrive The front right drive motor name
     * @param frontLeftDrive The front left drive motor name
     * @param backRightDrive The back right drive motor name
     * @param backLeftDrive The back left drive motor name
     */
    public OmniBot(HardwareMap hardwareMap, String frontRightDrive, String frontLeftDrive, String backRightDrive, String backLeftDrive) {
        this(
            hardwareMap.get(DcMotor.class, frontRightDrive),
            hardwareMap.get(DcMotor.class, frontLeftDrive),
            hardwareMap.get(DcMotor.class, backRightDrive),
            hardwareMap.get(DcMotor.class, backLeftDrive)
        );
    }

    /**
     * Creates a new OmniBot using the motors passed to it.
     * For default motors see {@link OmniBot#OmniBot(HardwareMap)}.
     * For passing motor names see {@link OmniBot#OmniBot(HardwareMap, String, String, String, String)}.
     * @param frontRightDrive The front right drive motor
     * @param frontLeftDrive The front left drive motor
     * @param backRightDrive The back right drive motor
     * @param backLeftDrive The back left drive motor
     */
    public OmniBot(DcMotor frontRightDrive, DcMotor frontLeftDrive, DcMotor backRightDrive, DcMotor backLeftDrive) {
        this.frontRightDrive = frontRightDrive;
        this.frontLeftDrive = frontLeftDrive;
        this.backRightDrive = backRightDrive;
        this.backLeftDrive = backLeftDrive;

        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    /**
     * Sets the power of the front right drive motor
     * @param power The new power level (0-1)
     * @see OmniBot#setFrontLeftDrivePower(double)
     * @see OmniBot#setBackRightDrivePower(double)
     * @see OmniBot#setBackLeftDrivePower(double)
     */
    public void setFrontRightDrivePower(double power) {
        frontRightDrive.setPower(power);
    }

    /**
     * Sets the power of the front left drive motor
     * @param power The new power level (0-1)
     * @see OmniBot#setFrontRightDrivePower(double)
     * @see OmniBot#setBackRightDrivePower(double)
     * @see OmniBot#setBackLeftDrivePower(double)
     */
    public void setFrontLeftDrivePower(double power) {
        frontLeftDrive.setPower(power);
    }

    /**
     * Sets the power of the back right drive motor
     * @param power The new power level (0-1)
     * @see OmniBot#setFrontRightDrivePower(double) 
     * @see OmniBot#setFrontLeftDrivePower(double)
     * @see OmniBot#setBackLeftDrivePower(double)
     */
    public void setBackRightDrivePower(double power) {
        backRightDrive.setPower(power);
    }

    /**
     * Sets the power of the back left drive motor
     * @param power The new power level (0-1)
     * @see OmniBot#setFrontRightDrivePower(double)
     * @see OmniBot#setFrontLeftDrivePower(double)
     * @see OmniBot#setBackRightDrivePower(double) 
     */
    public void setBackLeftDrivePower(double power) {
        backLeftDrive.setPower(power);
    }
}
