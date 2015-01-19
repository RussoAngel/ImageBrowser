package Control;

import UI.ImageViewer;

public interface ImageCommand {
    public ImageViewer getViewer();
    public abstract void execute();
}
