
/**
 *
 * @author jiaqi_000
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class MainWindowTest {
    public static void main( String[] args){
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 1000);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - mainWindow.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - mainWindow.getHeight()) / 2);
        mainWindow.setLocation(x, y);
        mainWindow.setVisible(true);
    }
}
