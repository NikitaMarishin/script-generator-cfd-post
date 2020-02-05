package elements.contours;

import elements.printer.Printable;
import elements.surfaces.Surface;
import elements.variables.Variable;

public class Contour implements Printable {
    private Surface surfaceToPlot;
    private Variable variableToPlot;
    private double minValue;
    private double maxValue;
    private int numberOfDivision;

    public Contour(Surface surfaceToPlot, Variable variableToPlot) {
        this.surfaceToPlot = surfaceToPlot;
        this.variableToPlot = variableToPlot;
    }

    public Contour setLimits(double minValue, double maxValue, int numberOfDivision) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.numberOfDivision = numberOfDivision;
        return this;
    }

    public String getName() {
        return variableToPlot.getName() + " " + surfaceToPlot.getName();
    }


    private String getScriptToDelete() {
        return ">delete " + getName() + "\n";
              // surfaceToPlot.getScriptForDelete();
    }
    private String getScriptForInitialization() {
        return surfaceToPlot.getScriptForInitialization() +
                "CONTOUR:" + getName() + "\n" + //1
                "  Apply Instancing Transform = On\n" +
                "  Clip Contour = Off\n" +
                "  Colour Map = Default Colour Map\n" +
                "  Colour Scale = Linear\n" +
                "  Colour Variable = " + variableToPlot.getName() + "\n" + //1
                "  Colour Variable Boundary Values = Conservative\n" +
                "  Constant Contour Colour = Off\n" +
                "  Contour Range = User Specified\n" +
                "  Culling Mode = No Culling\n" +
                "  Domain List = /DOMAIN GROUP:All Domains\n" +
                "  Draw Contours = On\n" +
                "  Font = Sans Serif\n" +
                "  Fringe Fill = On\n" +
                "  Instancing Transform = /DEFAULT INSTANCE TRANSFORM:Default Transform\n" +
                "  Lighting = Off\n" +
                "  Line Colour = 0, 0, 0\n" +
                "  Line Colour Mode = Default\n" +
                "  Line Width = 1\n" +
                "  Location List = " + surfaceToPlot.getName() + "\n" + //1
                "  Max = " + maxValue + " " + variableToPlot.getDimension() + "\n" +  //2
                "  Min = " + minValue + " " + variableToPlot.getDimension() + "\n" +  //2
                "  Number of Contours = " + numberOfDivision + "\n" + //1
                "  Show Numbers = Off\n" +
                "  Specular Lighting = On\n" +
                "  Surface Drawing = Smooth Shading\n" +
                "  Text Colour = 0, 0, 0\n" +
                "  Text Colour Mode = Default\n" +
                "  Text Height = 0.024\n" +
                "  Transparency = 0.0\n" +
                "  Use Face Values = Off\n" +
                "  Value List = 0 " + variableToPlot.getDimension() + ",1 " + variableToPlot.getDimension() + "\n" + //2
                "  OBJECT VIEW TRANSFORM:\n" +
                "    Apply Reflection = Off\n" +
                "    Apply Rotation = Off\n" +
                "    Apply Scale = Off\n" +
                "    Apply Translation = Off\n" +
                "    Principal Axis = Z\n" +
                "    Reflection Plane Option = XY Plane\n" +
                "    Rotation Angle = 0.0 [degree]\n" +
                "    Rotation Axis From = 0 [m], 0 [m], 0 [m]\n" +
                "    Rotation Axis To = 0 [m], 0 [m], 0 [m]\n" +
                "    Rotation Axis Type = Principal Axis\n" +
                "    Scale Vector = 1 , 1 , 1\n" +
                "    Translation Vector = 0 [m], 0 [m], 0 [m]\n" +
                "    X = 0.0 [m]\n" +
                "    Y = 0.0 [m]\n" +
                "    Z = 0.0 [m]\n" +
                "  END\n" +
                "END" + "\n" + ">show " + getName() + "\n";
    }


    @Override
    public String getScriptShow() {
        return getScriptForInitialization()
                + ">show " + getName() + "\n";
    }

    @Override
    public String toString() {
        return getName();
    }
}
