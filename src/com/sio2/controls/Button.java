package com.sio2.controls;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String text) {
        super(text);
        setFont(new Font(Font.SERIF, Font.PLAIN, 16));
    }
}
