
package co.edu.unicauca.mvc.vistas.postular;

import co.edu.unicauca.isii.services.ConferenciaServices;
import co.edu.unicauca.mvc.modelos.Conferencia;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thali
 */
public class panelListarConferencias extends javax.swing.JInternalFrame {

    
    private ConferenciaServices servicioConferencia;
    
    /**
     * Creates new form panelListarConferencias
     */
    public panelListarConferencias(ConferenciaServices servicioConferencia) {
        initComponents();
        this.servicioConferencia = servicioConferencia;
        iniciarlizarTabla();
        llenarTabla();
    }

    private void iniciarlizarTabla()
    {
       DefaultTableModel model= new DefaultTableModel();       
       model.addColumn("Nombre"); 
       model.addColumn("Tema");  
       model.addColumn("Fecha de inicio");
       model.addColumn("Fecha de fin");
       model.addColumn("Descripcion");
       model.addColumn("Ponentes");
       this.jTableListadoConferencias.setModel(model);
    }
    
    public void limpiarTabla(){
        
        DefaultTableModel modelo=(DefaultTableModel) this.jTableListadoConferencias.getModel();
        int filas=this.jTableListadoConferencias.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }        
    }
    
    private void llenarTabla()
    {
        DefaultTableModel model=(DefaultTableModel) this.jTableListadoConferencias.getModel();
        limpiarTabla();
        ArrayList<Conferencia> listaConferencias= (ArrayList<Conferencia>) this.servicioConferencia.listarConferencias();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       
        for (int i = 0; i < listaConferencias.size(); i++) {
            String [] fila= { listaConferencias.get(i).getNombre(), 
                listaConferencias.get(i).getTema(),
                listaConferencias.get(i).getDescripcion(),
                formatter.format(listaConferencias.get(i).getFechaInicio()),
                formatter.format(listaConferencias.get(i).getFechaFin()),
               listaConferencias.get(i).getPonente(),};
            model.addRow(fila);
        }
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListadoConferencias = new javax.swing.JTable();
        jPanelsuperior = new javax.swing.JPanel();
        jLabelListadoConferencias = new javax.swing.JLabel();
        jPanelinferior = new javax.swing.JPanel();
        jButtonActualizar = new javax.swing.JButton();

        jTableListadoConferencias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(145, 173, 180)));
        jTableListadoConferencias.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jTableListadoConferencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", ""
            }
        ));
        jScrollPane1.setViewportView(jTableListadoConferencias);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelListadoConferencias.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabelListadoConferencias.setForeground(new java.awt.Color(102, 102, 102));
        jLabelListadoConferencias.setText("Listado conferencias");

        javax.swing.GroupLayout jPanelsuperiorLayout = new javax.swing.GroupLayout(jPanelsuperior);
        jPanelsuperior.setLayout(jPanelsuperiorLayout);
        jPanelsuperiorLayout.setHorizontalGroup(
            jPanelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelsuperiorLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabelListadoConferencias)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelsuperiorLayout.setVerticalGroup(
            jPanelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelsuperiorLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelListadoConferencias)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jButtonActualizar.setBackground(new java.awt.Color(145, 173, 180));
        jButtonActualizar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelinferiorLayout = new javax.swing.GroupLayout(jPanelinferior);
        jPanelinferior.setLayout(jPanelinferiorLayout);
        jPanelinferiorLayout.setHorizontalGroup(
            jPanelinferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinferiorLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelinferiorLayout.setVerticalGroup(
            jPanelinferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonActualizar)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelsuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelinferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelinferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_jButtonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabelListadoConferencias;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelinferior;
    private javax.swing.JPanel jPanelsuperior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListadoConferencias;
    // End of variables declaration//GEN-END:variables
}
