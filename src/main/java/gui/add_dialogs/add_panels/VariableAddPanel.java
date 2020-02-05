package gui.add_dialogs.add_panels;

import elements.variables.RegularVariable;
import elements.variables.Variable;

import javax.swing.*;
import java.util.Vector;

public class VariableAddPanel extends AbstractAddPanel {

    private JTextField nameTextField;
    private JTextField dimensionTextField;

    public VariableAddPanel() {
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
