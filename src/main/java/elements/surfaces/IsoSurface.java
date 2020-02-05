package elements.surfaces;

import elements.variables.Variable;

public class IsoSurface implements Surface {
    Variable isoVariable;
    double isoValue;

    public IsoSurface(Variable isoVariable, double isoValue) {
        this.isoVariable = isoVariable;
        this.isoValue = isoValue;
    }

    @Override
    public String getName() {
        String[] stringIsoValue = Double.valueOf(isoValue).toString().split("\\.");
        return "IsoSurface " + isoVariable.getName() + " " + stringIsoValue[0] + " " + stringIsoValue[1];
    }

    @Override
    public String getScriptForInitialization() {
        return "ISOSURFACE:" + getName() +  "\n" +
                "  Apply Instancing Transform = On\n" +
                "  Apply Texture = Off\n" +
                "  Blend Texture = On\n" +
                "  Colour = 0.75, 0.75, 0.75\n" +
                "  Colour Map = Default Colour Map\n" +
                "  Colour Mode = Use Plot Variable\n" +
                "  Colour Scale = Linear\n" +
                "  Colour Variable = Y\n" +
                "  Colour Variable Boundary Values = Conservative\n" +
                "  Culling Mode = No Culling\n" +
                "  Domain List = /DOMAIN GROUP:All Domains\n" +
                "  Draw Faces = On\n" +
                "  Draw Lines = Off\n" +
                "  Instancing Transform = /DEFAULT INSTANCE TRANSFORM:Default Transform\n" +
                "  Lighting = On\n" +
                "  Line Colour = 0, 0, 0\n" +
                "  Line Colour Mode = Default\n" +
                "  Line Width = 1\n" +
                "  Max = 0.0 [m]\n" +
                "  Min = 0.0 [m]\n" +
                "  Range = Global\n" +
                "  Render Edge Angle = 0 [degree]\n" +
                "  Specular Lighting = On\n" +
                "  Surface Drawing = Smooth Shading\n" +
                "  Texture Angle = 0\n" +
                "  Texture Direction = 0 , 1 , 0\n" +
                "  Texture Material = Metal\n" +
                "  Texture Position = 0 , 0\n" +
                "  Texture Scale = 1\n" +
                "  Texture Type = Predefined\n" +
                "  Tile Texture = Off\n" +
                "  Transform Texture = Off\n" +
                "  Transparency = 0.0\n" +
                "  Value = " + isoValue + " " + isoVariable.getDimension() + "\n" +
                "  Variable = " + isoVariable.getName() + "\n" +
                "  Variable Boundary Values = Conservative\n" +
                "  Visibility = false\n" +
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
                "END" + "\n";
    }

    @Override
    public String getScriptForDelete() {
        return ">delete " + getName() +"\n";
    }

    @Override
    public String toString() {
        return getName();
    }
}