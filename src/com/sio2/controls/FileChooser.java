package com.sio2.controls;

import javax.swing.*;
import java.io.File;

public class FileChooser extends JFileChooser {
    public FileChooser(int fileSelectionMode) {
        super();
        setFileSelectionMode(fileSelectionMode);
        setFileHidingEnabled(true);
        setCurrentDirectory(new File(System.getenv("HOME")+"/.local"));
    }
}
