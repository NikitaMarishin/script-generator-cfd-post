package surfaces;

import variables.Variable;

import java.util.ArrayList;
import java.util.List;

public class IsoClip implements Surface {
    private Surface surfaceToClip;
    private List<Bound> bounds;

    public IsoClip(Surface surfaceToClip) {
        this.surfaceToClip = surfaceToClip;
        bounds = new ArrayList<>();
    }

    public void setBound(Variable variableToBound, double minValue, double maxValue) {
        bounds.add(new Bound(variableToBound, minValue, maxValue));
    }

    @Override
    public String getName() {
        return surfaceToClip.getName() + " c";
    }

    @Override
    public String getScriptForInitialization() {
        return "ISO CLIP:" + getName() + "\n" +
                "  Apply Instancing Transform = On\n" +
                "  Apply Texture = Off\n" +
                "  Blend Texture = On\n" +
                "  Colour = 0.75, 0.75, 0.75\n" +
                "  Colour Map = Default Colour Map\n" +
                "  Colour Mode = Constant\n" +
                "  Colour Scale = Linear\n" +
                "  Colour Variable = Pressure\n" +
                "  Colour Variable Boundary Values = Conservative\n" +
                "  Culling Mode = No Culling\n" +
                "  Domain List = /DOMAIN GROUP:All Domains\n" +
                "  Draw Faces = On\n" +
                "  Draw Lines = Off\n" +
                "  Instancing Transform = /DEFAULT INSTANCE TRANSFORM:Default Transform\n" +
                "  Iso Clip Geometry = Lines Only\n" +
                "  Lighting = On\n" +
                "  Line Colour = 0, 0, 0\n" +
                "  Line Colour Mode = Default\n" +
                "  Line Width = 1\n" +
                "  Location List = " + surfaceToClip.getName() + "\n" +
                "  Max = 0.0 [Pa]\n" +
                "  Min = 0.0 [Pa]\n" +
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
                "  Visibility = true\n" +

                insertClipLimiters() +

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
                "END";
    }

    private String insertClipLimiters() {
        String clipLimiters = "";
        for (int i = 0; i < bounds.size(); i++) {
            clipLimiters += "  ISO CLIP LIMITER:Iso Clip Limiter " + (2 * i) + "\n" +
                    "    Limiter Operation = Less Or Equal To\n" +
                    "    Value = " + bounds.get(i).maxValue + " " + bounds.get(i).variableToBound.getDimension() + "\n" +
                    "    Variable = " + bounds.get(i).variableToBound.getName() + "\n" +
                    "    Variable Boundary Values = Conservative\n" +
                    "  END\n" +
                    "  ISO CLIP LIMITER:Iso Clip Limiter " + (2 * i + 1) + "\n" +
                    "    Limiter Operation = Greater Or Equal To\n" +
                    "    Value = " + bounds.get(i).minValue + " " + bounds.get(i).variableToBound.getDimension() + "\n" +
                    "    Variable = " + bounds.get(i).variableToBound.getName() + "\n" +
                    "    Variable Boundary Values = Conservative\n" +
                    "  END\n";
        }

        return clipLimiters;
    }

    @Override
    public String getScriptForDelete() {
        return ">delete " + getName() + "\n" + surfaceToClip.getScriptForDelete();
    }
}

class Bound {
    Variable variableToBound;
    double minValue;
    double maxValue;

    Bound(Variable variableToBound, double minValue, double maxValue) {
        this.variableToBound = variableToBound;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
