package elements.commands;


import elements.Showable;

public class ShowCommand implements Command {
    private Showable elementToShow;

    public ShowCommand(Showable surfaceToShow) {
        this.elementToShow = surfaceToShow;
    }

    @Override
    public String execute() {
        return elementToShow.getScriptShow();
    }

    @Override
    public void undo() {

    }

    @Override
    public String toString() {
        return "Show("
                 + elementToShow +
                ')';
    }
}
