package org.firstinspires.ftc.teamcode.powerplay;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.omnibase.OmniBase;
import org.firstinspires.ftc.teamcode.omnibase.hardware.OmniBot;

import java.util.concurrent.TimeUnit;

@TeleOp(name="PowerPlay TeleOp", group="12000-2022")
public class PowerPlayTeleOp extends OmniBase {
    boolean turbo = false;
    long sketchTurboTimer = 0;

    @Override
    public void init() {
        omniBot = new OmniBot(hardwareMap, "fr", "fl", "br", "bl");
        telemetry.addLine("Controller \"MODE\" LED *ON* = D-Pad");
        telemetry.addLine("Controller \"MODE\" LED *OFF* = Left Analog Stick");
        telemetry.update();
        telemetry.clear();
    }

    @Override
    public void loop() {
        if (gamepad1.ps && runtime.time(TimeUnit.MILLISECONDS) - sketchTurboTimer > 500) {
            sketchTurboTimer = runtime.time(TimeUnit.MILLISECONDS);
            turbo = !turbo;
        }

        boolean trigger = gamepad1.left_trigger > 0.7 || gamepad1.right_trigger > 0.7;

        setAxialSpeed(-gamepad1.left_stick_y / ((turbo || trigger) ? 1 : 2));
        setLateralSpeed(gamepad1.left_stick_x / ((turbo || trigger) ? 1 : 2));
        setRotationSpeed(gamepad1.right_stick_x / ((turbo || trigger) ? 1 : 2));

        telemetry.addData("Turbo", turbo ? "On" : "Off");
        super.loop();
    }
}
