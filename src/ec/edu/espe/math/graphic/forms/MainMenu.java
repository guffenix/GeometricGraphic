/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.math.graphic.forms;

import ec.edu.espe.math.geometry.solids.circunferences.Sphere;
import ec.edu.espe.math.graphic.forms.constant.ShapeCatalog;
import ec.edu.espe.math.graphic.forms.conversion.ConversionForm;
import ec.edu.espe.math.graphic.forms.shapes2d.CircleShape;
import ec.edu.espe.math.graphic.forms.shapes2d.SquareShape;
import ec.edu.espe.math.graphic.forms.shapes3d.SphereShape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ButtonGroup;

/**
 *
 * @author Cazaesclavas
 */
public class MainMenu extends javax.swing.JFrame {

    ShapeCatalog shapes = new ShapeCatalog();
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        shapeSelect();
    }
    
    public void initShapes2D(){
        
        Map<String,String> circunference = new HashMap<String,String>();
        circunference.put(shapes.CIRCLE,shapes.CICUNFERENCES);
        circunference.put(shapes.ELLIPSE,shapes.CICUNFERENCES);
        
        Map<String,String>quadrilaterals = new HashMap<String,String>();
        quadrilaterals.put(shapes.RECTANLE,shapes.QUADRILATERALS);
        quadrilaterals.put(shapes.RHOMBUS,shapes.QUADRILATERALS);
        quadrilaterals.put(shapes.ROMBOIDE,shapes.QUADRILATERALS);
        quadrilaterals.put(shapes.SQUARE,shapes.QUADRILATERALS);
        quadrilaterals.put(shapes.PARALLELOGRAM,shapes.QUADRILATERALS);
        
        Map<String,String> triangles = new HashMap<String,String>();
        triangles.put(shapes.EQUILATERAL_TRIANGLE,shapes.TRIANGLES);
        triangles.put(shapes.OBTUSE_ANGLE_TRIANGLE,shapes.TRIANGLES);
        triangles.put(shapes.RIGTH_ANGLE_TRIANGLE,shapes.TRIANGLES);
        triangles.put(shapes.SCALENE_TRIANGLE,shapes.TRIANGLES);
        
        Map<String,Map> shape2d = new HashMap<String,Map>();
        shape2d.put(shapes.CICUNFERENCES, circunference);
        shape2d.put(shapes.QUADRILATERALS, quadrilaterals);
        shape2d.put(shapes.TRIANGLES, triangles);
              
        comboShape.removeAllItems();
        comboShape.addItem("(none)");
        comboShape.addItem(shapes.CICUNFERENCES);
        comboShape.addItem(shapes.QUADRILATERALS);
        comboShape.addItem(shapes.TRIANGLES);
        
        comboShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String search = comboShape.getSelectedItem().toString();
                    if (shape2d.containsKey(search)) {
                        System.out.println(shape2d.get(search));
                        Map mapSearch = shape2d.get(search);
                        Iterator it = mapSearch.entrySet().iterator();
                        comboShapeOption.removeAllItems();
                        while (it.hasNext()) {
                                Map.Entry itemMap = (Map.Entry)it.next();
                                comboShapeOption.addItem(itemMap.getKey());
                                System.out.println(itemMap.getKey() + " " + itemMap.getValue());
                        }
                        comboShapeOption.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String search = comboShapeOption.getSelectedItem().toString();
                                System.out.println(search);
                                formSelect(search);
 
                            }catch(Exception er){}

                        }
                    });

                    }
                }catch(Exception er){}
                
            }
        });


        
