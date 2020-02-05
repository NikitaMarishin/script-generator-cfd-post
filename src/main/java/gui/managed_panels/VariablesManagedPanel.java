package gui.managed_panels;

import data.DataStorage;
import gui.add_dialogs.VariableAddDialog;
import elements.variables.Variable;

public class VariablesManagedPanel extends ManagedElementsPanelAbstract<Variable> {

    public VariablesManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new VariableAddDialog(dataStorage), dataStorage.getVariables());
    }

}
