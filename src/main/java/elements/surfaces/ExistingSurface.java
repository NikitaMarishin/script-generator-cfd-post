package elements.surfaces;

public class ExistingSurface implements Surface {
    private String surfaceName;

    public ExistingSurface(String surfaceName) {
        this.surfaceName = surfaceName;
    }

    @Override
    public String getName() {
        return surfaceName;
    }

    @Override
    public String getScriptForInitialization() {
        return "\n";
    }

    @Override
    public String getScriptForDelete() {
        return "\n";
    }

    @Override
    public String toString() {
        return getName();
    }
}
