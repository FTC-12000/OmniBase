package org.firstinspires.ftc.teamcode.omnibase;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.omnibase.hardware.OmniBot;

public class OmniBaseLinear extends LinearOpMode {
    public OmniBot omniBot;

    public final ElapsedTime runtime = new ElapsedTime();

    private double axial = 0;
    private double lateral = 0;
    private double yaw = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        omniBot = new OmniBot(hardwareMap);

        waitForStart();
    }

    public void calculateMovement() {
        double max;

        double frontRightPower = axial - lateral - yaw;
        double frontLeftPower = axial + lateral + yaw;
        double backRightPower = axial + lateral - yaw;
        double backLeftPower = axial - lateral + yaw;

        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontRightPower /= max;
            frontLeftPower /= max;
            backRightPower /= max;
            backLeftPower /= max;
        }

        omniBot.setFrontRightDrivePower(frontRightPower);
        omniBot.setFrontLeftDrivePower(frontLeftPower);
        omniBot.setBackRightDrivePower(backRightPower);
        omniBot.setBackLeftDrivePower(backLeftPower);

        telemetry.addData("Run Time", runtime.toString());
        telemetry.addData("Front Left/Right", "%4.2f, %4.2f", frontLeftPower, frontRightPower);
        telemetry.addData("Back  Left/Right", "%4.2f, %4.2f", backLeftPower, backRightPower);
        telemetry.update();
    }

    public void setAxialSpeed(double speed) { axial = speed; calculateMovement(); }
    public void setLateralSpeed(double speed) { lateral = speed; calculateMovement(); }
    public void setRotationSpeed(double speed) { yaw = speed; calculateMovement(); }

    public void stopMovement() {
        axial = 0;
        lateral = 0;
        yaw = 0;
    }
}