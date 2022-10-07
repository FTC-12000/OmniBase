/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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