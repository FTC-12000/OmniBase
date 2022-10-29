package org.firstinspires.ftc.teamcode.input;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Gamepad gamepad;
    private final Map<Button, InputHandler> binds = new HashMap<>();

    public InputManager(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public registerInput(Button button, InputType type, InputHandler input) {

    }

    private boolean getButton(Button button) {
        switch (button) {
            case A:
                return gamepad.a;
            case B:
                return gamepad.b;
            case X:
                return gamepad.x;
            case Y:
                return gamepad.y;
        }
    }
}