package org.firstinspires.ftc.teamcode.omnibase;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.omnibase.hardware.OmniBot;

public class OmniBase extends OpMode {
    private OmniBot onniBot;

    private final ElapsedTime runtime = new ElapsedTime();

    private double axial = 0;
    private double lateral = 0;
    private double yaw = 0;

    @Override
    public void init() {
        onniBot = new OmniBot(hardwareMap);
    }

    @Override
    public void loop() {
        double max;

        double frontRightPower = axial - lateral - yaw;
        double frontLeftPower = axial + lateral + yaw;
        double backRightPower = axial + lateral - yaw;
        double backLeftPower = axial - lateral + yaw;

        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1) {
            frontRightPower /= max;
            frontLeftPower /= max;
            backRightPower /= max;
            backLeftPower /= max;
        }

        onniBot.setFrontRightDrivePower(frontRightPower);
        onniBot.setFrontLeftDrivePower(frontLeftPower);
        onniBot.setBackRightDrivePower(backRightPower);
        onniBot.setBackLeftDrivePower(backLeftPower);

        telemetry.addData("Run Time", runtime.toString());
        telemetry.addData("Front Left/Right", "%4.2f, %4.2f", frontLeftPower, frontRightPower);
        telemetry.addData("Back  Left/Right", "%4.2f, %4.2f", backLeftPower, backRightPower);
        telemetry.update();
    }

    public void setAxialSpeed(double speed) { axial = speed; }
    public void setLateralSpeed(double speed) { lateral = speed; }
    public void setRotationSpeed(double speed) { yaw = speed; }

    public void stopMovement() {
        axial = 0;
        lateral = 0;
        yaw = 0;
    }
}