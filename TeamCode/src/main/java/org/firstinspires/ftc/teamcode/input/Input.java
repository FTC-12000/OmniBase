package org.firstinspires.ftc.teamcode.input;

public class Input {
    private final InputType type;

    public Input(Button button, InputType type, InputHandler input) {
        this.type = type;
    }
}