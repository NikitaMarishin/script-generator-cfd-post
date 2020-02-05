package gui.managed_panels;

import elements.commands.Command;
import dto.DataStorage;
import gui.add_dialogs.CommandsAddDialog;

public class CommandsMangedPanel extends ManagedElementsPanelAbstract<Command> {

    public CommandsMangedPanel(DataStorage dataStorage) {

        init(dataStorage, new CommandsAddDialog(dataStorage), dataStorage.getCommands());
    }
}
