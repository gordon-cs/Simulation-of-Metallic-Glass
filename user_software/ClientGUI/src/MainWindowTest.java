
/**
 *
 * @author jiaqi_000
 */
import javax.swing.JFrame;
public class MainWindowTest {
    public static void main( String[] args){
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 1000);
        mainWindow.setVisible(true);
    }
}
