/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diogo
 */
public class Options {
    private int id;
    private int id_command;
    private String optionCommand;
    private String description;
    private String example;

    public Options(int id, int id_command, String optionCommand, String description, String example) {
        this.id = id;
        this.id_command = id_command;
        this.optionCommand = optionCommand;
        this.description = description;
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_command() {
        return id_command;
    }

    public void setId_command(int id_command) {
        this.id_command = id_command;
    }

    public String getOptionCommand() {
        return optionCommand;
    }

    public void setOptionCommand(String optionCommand) {
        this.optionCommand = optionCommand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Options{" + "id=" + id + ", id_command=" + id_command + ", optionCommand=" + optionCommand + ", description=" + description + ", example=" + example + '}';
    }
    
    
}
