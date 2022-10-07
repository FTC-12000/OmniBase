package org.firstinspires.ftc.teamcode.omnibase.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OmniBot {
    private final DcMotor frontRightDrive;
    private final DcMotor frontLeftDrive;
    private final DcMotor backRightDrive;
    private final DcMotor backLeftDrive;

    public OmniBot(HardwareMap hardwareMap) {
        this(
                hardwareMap.get(DcMotor.class, "front_right_drive"),
                hardwareMap.get(DcMotor.class, "front_left_drive"),
                hardwareMap.get(DcMotor.class, "back_right_drive"),
                hardwareMap.get(DcMotor.class, "back_left_drive")
        );
    }

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

    public void setFrontRightDrivePower(double power) {
        frontRightDrive.setPower(power);
    }
    public void setFrontLeftDrivePower(double power) {
        frontLeftDrive.setPower(power);
    }
    public void setBackRightDrivePower(double power) {
        backRightDrive.setPower(power);
    }
    public void setBackLeftDrivePower(double power) {
        backLeftDrive.setPower(power);
    }
}
