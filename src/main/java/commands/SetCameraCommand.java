package commands;

import cameras.Camera;

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
    public void undo() {

    }

    @Override
    public String toString() {
        return "SetCamera("
                 + camera +
                ')';
    }
}
