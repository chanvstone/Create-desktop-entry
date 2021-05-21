package com.sio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
    public static final String FRAME_TITLE = "Create desktop icon";
    private static Model model = new Model();
    private String name, genericName, comment, path, exec, icon, type, fileName;
    private boolean terminal;

    public Model() {
    }

    public static Model newInstance() {
        return model;
    }

    public void makeDesktopFile() {
        File desktopFile = new File(System.getenv("HOME") + "/.local/share/applications/", getFileName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Desktop Entry]\n");
        stringBuilder.append("Type=" + getType() + "\n");
        stringBuilder.append("Name=" + getName() + "\n");
        stringBuilder.append("GenericName=" + getGenericName() + "\n");
        stringBuilder.append("Comment=" + getComment() + "\n");
        stringBuilder.append("Path=" + getPath() + "\n");
        stringBuilder.append("Exec=" + getExec() + "\n");
        stringBuilder.append("Icon=" + getIcon() + "\n");
        stringBuilder.append("Terminal=" + isTerminal() + "\n");
        try {
            FileWriter fileWriter = new FileWriter(desktopFile);
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        setFileName(name);
        this.name = name.replaceAll(" ", "\\\\s");
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName.toLowerCase().replaceAll(" ", "_") + ".desktop";
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExec() {
        return exec;
    }

    public void setExec(String exec) {
        this.exec = exec;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", genericName='" + genericName + '\'' +
                ", comment='" + comment + '\'' +
                ", path='" + path + '\'' +
                ", exec='" + exec + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", terminal=" + terminal +
                '}';
    }

    public static class Type {
        public static String APPLICATION = "Application",
                LINK = "Link",
                DIRECTORY = "Directory";
    }
}
