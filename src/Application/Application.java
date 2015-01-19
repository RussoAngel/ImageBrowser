package Application;

import Control.ImageCommand;
import Control.NextImageCommand;
import Control.PrevImageCommand;
import Model.Image;
import Persistence.ImageListLoader;
import Persistence.file.FileImageListLoader;
import UI.swing.ActionListenerFactory;
import UI.swing.ApplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private ApplicationFrame frame;
    private static String path;
    private Map<String, ImageCommand> commandMap;
    
    public static void main(String[] args) {
        path = "Sobreescribir este mensaje con la ruta de la carpeta contenedora de imagenes";
        new Application().execute();
    }
    
    private void execute() {
        ImageListLoader loader = createImageListLoader(path);
        List<Image> list = loader.load();
        frame = new ApplicationFrame(createActionListenerFactory());
        frame.getImageViewer().setImage(list.get(0));
        createCommands();
        frame.setVisible(true);
    }
    private void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Next", new NextImageCommand(frame.getImageViewer()));
        commandMap.put("Prev", new PrevImageCommand(frame.getImageViewer()));
    }
    
    private ImageListLoader createImageListLoader(String path) {
        return new FileImageListLoader(path);
    }
    
    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {
            @Override
            public ActionListener create(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ImageCommand command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        };
    }
}
