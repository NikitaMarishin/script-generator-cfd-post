package elements.surfaces;

import elements.Printable;
import elements.variables.Variable;

public interface Surface extends Printable {
    String getScriptForInitialization();
    String getScriptForDelete();

    default String getScriptShow() {
        return getScriptForInitialization() + ">show " + getName() + "\n";
    }

    static Surface createIsoSurface(Variable isoVariable, double isoValue) {
        return new IsoSurface(isoVariable, isoValue);
    }

    static Surface createExSurface(String surfaceName) {
        return new ExistingSurface(surfaceName);
    }

}
