package gui.managed_panels;

import data.DataStorage;
import gui.addition_dialogs.VariablesAdditionDialog;
import elements.variables.Variable;

public class VariablesManagedPanel extends ManagedPanel<Variable> {

    public VariablesManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new VariablesAdditionDialog(dataStorage), dataStorage.getVariables());
    }

}
