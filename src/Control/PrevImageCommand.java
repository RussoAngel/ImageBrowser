package Control;

import UI.ImageViewer;

public class PrevImageCommand implements ImageCommand {
    private final ImageViewer viewer;
    public PrevImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    public ImageViewer getViewer() {
        return viewer;
    }
    
    @Override
    public void execute() {
        this.getViewer().showPrevImage();
    }
}
