package elements.commands;

import elements.cameras.Camera;

public class SetCameraCommand implements Command {
    private Camera camera;

    public SetCameraCommand(Camera camera) {
        this.camera = camera;
    }

    @Override
    public String execute() {
        return camera.getScriptToSetCamera();
    }

    @Override
    public String toString() {
        return "SetCamera("
                 + camera +
                ')';
    }
}
