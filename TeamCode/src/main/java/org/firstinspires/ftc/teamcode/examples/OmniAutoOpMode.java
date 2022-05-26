package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.omnibase.OmniBaseLinear;

@Autonomous(name="Auto Omni OpMode", group="12000")
public class OmniAutoOpMode extends OmniBaseLinear {
    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
        moveForward(0.25); sleep(1000);
        moveBackwards(0.25); sleep(1000);
        moveForward(0);
        moveLeft(0.25); sleep(1000);
        moveRight(0.25); sleep(1000);
        moveLeft(0);
        turnLeft(0.25); sleep(1000);
        turnRight(0.25); sleep(1000);
        turnLeft(0);
    }
}
