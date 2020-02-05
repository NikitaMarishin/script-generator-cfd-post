package elements.commands;

public interface Command {

    String execute();

    void undo();
}
