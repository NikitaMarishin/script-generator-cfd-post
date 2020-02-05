package elements;

import elements.Hideable;
import elements.Showable;

public interface Printable extends Showable, Hideable, Nameable {

    @Override
    default String getScriptShow() {
        return ">show " + getName() + "\n";
    }

    @Override
    default String getScriptHide() {
        return ">hide " + getName() + "\n";
    }
}
