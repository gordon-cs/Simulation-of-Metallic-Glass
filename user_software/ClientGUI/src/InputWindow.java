/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jiaqi_000
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

public class InputWindow extends JInternalFrame{
    private JButton enterButton;
    private JTextField initT;
    
    public InputWindow(){
        super("Initial Conditions",true,true,true,true);
        setLayout(new FlowLayout());
        initT = new JTextField("test");
        enterButton = new JButton("Start");
        add(initT);
        add(enterButton);
        
        enterButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        CloseFrame();
                    }
                }
        );
    }
    public void CloseFrame(){
        super.dispose();
    }
}
