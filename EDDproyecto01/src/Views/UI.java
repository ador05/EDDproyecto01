package Views;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.util.mxConstants;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import disconnectedgraph.FileHandling;
import disconnectedgraph.Graph;
import disconnectedgraph.Lista;
import disconnectedgraph.Nodo;
import javax.swing.JFrame;
import javax.swing.SwingConstants;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author mariavictoriadasilva
 */
public class UI extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    public static Graph graph;
    public static File selectedFile;
    private boolean flag;

    public UI() {
        graph = new Graph();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cargarArchivoB = new javax.swing.JButton();
        modifyTXT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Isla_BFS = new javax.swing.JButton();
        Isla_DFS = new javax.swing.JButton();
        Puentes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargarArchivoB.setText("Cargar Archivo");
        cargarArchivoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoBActionPerformed(evt);
            }
        });
        jPanel1.add(cargarArchivoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        modifyTXT.setText("Modificar TXT");
        modifyTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyTXTActionPerformed(evt);
            }
        });
        jPanel1.add(modifyTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        jLabel1.setText("BIENVENIDO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel2.setText("Recuerda cargar un archivo si deseas realizar alguna operación");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        jButton1.setText("Mostrar Grafo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        Isla_BFS.setText("Islas por BFS");
        Isla_BFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Isla_BFSActionPerformed(evt);
            }
        });
        jPanel1.add(Isla_BFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, -1));

        Isla_DFS.setText("Islas por DFS");
        Isla_DFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Isla_DFSActionPerformed(evt);
            }
        });
        jPanel1.add(Isla_DFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 110, -1));

        Puentes.setText("Puentes");
        Puentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuentesActionPerformed(evt);
            }
        });
        jPanel1.add(Puentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarArchivoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoBActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getPath();
            FileHandling.readFile(selectedFile, graph);
//                    System.out.println("Selected file path: " + filePath);
            flag = true;

            JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente!");
        }


    }//GEN-LAST:event_cargarArchivoBActionPerformed

    private void modifyTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyTXTActionPerformed
        // TODO add your handling code here:
        UI_02 ui2 = new UI_02();
        if (flag) {
            ui2.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: El sistema requiere que cargue un archivo antes de realizar cualquier operación");
        }
//        dispose();
    }//GEN-LAST:event_modifyTXTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Create the JGraphX graph object
        if (flag) {
            mxGraph mxGraph = new mxGraph();
            Object parent = mxGraph.getDefaultParent();

            // Add vertices to the graph
            int numVertices = UI.graph.getVertices().size();
            Object[] vertices = new Object[numVertices];
            Nodo aux = graph.getVertices().getpFirst();
            for (int i = 0; i < numVertices; i++) {
                String[] array = (String[]) aux.getInfo();
                String vertex = array[0];
                vertices[i] = mxGraph.insertVertex(parent, null, vertex, 20 + (i * 60), 20 + (i * 60), 40, 40);
                aux = aux.getpNext();
            }

            // Add edges to the graph
            for (int i = 0; i < numVertices; i++) {
                for (int j = i + 1; j < numVertices; j++) {
                    if (graph.getMatrix()[i][j] != null) {
                        Object edge = mxGraph.insertEdge(parent, null, graph.getMatrix()[i][j], vertices[i], vertices[j]);
                        mxGraph.getModel().setStyle(edge, mxConstants.STYLE_ENDARROW + "=" + mxConstants.NONE + ";" + mxConstants.STYLE_VERTICAL_ALIGN + "=" + mxConstants.ALIGN_TOP);
                    }
                }
            }

            // Apply a layout to the graph
            mxHierarchicalLayout layout = new mxHierarchicalLayout(mxGraph);
            layout.setOrientation(SwingConstants.WEST);
            layout.execute(parent);

            // Display the graph in a JFrame
            JFrame frame = new JFrame("Graph Visualization");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mxGraphComponent graphComponent = new mxGraphComponent(mxGraph);
            frame.getContentPane().add(graphComponent);
            frame.pack();
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: El sistema requiere que cargue un archivo antes de realizar cualquier operación");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void Isla_BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Isla_BFSActionPerformed
        if (flag) {
            int islasBFS = graph.calcularIslasBFS();
            JOptionPane.showMessageDialog(null, "Islas halladas por BFS: " + islasBFS);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: El sistema requiere que cargue un archivo antes de realizar cualquier operación");
        }
    }//GEN-LAST:event_Isla_BFSActionPerformed

    private void Isla_DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Isla_DFSActionPerformed
        if (flag) {
            int islasDFS = graph.calcularIslasDFS();
            JOptionPane.showMessageDialog(null, "Islas halladas por DFS: " + islasDFS);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: El sistema requiere que cargue un archivo antes de realizar cualquier operación");
        }
    }//GEN-LAST:event_Isla_DFSActionPerformed

    private void PuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuentesActionPerformed
        // TODO add your handling code here:
        puentes_UI puentes = new puentes_UI();
        if(flag){
        puentes.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "ERROR: El sistema requiere que cargue un archivo antes de realizar cualquier operación");
        }
    }//GEN-LAST:event_PuentesActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Isla_BFS;
    private javax.swing.JButton Isla_DFS;
    private javax.swing.JButton Puentes;
    private javax.swing.JButton cargarArchivoB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modifyTXT;
    // End of variables declaration//GEN-END:variables
}