//        initBox(shape2d);
    }
    public void initShapes3D(){
        
        Map<String,String> solids = new HashMap<String,String>();
        solids.put(shapes.CONE,shapes.SOLIDS);
        solids.put(shapes.CUBE,shapes.SOLIDS);
        solids.put(shapes.CYLINDER,shapes.SOLIDS);
        solids.put(shapes.FRUSTUM,shapes.SOLIDS);
        solids.put(shapes.SPHERE,shapes.SOLIDS);
        
        Map<String,Map> shape3d = new HashMap<String,Map>();
        shape3d.put(shapes.SOLIDS, solids);
        comboShape.removeAllItems();
        comboShape.addItem("(none)");
        comboShape.addItem(shapes.SOLIDS);
        
        comboShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    String search = comboShape.getSelectedItem().toString();
                if (shape3d.containsKey(search)) {
                    System.out.println(shape3d.get(search));
                    Map mapSearch = shape3d.get(search);
                    Iterator it = mapSearch.entrySet().iterator();
                    comboShapeOption.removeAllItems();
                    while (it.hasNext()) {
                            Map.Entry itemMap = (Map.Entry)it.next();
                            comboShapeOption.addItem(itemMap.getKey());
                            System.out.println(itemMap.getKey() + " " + itemMap.getValue());
                    }
                    comboShapeOption.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String search = comboShapeOption.getSelectedItem().toString();
                                System.out.println(search);
                                formSelect(search);
 
                            }catch(Exception er){}

                        }
                    });
                    
                }
                } catch (Exception er) {
                }
                
                
            }
        });

    }
    
    public void shapeSelect(){
        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(shape2dRadioButton);
        shapeGroup.add(shape3dRadioButton);
           
    }
    
    public void formSelect(String search){
        switch (search) {
            case "Circle":
                CircleShape c = new CircleShape(shapes.CIRCLE);
                c.setLocationRelativeTo(null);
                c.setVisible(true);
                break;
            case "Ellipse":
                System.out.println("frm2");
                break;
            case "Square":
                SquareShape s = new SquareShape(shapes.SQUARE);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                break;
            case "Sphere":
                SphereShape sp = new SphereShape(shapes.SPHERE);
                sp.setLocationRelativeTo(null);
                sp.setVisible(true);
                break;
            
            default:
                System.out.println("Número no reconocido");
                break;
        }
    }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        comboShape = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        shape3dSelect = new javax.swing.JLabel();
        shape2dSelect = new javax.swing.JLabel();
        comboShapeOption = new javax.swing.JComboBox();
        shape2dRadioButton = new javax.swing.JRadioButton();
        shape3dRadioButton = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        conversionButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(85, 96, 128));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 350));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/math/graphic/images/logoGeometry.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(38, 185, 154));
        jSeparator1.setForeground(new java.awt.Color(38, 185, 154));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        comboShape.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(none)" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(38, 185, 154));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Select Shape");

        shape3dSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/math/graphic/images/modeling.png"))); // NOI18N
        shape3dSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shape3dSelectMouseClicked(evt);
            }
        });

        shape2dSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/math/graphic/images/square.png"))); // NOI18N
        shape2dSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shape2dSelectMouseClicked(evt);
            }
        });

        comboShapeOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(none)" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(38, 185, 154));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("2D Shape");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(38, 185, 154));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("3D Shape");

        conversionButton.setText("Conversion");
        conversionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conversionButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(38, 185, 154));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Conversion (New)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(conversionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboShape, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboShapeOption, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(shape2dRadioButton)
                                    .addGap(9, 9, 9)
                                    .addComponent(shape2dSelect)))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(shape3dRadioButton)
                                    .addGap(8, 8, 8)
                                    .addComponent(shape3dSelect))
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shape2dSelect)
                    .addComponent(shape3dSelect)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shape2dRadioButton)
                            .addComponent(shape3dRadioButton))))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(comboShape, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboShapeOption, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conversionButton)
                    .addComponent(jLabel11))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shape2dSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shape2dSelectMouseClicked
        shape2dRadioButton.setSelected(true);
        //shape3dRadioButton.setSelected(false);
        initShapes2D();
    }//GEN-LAST:event_shape2dSelectMouseClicked

    private void shape3dSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shape3dSelectMouseClicked
        //shape2dRadioButton.setSelected(false);
        shape3dRadioButton.setSelected(true);
        initShapes3D();
    }//GEN-LAST:event_shape3dSelectMouseClicked

    private void conversionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conversionButtonActionPerformed
        ConversionForm cfrm = new ConversionForm("Section Conversion");
        cfrm.setLocationRelativeTo(null);
        cfrm.setVisible(true);
                
    }//GEN-LAST:event_conversionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboShape;
    private javax.swing.JComboBox comboShapeOption;
    private javax.swing.JButton conversionButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton shape2dRadioButton;
    private javax.swing.JLabel shape2dSelect;
    private javax.swing.JRadioButton shape3dRadioButton;
    private javax.swing.JLabel shape3dSelect;
    // End of variables declaration//GEN-END:variables
}
