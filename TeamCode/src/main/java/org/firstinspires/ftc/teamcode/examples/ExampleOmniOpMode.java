package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.omnibase.OmniBase;

@Disabled
@TeleOp(name="Example: Omni OpMode", group="OmniBase")
public class ExampleOmniOpMode extends OmniBase {
    @Override
    public void loop() {
        setAxialSpeed(gamepad1.left_stick_y / 2);
        setLateralSpeed(gamepad1.left_stick_x / 2);
        setRotationSpeed(gamepad1.right_stick_x / 2);
        super.loop();
    }
}