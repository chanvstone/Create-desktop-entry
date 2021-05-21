package com.sio2;

import com.sio2.controls.Button;
import com.sio2.controls.Label;
import com.sio2.controls.TextField;
import com.sio2.controls.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private Model model;

    public View() {
        super(Model.FRAME_TITLE);

        model = Model.newInstance();

        init();
    }

    /*
    添加type条目
     */
    private void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(8, 16, 8, 16);
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.9;
        c.weighty = 0.6;


        Label type_label = new Label("Type", Label.RIGHT);
        ComboBox<String> type_comboBox = new ComboBox<>(new String[]{Model.Type.APPLICATION, Model.Type.LINK, Model.Type.DIRECTORY});
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 1;
        add(type_label, c);
        c.gridx += 1;
        c.gridwidth = 2;
        add(type_comboBox, c);


        Label name_label = new Label("Name", Label.RIGHT);
        TextField name_textField = new TextField();
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(name_label, c);
        c.gridx += 1;
        c.gridwidth = 2;
        add(name_textField, c);


        Label genericName_label = new Label("Generic Name", Label.RIGHT);
        TextField genericName_textField = new TextField();
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(genericName_label, c);
        c.gridx += 1;
        c.gridwidth = 2;
        add(genericName_textField, c);


        Label comment_label = new Label("Comment", Label.RIGHT);
        TextField comment_textField = new TextField();
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(comment_label, c);
        c.gridx += 1;
        c.gridwidth = 2;
        add(comment_textField, c);


        Label path_label = new Label("Path", Label.RIGHT);
        TextField path_textField = new TextField();
        Button path_button = new Button("选择文件夹");
        path_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser(FileChooser.DIRECTORIES_ONLY);
                if (fileChooser.showOpenDialog(View.this) == FileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    path_textField.setText(path);
                    model.setPath(path);
                }
            }
        });
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(path_label, c);
        c.gridx += 1;
        c.gridwidth = 1;

        add(path_textField, c);
        c.gridx += 1;
        c.gridwidth = 1;
        add(path_button, c);


        Label exec_label = new Label("Exec", Label.RIGHT);
        TextField exec_textField = new TextField();
        Button exec_button = new Button("选择可执行文件");
        exec_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser(FileChooser.FILES_ONLY);
                fileChooser.setFileSelectionMode(FileChooser.FILES_ONLY);
                if (fileChooser.showOpenDialog(View.this) == FileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    exec_textField.setText(path);
                    model.setExec(path);
                }
            }
        });
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(exec_label, c);
        c.gridx += 1;
        c.gridwidth = 1;

        add(exec_textField, c);
        c.gridx += 1;
        c.gridwidth = 1;
        add(exec_button, c);


        Label icon_label = new Label("Icon", Label.RIGHT);
        TextField icon_textField = new TextField();
        Button icon_button = new Button("选择图标");
        icon_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser(FileChooser.FILES_ONLY);
                fileChooser.setFileSelectionMode(FileChooser.FILES_ONLY);
                if (fileChooser.showOpenDialog(View.this) == FileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    icon_textField.setText(path);
                    model.setIcon(path);
                }
            }
        });
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(icon_label, c);
        c.gridx += 1;
        c.gridwidth = 1;

        add(icon_textField, c);
        c.gridx += 1;
        c.gridwidth = 1;
        add(icon_button, c);


        Label terminal_label = new Label("Terminal", Label.RIGHT);
        RadioButton terminal_true_radioButton = new RadioButton("true", true);
        RadioButton terminal_false_radioButton = new RadioButton("false", false);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(terminal_true_radioButton);
        buttonGroup.add(terminal_false_radioButton);
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(terminal_label, c);
        c.gridx += 1;
        add(terminal_true_radioButton, c);
        c.gridx += 1;
        add(terminal_false_radioButton, c);


        Button create_button = new Button("CREATE");
        create_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.setName(name_textField.getText());
                model.setType((String) type_comboBox.getSelectedItem());
                model.setGenericName(genericName_textField.getText());
                model.setComment(comment_textField.getText());
                model.setExec(exec_textField.getText());
                model.setPath(path_textField.getText());
                model.setIcon(icon_textField.getText());
                model.setTerminal(terminal_true_radioButton.isSelected());
                model.makeDesktopFile();
            }
        });
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 3;
        add(create_button, c);

    }


    public void start() {
//        setSize(new Dimension(400, 600));
        setSize(getPreferredSize());
        this.setVisible(true);
    }
}
