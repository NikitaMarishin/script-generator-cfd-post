package elements.commands;


import elements.Hideable;

public class HideCommand implements  Command{

    private Hideable elementToHide;

    public HideCommand(Hideable elementToHide) {
        this.elementToHide = elementToHide;
    }

    @Override
    public String execute() {
        return elementToHide.getScriptHide();
    }

    @Override
    public void undo() {

    }

    @Override
    public String toString() {
        return "Hide("
                + elementToHide +
                ')';
    }
}
