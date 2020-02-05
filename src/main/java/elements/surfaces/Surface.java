package elements.surfaces;

import elements.printer.Printable;

public interface Surface extends Printable {
    String getName();
    String getScriptForInitialization();
    String getScriptForDelete();

    default String getScriptShow() {
        return getScriptForInitialization() + ">show " + getName() + "\n";
    }

    default String getScriptHide() {
        return ">hide " + getName() + "\n";
    }
}
