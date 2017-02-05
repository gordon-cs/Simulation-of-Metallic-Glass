/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jiaqi_000
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainWindow extends JFrame{
    private JDesktopPane theDesktop;
    // set up GUI
    public MainWindow()
    {
        super("Heat Conduction simulation");
        
        JMenuBar bar = new JMenuBar();
        JMenu addMenu = new JMenu("  Add  ");
        JMenu newMenu = new JMenu("  New  ");
        JMenuItem graph = new JMenuItem ("Heat Graph");
        JMenuItem newCal = new JMenuItem("New Calculation");
        
        addMenu.add( graph );
        newMenu.add(newCal);
        bar.add(newMenu);
        bar.add(addMenu);
        setJMenuBar( bar );
        
        theDesktop = new JDesktopPane();
        add( theDesktop );
        
        graph.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        JInternalFrame frame = new JInternalFrame(
                            "Heat Graph", true, true, true, true);
                        HeatGraph hGraph = new HeatGraph();
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
                        
                        InputWindow iWindow = new InputWindow();
                        iWindow.pack();
                        theDesktop.add(iWindow);
                        iWindow.setVisible(true);
                    }
                }
        );
    }
}

