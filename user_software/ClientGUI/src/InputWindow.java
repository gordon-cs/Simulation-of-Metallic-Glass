
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jiaqi_000
 */
public class InputWindow extends JInternalFrame {

    /**
     * Creates new form InputWindow
     */
    public InputWindow() {
        initComponents();
        start_button.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                            
                        mTemp = Double.parseDouble(mTempT.getText());
                        rTemp = Double.parseDouble(rTempT.getText());
                        radius = Double.parseDouble(radiusT.getText());
                        thickness = Double.parseDouble(thicknessT.getText());
                        height = Double.parseDouble(heightT.getText());
                        time = Double.parseDouble(timeT.getText());
                        conductivity = Double.parseDouble(conductivityT.getText());
                        try{
                            Element calculation = new Element("calculation");
                            calculation.setAttribute(new Attribute("method","sequential"));
                            Document doc = new Document(calculation);
                            
                            Element tl = new Element("time_length");
                            tl.setAttribute("type","default");
                            tl.setText(timeT.getText());
                            Element r = new Element("radius");
                            r.setAttribute("type","default");
                            r.setText(radiusT.getText());
                            Element th = new Element("thickness");
                            th.setAttribute("type","default");
                            th.setText(thicknessT.getText());
                            Element h = new Element("height");
                            h.setAttribute("type","default");
                            h.setText(heightT.getText());
                            Element t = new Element("height");
                            t.setAttribute("type","default");
                            t.setText(mTempT.getText());
                            Element c = new Element("conductivity");
                            c.setAttribute("type","default");
                            c.setText(conductivityT.getText());
                            Element it = new Element("init_tempreture");
                            it.setAttribute("type","default");
                            it.setText(rTempT.getText());
                            
                            calculation.addContent(tl);
                            calculation.addContent(r);
                            calculation.addContent(th);
                            calculation.addContent(h);
                            calculation.addContent(t);
                            calculation.addContent(c);
                            calculation.addContent(it);
                            //format changed
//                            Element general = new Element("general");
//                            general.addContent(new Element("time_length").setText(timeT.getText()));
//                            doc.getRootElement().addContent(general);
//
//                            Element tube = new Element("tube");
//                            tube.addContent(new Element("radius").setText(radiusT.getText()));
//                            tube.addContent(new Element("thickness").setText(thicknessT.getText()));
//                            tube.addContent(new Element("height").setText(heightT.getText()));
//                            doc.getRootElement().addContent(tube);
//
//                            Element material = new Element("material");
//                            material.addContent(new Element("tempreture").setText(mTempT.getText()));
//                            material.addContent(new Element("conductivity").setText(conductivityT.getText()));
//                            doc.getRootElement().addContent(material);
//
//                            Element reservoir = new Element("reservoir");
//                            reservoir.addContent(new Element("init_tempreture").setText(rTempT.getText()));
//                            doc.getRootElement().addContent(reservoir);

                            XMLOutputter xmlOutput = new XMLOutputter();
                            xmlOutput.setFormat(Format.getPrettyFormat());
                            xmlOutput.output(doc, new FileWriter("data.xml"));
                            
                            
                            setVisible(false);
                        }catch (IOException io){
                            System.out.println(io.getMessage());
                        }
                        
                    }
                }
        );
        cancel_button.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        setVisible(false);
                    }
                }
        );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generalP = new javax.swing.JPanel();
        timeL = new javax.swing.JLabel();
        timeT = new javax.swing.JFormattedTextField();
        tubeP = new javax.swing.JPanel();
        radiusL = new javax.swing.JLabel();
        thicknessL = new javax.swing.JLabel();
        heightL = new javax.swing.JLabel();
        radiusT = new javax.swing.JFormattedTextField();
        thicknessT = new javax.swing.JFormattedTextField();
        heightT = new javax.swing.JFormattedTextField();
        materialP = new javax.swing.JPanel();
        mTempL = new javax.swing.JLabel();
        conductivityL = new javax.swing.JLabel();
        mTempT = new javax.swing.JFormattedTextField();
        conductivityT = new javax.swing.JFormattedTextField();
        reserviorP = new javax.swing.JPanel();
        rTempL = new javax.swing.JLabel();
        rTempT = new javax.swing.JFormattedTextField();
        start_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();

        setTitle("Input Window");

        generalP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        timeL.setText("Time Length(second): ");

        timeT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout generalPLayout = new javax.swing.GroupLayout(generalP);
        generalP.setLayout(generalPLayout);
        generalPLayout.setHorizontalGroup(
            generalPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(timeL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeT, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        generalPLayout.setVerticalGroup(
            generalPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeL)
                    .addComponent(timeT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tubeP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tube", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        radiusL.setText("Radius1(mm):");

        thicknessL.setText("Thickness(mm):");

        heightL.setText("Height(mm):");

        radiusT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        radiusT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiusTActionPerformed(evt);
            }
        });

        heightT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout tubePLayout = new javax.swing.GroupLayout(tubeP);
        tubeP.setLayout(tubePLayout);
        tubePLayout.setHorizontalGroup(
            tubePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tubePLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(tubePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(heightL)
                    .addComponent(thicknessL)
                    .addComponent(radiusL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tubePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radiusT)
                    .addComponent(thicknessT)
                    .addComponent(heightT, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tubePLayout.setVerticalGroup(
            tubePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tubePLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tubePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiusL)
                    .addComponent(radiusT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tubePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thicknessL)
                    .addComponent(thicknessT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tubePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heightL)
                    .addComponent(heightT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        materialP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Material", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        mTempL.setText("Tempreture(K):");

        conductivityL.setText("Conductivity:");

        javax.swing.GroupLayout materialPLayout = new javax.swing.GroupLayout(materialP);
        materialP.setLayout(materialPLayout);
        materialPLayout.setHorizontalGroup(
            materialPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialPLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(materialPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mTempL)
                    .addComponent(conductivityL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(materialPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mTempT)
                    .addComponent(conductivityT, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        materialPLayout.setVerticalGroup(
            materialPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(materialPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mTempL)
                    .addComponent(mTempT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(materialPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conductivityL)
                    .addComponent(conductivityT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reserviorP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reservior", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        rTempL.setText("Tempreture(K):");

        rTempT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout reserviorPLayout = new javax.swing.GroupLayout(reserviorP);
        reserviorP.setLayout(reserviorPLayout);
        reserviorPLayout.setHorizontalGroup(
            reserviorPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reserviorPLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(rTempL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rTempT, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        reserviorPLayout.setVerticalGroup(
            reserviorPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reserviorPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reserviorPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rTempL)
                    .addComponent(rTempT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        start_button.setText("Start");

        cancel_button.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(materialP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tubeP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(generalP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reserviorP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(start_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel_button)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(generalP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tubeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(materialP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reserviorP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start_button)
                    .addComponent(cancel_button))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radiusTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiusTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiusTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputWindow().setVisible(true);
            }
        });
    }
    private double time;
    private double mTemp;
    private double rTemp;
    private double conductivity;
    private double radius;
    private double thickness;
    private double height;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel conductivityL;
    private javax.swing.JFormattedTextField conductivityT;
    private javax.swing.JPanel generalP;
    private javax.swing.JLabel heightL;
    private javax.swing.JFormattedTextField heightT;
    private javax.swing.JLabel mTempL;
    private javax.swing.JFormattedTextField mTempT;
    private javax.swing.JPanel materialP;
    private javax.swing.JLabel rTempL;
    private javax.swing.JFormattedTextField rTempT;
    private javax.swing.JLabel radiusL;
    private javax.swing.JFormattedTextField radiusT;
    private javax.swing.JPanel reserviorP;
    private javax.swing.JButton start_button;
    private javax.swing.JLabel thicknessL;
    private javax.swing.JFormattedTextField thicknessT;
    private javax.swing.JLabel timeL;
    private javax.swing.JFormattedTextField timeT;
    private javax.swing.JPanel tubeP;
    // End of variables declaration//GEN-END:variables
}
