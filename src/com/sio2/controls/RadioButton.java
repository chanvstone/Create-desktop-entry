package com.sio2.controls;

import javax.swing.*;
import java.awt.*;

public class RadioButton extends JRadioButton {
    public RadioButton(String text, boolean selected) {
        super(text, selected);
        setFont(new Font(Font.SERIF, Font.PLAIN, 16));
    }
}
