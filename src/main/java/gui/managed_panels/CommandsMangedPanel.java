package gui.managed_panels;

import elements.commands.Command;
import data.DataStorage;
import gui.addition_dialogs.CommandsAdditionDialog;

public class CommandsMangedPanel extends ManagedPanel<Command> {

    public CommandsMangedPanel(DataStorage dataStorage) {

        init(dataStorage, new CommandsAdditionDialog(dataStorage), dataStorage.getCommands());
    }
}
