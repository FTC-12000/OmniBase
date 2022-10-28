package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.omnibase.OmniBaseLinear;

@Disabled
@Autonomous(name="Example: Auto Omni OpMode", group="OmniBase")
public class ExampleOmniAutoOpMode extends OmniBaseLinear {
    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
        setAxialSpeed(-0.25); sleep(1000);
        setAxialSpeed(0.25); sleep(1000);
        setAxialSpeed(0);
        setLateralSpeed(0.25); sleep(1000);
        setLateralSpeed(-0.25); sleep(1000);
        setLateralSpeed(0);
        setRotationSpeed(0.25); sleep(1000);
        setRotationSpeed(0.25); sleep(1000);
        setRotationSpeed(0);
    }
}
