package gui.add_dialogs.add_panels;

import commands.Command;
import commands.SetDirectoryForSaveCommand;

import javax.swing.*;
import java.util.Vector;

public class SetDirectoryCommandAddPanel extends AbstractAddPanel {
    private JTextField directoryField;

    public SetDirectoryCommandAddPanel() {
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
