
/**
 *
 * @author jiaqi_000
 */
//need review
import ch.systemsx.cisd.hdf5.HDF5Factory;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ch.systemsx.cisd.hdf5.IHDF5SimpleReader;

public class MainWindow extends JFrame{
    private JDesktopPane theDesktop;
    private InputWindow inputWindow;
    double[][] data;
    // set up GUI
    public MainWindow()
    {
        super("Heat Conduction simulation");
        
        JMenuBar bar = new JMenuBar();
        JMenu addMenu = new JMenu("  Add  ");
        JMenu newMenu = new JMenu("  New  ");
        JMenuItem graph = new JMenuItem ("Heat Graph");
        JMenuItem newCal = new JMenuItem("New Calculation");
        JMenuItem open = new JMenuItem("Open File");

        addMenu.add( graph );
        newMenu.add(newCal);
        newMenu.add(open);
        bar.add(newMenu);
        bar.add(addMenu);
        setJMenuBar( bar );
        
        theDesktop = new JDesktopPane();
        inputWindow = new InputWindow();
        theDesktop.add(inputWindow);
        add( theDesktop );
      
        open.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.CANCEL_OPTION)
                            JOptionPane.showMessageDialog(null, "No file is selected.");
                        else{
                            IHDF5SimpleReader reader = HDF5Factory.open(fileChooser.getSelectedFile());
                            data = reader.readDoubleMatrix("mydata");
                            reader.close();
                            JOptionPane.showMessageDialog(null, "You have loaded the data file.");
                        }
                    }
                }
        );
        graph.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        JInternalFrame frame = new JInternalFrame(
                            "Heat Graph", true, true, true, true);
                        HeatGraph hGraph = new HeatGraph(data);
                        frame.add(hGraph, BorderLayout.CENTER);
                        frame.pack();
                        theDesktop.add(frame);
                        frame.setVisible(true);
                    }
                }
        );
        newCal.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        inputWindow.setVisible(true);
                    }
                }
        );
    }
}

