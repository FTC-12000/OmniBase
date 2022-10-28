package org.firstinspires.ftc.teamcode.powerplay;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.omnibase.OmniBase;

@TeleOp(name="PowerPlay TeleOp", group="2022")
public class PowerPlayTeleOp extends OmniBase {
    @Override
    public void loop() {
        setAxialSpeed(gamepad1.left_stick_y / 2);
        setLateralSpeed(gamepad1.left_stick_x / 2);
        setRotationSpeed(gamepad1.right_stick_x / 2);
        super.loop();
    }
}
