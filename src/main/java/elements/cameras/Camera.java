package elements.cameras;

public class Camera {
    private String cameraName;
    private String cameraDescription;

    public Camera(String cameraName, String cameraDescription) {
        this.cameraName = cameraName;
        this.cameraDescription = cameraDescription;
    }

    public String getScriptToSetCamera() {
        return cameraDescription + "\n";
    }

    @Override
    public String toString() {
        return cameraName;
    }
}
