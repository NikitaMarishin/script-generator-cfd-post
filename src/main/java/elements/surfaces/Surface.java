package elements.surfaces;

import elements.Printable;

public interface Surface extends Printable {
    String getScriptForInitialization();
    String getScriptForDelete();

    default String getScriptShow() {
        return getScriptForInitialization() + ">show " + getName() + "\n";
    }

}
