package org.firstinspires.ftc.teamcode.powerplay;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.omnibase.OmniBaseLinear;
import org.firstinspires.ftc.teamcode.omnibase.hardware.OmniBot;

//@Autonomous(name="PowerPlay Dummy AutoOp", group="12000-2022")
@Autonomous(name="33.33% of the time it works 100% of the time", group="12000-2022")
public class PowerPlayDummyAutoOp extends OmniBaseLinear {
    @Override
    public void runOpMode() {
        omniBot = new OmniBot(hardwareMap, "fr", "fl", "br", "bl");

        waitForStart();

        setAxialSpeed(-0.5); sleep(800);
        setRotationSpeed(0.1);  // 0.2 is good enough
        setLateralSpeed(-0.1);
        stopMovement();
    }
}
