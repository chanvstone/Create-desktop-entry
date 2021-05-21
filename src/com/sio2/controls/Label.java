package com.sio2.controls;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setFont(new Font(Font.SERIF, Font.PLAIN, 16));
    }

    public Label(String text) {
        super(text);
        setFont(new Font(Font.SERIF, Font.PLAIN, 16));
    }

    public Label() {
        super();
        setFont(new Font(Font.SERIF, Font.PLAIN, 16));
    }
}
