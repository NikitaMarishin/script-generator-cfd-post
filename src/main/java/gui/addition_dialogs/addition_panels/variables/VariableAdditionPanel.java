package gui.addition_dialogs.addition_panels.variables;

import elements.variables.RegularVariable;
import elements.variables.Variable;
import gui.addition_dialogs.addition_panels.AdditionPanel;

import javax.swing.*;
import java.util.Vector;

public class VariableAdditionPanel extends AdditionPanel {

    private JTextField nameTextField;
    private JTextField dimensionTextField;

    public VariableAdditionPanel() {
        nameTextField = new JTextField(30);
        add(nameTextField);

        dimensionTextField = new JTextField(30);
        add(dimensionTextField);
    }

    @Override
    public Vector<Variable> getNewInstances() {
        Vector<Variable> result = new Vector<>();
        result.add(new RegularVariable(nameTextField.getText(), dimensionTextField.getText()));
        return result;
    }
}
