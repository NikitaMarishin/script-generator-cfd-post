package gui.addition_dialogs.addition_panels.commands;

import elements.commands.Command;
import elements.commands.SetDirectoryForSaveCommand;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.Vector;

public class SetDirectoryCommandAdditionPanel extends AdditionPanel {
    private JTextField directoryField;

    public SetDirectoryCommandAdditionPanel() {
        directoryField = new JTextField(30);
        add(directoryField);
    }

    @Override
    public Vector<Command> getNewInstances() {
        Vector<Command> result = new Vector<>();
        result.add(new SetDirectoryForSaveCommand(directoryField.getText()));
        return result;
    }
}
