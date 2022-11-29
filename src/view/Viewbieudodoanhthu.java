/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import service.impl.ThongkeViewModeliml;
import viewmodel.BieudoViewModel;

/**
 *
 * @author c
 */
public class Viewbieudodoanhthu extends javax.swing.JPanel {

    /**
     * Creates new form Viewbieudodoanhthu
     */
    public Viewbieudodoanhthu() {
        initComponents();
        setdata(jPanelmax2);
    }

    public void setdata(JPanel jpnitem) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart barcahrt = ChartFactory.createBarChart("biểu đồ", "thời gian", "số lượng", dataset, PlotOrientation.HORIZONTAL, false, true, false);
        ChartPanel chartpanel = new ChartPanel(barcahrt);
        chartpanel.setPreferredSize(new Dimension(jpnitem.getWidth(), 321));
        List<BieudoViewModel> bieudo = new ThongkeViewModeliml().showttbieudo();
        for (BieudoViewModel bieudoViewModel : bieudo) {
            dataset.addValue(bieudoViewModel.getTongtien(), "tổng tiền", bieudoViewModel.getNgaytao());
        }
        jpnitem.removeAll();
        jpnitem.setLayout(new CardLayout());
        jpnitem.add(chartpanel);
        jpnitem.validate();
        jpnitem.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelmax2 = new javax.swing.JPanel();
        jPaneltt3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanelmax2Layout = new javax.swing.GroupLayout(jPanelmax2);
        jPanelmax2.setLayout(jPanelmax2Layout);
        jPanelmax2Layout.setHorizontalGroup(
            jPanelmax2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelmax2Layout.setVerticalGroup(
            jPanelmax2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPaneltt3Layout = new javax.swing.GroupLayout(jPaneltt3);
        jPaneltt3.setLayout(jPaneltt3Layout);
        jPaneltt3Layout.setHorizontalGroup(
            jPaneltt3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
        );
        jPaneltt3Layout.setVerticalGroup(
            jPaneltt3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneltt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelmax2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelmax2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPaneltt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelmax2;
    private javax.swing.JPanel jPaneltt3;
    // End of variables declaration//GEN-END:variables
}
