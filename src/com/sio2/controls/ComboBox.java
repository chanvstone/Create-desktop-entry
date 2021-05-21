package com.sio2.controls;

import javax.swing.*;
import java.awt.*;

public class ComboBox<E> extends JComboBox<E> {

    public ComboBox(E[] items) {
        super(items);
        setFont(new Font(Font.SERIF, Font.PLAIN, 16));

    }

}
