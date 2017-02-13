

/**
 *
 * @author jiaqi_000
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InputWindow extends JInternalFrame{
    private double iTemperature;
    private double tubeRadius;
    private double conductivity;
    
    public InputWindow(){
        super("Initial Conditions",true,true,true,true);
        JLabel inT = new JLabel("initial temperature");
        JLabel radius = new JLabel("tube radius");
        JLabel cond = new JLabel("conductivity");
        JTextField [] inputs = new JTextField[3];
        inputs[0]= new JTextField("  ");
        inputs[1]= new JTextField("  ");
        inputs[2]= new JTextField("  ");
        JButton start = new JButton("Start Calculation");
        setLayout(new GridLayout(4,2));
        add(inT);
        add(inputs[0]);
        add(radius);
        add(inputs[1]);
        add(cond);
        add(inputs[2]);
        add(start);
        this.setSize(300, 500);
        start.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        iTemperature =  Double.parseDouble(inputs[0].getText());
                        tubeRadius =  Double.parseDouble(inputs[1].getText()); 
                        conductivity =  Double.parseDouble(inputs[2].getText());
                        
                        System.out.println(iTemperature+"  "+tubeRadius+"  "+conductivity);
                        JOptionPane.showMessageDialog(null, "Inputs are:"+iTemperature+"  "+tubeRadius+"  "+conductivity);
                        CloseFrame();
                    }
                }
        );
    }
    public void CloseFrame(){
        super.dispose();
    }
}
