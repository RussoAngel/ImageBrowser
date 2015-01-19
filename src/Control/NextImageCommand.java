package Control;

import UI.ImageViewer;

public class NextImageCommand implements ImageCommand {
    private final ImageViewer viewer;
    
    public NextImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    public ImageViewer getViewer() {
        return viewer;
    }
    
    @Override
    public void execute() {
        this.getViewer().showNextImage();
    }
}
