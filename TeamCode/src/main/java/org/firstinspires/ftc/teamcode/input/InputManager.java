package org.firstinspires.ftc.teamcode.input;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Gamepad gamepad;
    private final Map<String, Input> binds = new HashMap<>();

    public InputManager(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public void registerInput(String name, Input input) {
        binds.put(name, input);
    }

    public void loop() {
        for (Input input : binds.values()) {

        }
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