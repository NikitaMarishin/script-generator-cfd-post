package printer;

import commands.Hideable;
import commands.Showable;

public interface Printable extends Showable, Hideable {
    String getName();

    @Override
    default String getScriptShow() {
        return ">show " + getName() + "\n";
    }

    @Override
    default String getScriptHide() {
        return ">hide " + getName() + "\n";
    }
}
