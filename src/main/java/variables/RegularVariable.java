package variables;

import java.util.ArrayList;
import java.util.List;

public class RegularVariable implements Variable {
    private String name;
    private String dimension;

    public static final Variable TEMPERATURE = new RegularVariable("Temperature", "C");
    public static final Variable PRESSURE = new RegularVariable("Pressure", "Pa");
    public static final Variable O2_MOLE_FRACTION = new RegularVariable("O2.Mole Fraction", "");
    public static final Variable DPM_MASS_CONCENTRATION= new RegularVariable("Particle Mass Concentration", "kg m^-3");
    public static final Variable X = new RegularVariable("X", "m");
    public static final Variable Y = new RegularVariable("Y", "m");
    public static final Variable Z = new RegularVariable("Z", "m");


    public static List<Variable> getDefaultVariables() {
        List<Variable> defaultVariables = new ArrayList<>();
        defaultVariables.add(TEMPERATURE);
        defaultVariables.add(PRESSURE);
        defaultVariables.add(O2_MOLE_FRACTION);
        defaultVariables.add(DPM_MASS_CONCENTRATION);
        defaultVariables.add(X);
        defaultVariables.add(Y);
        defaultVariables.add(Z);
        return defaultVariables;
    }

    public RegularVariable(String name, String dimension) {
        this.name = name;
        this.dimension = dimension.isEmpty()? "" : "[" + dimension + "]";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return getName();
    }
}
