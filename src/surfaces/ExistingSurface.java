package surfaces;

public class ExistingSurface implements Surface {
    private String nameOfSurface;

    public ExistingSurface(String nameOfSurface) {
        this.nameOfSurface = nameOfSurface;
    }

    @Override
    public String getName() {
        return nameOfSurface;
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
