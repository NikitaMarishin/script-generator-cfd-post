package gui.managed_panels;

import dto.DataStorage;
import gui.add_dialogs.AbstractAddDialog;
import gui.add_dialogs.VariableAddDialog;
import variables.Variable;

public class VariablesManagedPanel extends ManagedElementsPanelAbstract<Variable> {

    public VariablesManagedPanel(DataStorage dataStorage) {

        init(dataStorage, new VariableAddDialog(dataStorage), dataStorage.getVariables());
    }

}
