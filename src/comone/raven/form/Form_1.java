package comone.raven.form;

import comone.raven.chart.ModelChart;
import java.awt.Color;
import java.util.List;
import service.impl.ThongkeViewModeliml;
import viewmodel.BieudoViewModel;
import viewmodel.ThongKenowViewModel;

public class Form_1 extends javax.swing.JPanel {

    public Form_1() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {

        //
        chart.addLegend("Doanh thu", new Color(12, 84, 175), new Color(0, 108, 247));
//        chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
//        chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
//        chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        List<BieudoViewModel> tk2018s2 = new ThongkeViewModeliml().showdoanhtu2018();
        for (BieudoViewModel bieudoViewModel : tk2018s2) {
            chart.addData(new ModelChart("2018", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
        }
        List<BieudoViewModel> tk2019s2 = new ThongkeViewModeliml().showdoanhtu2019();
        for (BieudoViewModel bieudoViewModel : tk2019s2) {
            chart.addData(new ModelChart("2019", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
        }
        List<BieudoViewModel> tk2020s2 = new ThongkeViewModeliml().showdoanhtu2020();
        List<BieudoViewModel> tktime2020s2 = new ThongkeViewModeliml().showtime2020();
        for (BieudoViewModel bieudoViewModel : tk2020s2) {
            for (BieudoViewModel thongKenowViewModel : tktime2020s2) {
                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
                chart.addData(new ModelChart(thongKenowViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
            }
        }
        //
        List<BieudoViewModel> tks2 = new ThongkeViewModeliml().showttbieudo();
        List<BieudoViewModel> tk1s2 = new ThongkeViewModeliml().showttbieudo2021();
        for (BieudoViewModel bieudoViewModel : tk1s2) {
            for (BieudoViewModel thongKenowViewModel : tks2) {
                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
                chart.addData(new ModelChart(thongKenowViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
            }
        }
        List<BieudoViewModel> tk2022s2 = new ThongkeViewModeliml().showdoanhthu2022();
        List<BieudoViewModel> tktime2022s2 = new ThongkeViewModeliml().showtime2022();
        for (BieudoViewModel bieudoViewModel : tk2022s2) {
            for (BieudoViewModel thongKenowViewModel : tktime2022s2) {
                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
                chart.addData(new ModelChart(thongKenowViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
            }
        }
//        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
//        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        chart.start();
        lineChart.addLegend("Doanh thu", new Color(12, 84, 175), new Color(0, 108, 247));
//        lineChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
//        lineChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
//        lineChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        List<BieudoViewModel> tk2018 = new ThongkeViewModeliml().showdoanhtu2018();
        for (BieudoViewModel bieudoViewModel : tk2018) {
            lineChart.addData(new ModelChart("2018", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
        }
        List<BieudoViewModel> tk2019 = new ThongkeViewModeliml().showdoanhtu2019();
        for (BieudoViewModel bieudoViewModel : tk2019) {
            lineChart.addData(new ModelChart("2019", new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
        }
        List<BieudoViewModel> tk2020 = new ThongkeViewModeliml().showdoanhtu2020();
        List<BieudoViewModel> tktime2020 = new ThongkeViewModeliml().showtime2020();
        for (BieudoViewModel bieudoViewModel : tk2020) {
            for (BieudoViewModel thongKenowViewModel : tktime2020) {
                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
                lineChart.addData(new ModelChart(thongKenowViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
            }
        }
        //
        List<BieudoViewModel> tk = new ThongkeViewModeliml().showttbieudo();
        List<BieudoViewModel> tk1 = new ThongkeViewModeliml().showttbieudo2021();
        for (BieudoViewModel bieudoViewModel : tk1) {
            for (BieudoViewModel thongKenowViewModel : tk) {
                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
                lineChart.addData(new ModelChart(thongKenowViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
            }
        }
        List<BieudoViewModel> tk2022 = new ThongkeViewModeliml().showdoanhthu2022();
        List<BieudoViewModel> tktime2022 = new ThongkeViewModeliml().showtime2022();
        for (BieudoViewModel bieudoViewModel : tk2022) {
            for (BieudoViewModel thongKenowViewModel : tktime2022) {
                //lblmoneyday2.setText(thongKenowViewModel.getTongtien() + " VNĐ");
                lineChart.addData(new ModelChart(thongKenowViewModel.getNgaytao(), new double[]{bieudoViewModel.getTongtien(), 0, 0, 0}));
            }
        }

//        lineChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        lineChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        lineChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        lineChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        lineChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        lineChart.start();
        progress1.start();
        progress2.start();
        progress3.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new comone.raven.swing.RoundPanel();
        jPanel1 = new javax.swing.JPanel();
        progress1 = new comone.raven.swing.progress.Progress();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        progress2 = new comone.raven.swing.progress.Progress();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        progress3 = new comone.raven.swing.progress.Progress();
        jLabel4 = new javax.swing.JLabel();
        roundPanel2 = new comone.raven.swing.RoundPanel();
        chart = new comone.raven.chart.Chart();
        roundPanel3 = new comone.raven.swing.RoundPanel();
        lineChart = new comone.raven.chart.LineChart();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setOpaque(false);

        progress1.setBackground(new java.awt.Color(66, 246, 84));
        progress1.setForeground(new java.awt.Color(19, 153, 32));
        progress1.setValue(60);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tổng số đã bán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(progress1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("Báo cáo doanh thu");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jPanel2.setOpaque(false);

        progress2.setBackground(new java.awt.Color(132, 66, 246));
        progress2.setForeground(new java.awt.Color(64, 18, 153));
        progress2.setValue(70);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("tổng lợi nhuận");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progress2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(progress2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setOpaque(false);

        progress3.setBackground(new java.awt.Color(66, 193, 246));
        progress3.setForeground(new java.awt.Color(26, 132, 181));
        progress3.setValue(85);

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("chi phí");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progress3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(progress3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private comone.raven.chart.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private comone.raven.chart.LineChart lineChart;
    private comone.raven.swing.progress.Progress progress1;
    private comone.raven.swing.progress.Progress progress2;
    private comone.raven.swing.progress.Progress progress3;
    private comone.raven.swing.RoundPanel roundPanel1;
    private comone.raven.swing.RoundPanel roundPanel2;
    private comone.raven.swing.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
