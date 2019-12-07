/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabungan_haji;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class Home extends javax.swing.JFrame {

    private DefaultTableModel model;
    /**
     * Creates new form Home
     */
    public Home() {
        setLocation(0, 50);
        setIcon();
        initComponents();
        this.komponen("awal");
        model();
    }
    
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconkabah.png")));
    }
    
    public void model(){
        
        model=new DefaultTableModel();
        tabel_peserta.setModel(model);
        model.addColumn("ID Jamaah");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Tempat lahir");
        model.addColumn("Tanggal lahir");
        model.addColumn("Bulan lahir");
        model.addColumn("Tahun lahir");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jenis Haji");
        model.addColumn("Batas Angsuran");
        model.addColumn("Telepon");
        
        getdata();
    }
    public void getdata(){
        try{
            Connection conn = (Connection)tabungan_haji.koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select* from data_peserta");
            
            while (data.next()){
                Object[] obj = new Object[11];
                obj[0]= data.getString("id_jamaah");
                obj[1]= data.getString("nama");
                obj[2]= data.getString("alamat");
                obj[3]= data.getString("tempatlahir");
                obj[4]= data.getString("tanggallahir");
                obj[5]= data.getString("bulanlahir");
                obj[6]= data.getString("tahunlahir");
                obj[7]= data.getString("jenis_kelamin");
                obj[8]= data.getString("jenis_haji");
                obj[9]= data.getString("batas_angsuran");
                obj[10]= data.getString("nomor_telepon");
                
                model.addRow(obj);
                
            }
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void kosongForm(){
        text_alamat.setText(null);
        text_id_jamaah.setText(null);
        text_tabungan_awal.setText("0");
        text_nama.setText(null);
        text_nomor_telepon.setText(null);
        text_tahun.setText("Tahun");
        text_tahun_awal.setText("Tahun");
        text_tempat.setText("Tempat");
        text_nama.setText(null);
        buttonGroup1.clearSelection();
        combo_bulan.setSelectedItem("Bulan");
        combo_jenis_haji.setSelectedItem("--Pilih--");
        combo_tanggal.setSelectedItem("Tanggal");
        combo_bulan_awal.setSelectedItem("Bulan");
        combo_tanggal_awal.setSelectedItem("Tanggal");
        text_batas.setText("0");
    }
    
    private void komponen(String action){
        switch(action){
            case "awal":
                bt_nabung.setEnabled(false);
                bt_edit.setEnabled(false);
                bt_hapus.setEnabled(false);
                bt_refres.setEnabled(false);
                bt_cari.setEnabled(true);
                break;
            case "cari":
                bt_simpan.setEnabled(false);
                bt_cari.setEnabled(false);
                bt_hapus.setEnabled(true);
                bt_edit.setEnabled(true);
                bt_refres.setEnabled(true);
                bt_nabung.setEnabled(true);
                text_id_jamaah.setEnabled(false);
                text_tabungan_awal.setEnabled(false);
                combo_tanggal_awal.setEnabled(false);
                combo_bulan_awal.setEnabled(false);
                text_tahun_awal.setEnabled(false);
                break;
            case "refres":
                bt_simpan.setEnabled(true);
                bt_hapus.setEnabled(false);
                bt_edit.setEnabled(false);
                bt_refres.setEnabled(false);
                bt_nabung.setEnabled(false);
                bt_cari.setEnabled(true);
                text_id_jamaah.setEnabled(true);
                text_tabungan_awal.setEnabled(true);
                combo_tanggal_awal.setEnabled(true);
                combo_bulan_awal.setEnabled(true);
                text_tahun_awal.setEnabled(true);
                break;
                
            case "simpan":
                bt_edit.setEnabled(false);
                bt_nabung.setEnabled(false);
                bt_hapus.setEnabled(false);
                break;
                
            case "klik":
                text_id_jamaah.setEnabled(false);
                bt_cari.setEnabled(false);
                bt_hapus.setEnabled(true);
                bt_refres.setEnabled(true);
                bt_simpan.setEnabled(false);
                bt_edit.setEnabled(true);
                bt_nabung.setEnabled(true);
                text_tabungan_awal.setEnabled(false);
                combo_tanggal_awal.setEnabled(false);
                combo_bulan_awal.setEnabled(false);
                text_tahun_awal.setEnabled(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        text_id_jamaah = new javax.swing.JTextField();
        text_nama = new javax.swing.JTextField();
        text_alamat = new javax.swing.JTextField();
        text_tempat = new javax.swing.JTextField();
        combo_tanggal = new javax.swing.JComboBox();
        combo_bulan = new javax.swing.JComboBox();
        text_tahun = new javax.swing.JTextField();
        RB_laki = new javax.swing.JRadioButton();
        RB_perempuan = new javax.swing.JRadioButton();
        combo_jenis_haji = new javax.swing.JComboBox();
        text_nomor_telepon = new javax.swing.JTextField();
        bt_simpan = new javax.swing.JButton();
        bt_cari = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_nabung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_peserta = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        text_tabungan_awal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        combo_tanggal_awal = new javax.swing.JComboBox();
        combo_bulan_awal = new javax.swing.JComboBox();
        text_tahun_awal = new javax.swing.JTextField();
        bt_edit = new javax.swing.JButton();
        bt_refres = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        text_batas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hajj Savings");
        setBackground(new java.awt.Color(51, 185, 1));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 18, 0));
        jLabel2.setText("Nama               ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 90, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 18, 0));
        jLabel3.setText("Alamat             ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 80, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(57, 18, 0));
        jLabel4.setText("TTL                   ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 18, 0));
        jLabel5.setText("Jenis Kelamin    ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 100, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(57, 18, 0));
        jLabel6.setText("ID Jamaah       ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 100, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(57, 18, 0));
        jLabel7.setText("Jenis Haji          ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 86, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(57, 18, 0));
        jLabel8.setText("Nomor Telepon ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 95, -1));

        text_id_jamaah.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_id_jamaah.setForeground(new java.awt.Color(57, 18, 0));
        text_id_jamaah.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(text_id_jamaah, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 110, -1));

        text_nama.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_nama.setForeground(new java.awt.Color(57, 18, 0));
        text_nama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(text_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 480, -1));

        text_alamat.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_alamat.setForeground(new java.awt.Color(57, 18, 0));
        text_alamat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        text_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_alamatActionPerformed(evt);
            }
        });
        getContentPane().add(text_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 480, -1));

        text_tempat.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_tempat.setForeground(new java.awt.Color(57, 18, 0));
        text_tempat.setText("Tempat");
        text_tempat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(text_tempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 89, -1));

        combo_tanggal.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        combo_tanggal.setForeground(new java.awt.Color(57, 18, 0));
        combo_tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tanggal", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        combo_tanggal.setToolTipText("");
        combo_tanggal.setKeySelectionManager(null);
        combo_tanggal.setLightWeightPopupEnabled(false);
        combo_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tanggalActionPerformed(evt);
            }
        });
        getContentPane().add(combo_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, 20));
        combo_tanggal.getAccessibleContext().setAccessibleName("");

        combo_bulan.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        combo_bulan.setForeground(new java.awt.Color(57, 18, 0));
        combo_bulan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        getContentPane().add(combo_bulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, 20));

        text_tahun.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_tahun.setForeground(new java.awt.Color(57, 18, 0));
        text_tahun.setText("Tahun");
        text_tahun.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(text_tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 86, -1));

        buttonGroup1.add(RB_laki);
        RB_laki.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        RB_laki.setForeground(new java.awt.Color(57, 18, 0));
        RB_laki.setText("Laki-laki");
        RB_laki.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(RB_laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        buttonGroup1.add(RB_perempuan);
        RB_perempuan.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        RB_perempuan.setForeground(new java.awt.Color(57, 18, 0));
        RB_perempuan.setText("Perempuan");
        RB_perempuan.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(RB_perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        combo_jenis_haji.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        combo_jenis_haji.setForeground(new java.awt.Color(57, 18, 0));
        combo_jenis_haji.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih--", "Reguler", "Khusus", "" }));
        getContentPane().add(combo_jenis_haji, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, 20));

        text_nomor_telepon.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_nomor_telepon.setForeground(new java.awt.Color(57, 18, 0));
        text_nomor_telepon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(text_nomor_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 200, -1));

        bt_simpan.setBackground(new java.awt.Color(255, 255, 255));
        bt_simpan.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        bt_simpan.setForeground(new java.awt.Color(57, 18, 0));
        bt_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/save_item [#1409].png"))); // NOI18N
        bt_simpan.setText("Simpan");
        bt_simpan.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(bt_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, -1, 40));

        bt_cari.setBackground(new java.awt.Color(255, 255, 255));
        bt_cari.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        bt_cari.setForeground(new java.awt.Color(57, 18, 0));
        bt_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/search_left [#1504].png"))); // NOI18N
        bt_cari.setText("Cari ID Jamaah");
        bt_cari.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });
        getContentPane().add(bt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 150, 30));

        bt_hapus.setBackground(new java.awt.Color(255, 255, 255));
        bt_hapus.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        bt_hapus.setForeground(new java.awt.Color(57, 18, 0));
        bt_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/delete [#1487].png"))); // NOI18N
        bt_hapus.setText("Hapus");
        bt_hapus.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(bt_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 100, 30));

        bt_nabung.setBackground(new java.awt.Color(255, 255, 255));
        bt_nabung.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        bt_nabung.setForeground(new java.awt.Color(57, 18, 0));
        bt_nabung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/briefcase [#807].png"))); // NOI18N
        bt_nabung.setText("Nabung");
        bt_nabung.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bt_nabung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nabungActionPerformed(evt);
            }
        });
        getContentPane().add(bt_nabung, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 360, 80, 40));

        jScrollPane1.setForeground(new java.awt.Color(78, 11, 0));

        tabel_peserta.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        tabel_peserta.setForeground(new java.awt.Color(57, 18, 0));
        tabel_peserta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "", "", "", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tabel_peserta.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tabel_peserta.setSelectionForeground(new java.awt.Color(67, 28, 0));
        tabel_peserta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pesertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_peserta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 1280, 120));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(57, 18, 0));
        jLabel10.setText("Tabungan Awal");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 100, -1));

        text_tabungan_awal.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_tabungan_awal.setForeground(new java.awt.Color(57, 18, 0));
        text_tabungan_awal.setText("0");
        text_tabungan_awal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(text_tabungan_awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 130, 161, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(57, 18, 0));
        jLabel11.setText("Tanggal");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, 83, -1));

        combo_tanggal_awal.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        combo_tanggal_awal.setForeground(new java.awt.Color(57, 18, 0));
        combo_tanggal_awal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tanggal", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(combo_tanggal_awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, -1, 20));

        combo_bulan_awal.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        combo_bulan_awal.setForeground(new java.awt.Color(57, 18, 0));
        combo_bulan_awal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        getContentPane().add(combo_bulan_awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 170, 90, 20));

        text_tahun_awal.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_tahun_awal.setForeground(new java.awt.Color(57, 18, 0));
        text_tahun_awal.setText("Tahun");
        text_tahun_awal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(text_tahun_awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 170, 70, 20));

        bt_edit.setBackground(new java.awt.Color(255, 255, 255));
        bt_edit.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        bt_edit.setForeground(new java.awt.Color(57, 18, 0));
        bt_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/edit_cover [#1481].png"))); // NOI18N
        bt_edit.setText("Ubah");
        bt_edit.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 360, 90, 40));

        bt_refres.setBackground(new java.awt.Color(255, 255, 255));
        bt_refres.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        bt_refres.setForeground(new java.awt.Color(57, 18, 0));
        bt_refres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/arrow_repeat [#235].png"))); // NOI18N
        bt_refres.setText("Segarkan");
        bt_refres.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bt_refres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refresActionPerformed(evt);
            }
        });
        getContentPane().add(bt_refres, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, -1, 30));

        bt_keluar.setBackground(new java.awt.Color(255, 255, 255));
        bt_keluar.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        bt_keluar.setForeground(new java.awt.Color(57, 18, 0));
        bt_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/EXIT.png"))); // NOI18N
        bt_keluar.setText("Kembali");
        bt_keluar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 360, 90, 40));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(57, 18, 0));
        jLabel9.setText("Total Biaya Haji");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 89, -1));

        text_batas.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        text_batas.setForeground(new java.awt.Color(57, 18, 0));
        text_batas.setText("0");
        text_batas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        text_batas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_batasActionPerformed(evt);
            }
        });
        getContentPane().add(text_batas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 190, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(78, 11, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabungan_haji/BACKGROUND_HOME.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
    // TODO add your handling code here:
        try{
            String idjamaah = text_id_jamaah.getText();
            String tabungana = text_tabungan_awal.getText();
            String nama = text_nama.getText();
            String alamat = text_alamat.getText();
            String tempat = text_tempat.getText();
            String tanggal = combo_tanggal.getSelectedItem().toString();
            String tanggala = combo_tanggal_awal.getSelectedItem().toString();
            String bulan = combo_bulan.getSelectedItem().toString();
            String bulana = combo_bulan_awal.getSelectedItem().toString();
            String tahun = text_tahun.getText();
            String tahuna = text_tahun_awal.getText();
            RB_laki.setActionCommand("Laki-laki");
            RB_perempuan.setActionCommand("Perempuan");
            String jenis_kelamin = buttonGroup1.getSelection().getActionCommand();
            String jenis_haji = combo_jenis_haji.getSelectedItem().toString();
            String batas_angsuran = text_batas.getText();
            String telepon = text_nomor_telepon.getText();
            
            
                String sql = "insert into data_peserta "
                        +"values("
                        +"'"+idjamaah+"',"
                        +"'"+nama+"',"
                        +"'"+alamat+"',"
                        +"'"+tempat+"',"
                        +"'"+tanggal+"',"
                        +"'"+bulan+"',"
                        +"'"+tahun+"',"
                        +"'"+jenis_kelamin+"',"
                        +"'"+jenis_haji+"',"
                        +"'"+batas_angsuran+"',"
                        +"'"+telepon+"'"
                        +")";
                
                
                String sql1 = "insert into rincian "
                        + "(tanggal_nabung,bulan_nabung,tahun_nabung,tabungan,id_jamaah) values ("
                        +"'"+tanggala+"', "
                        +"'"+bulana+"',"
                        +"'"+tahuna+"',"
                        +"'"+tabungana+"',"
                        +"'"+idjamaah+"'"
                        +")";
                
                
                Connection conn = (Connection)tabungan_haji.koneksi.koneksiDB();
                PreparedStatement stmt = conn.prepareStatement(sql);
                PreparedStatement stmt1 = conn.prepareStatement(sql1);
                stmt.execute();
                stmt1.execute();
                JOptionPane.showMessageDialog(null, "Data telah disimpan", "Simpan Data", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("icons8-save-48.png"));
                kosongForm();
                model();
                this.komponen("simpan");
                
            }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
            
        }            
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        // TODO add your handling code here:
        String idjamaah = text_id_jamaah.getText();
            
        try{
            String sql = "delete from rincian where id_jamaah ='"+idjamaah+"'";
            String sql1= "delete from data_peserta where id_jamaah ='"+idjamaah+"'";
                    
            Connection conn = (Connection)tabungan_haji.koneksi.koneksiDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt.execute();
            stmt1.execute();
            JOptionPane.showMessageDialog(null, "Data telah dihapus", "Hapus Data", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("icons8-trash-can-48.png"));
            kosongForm();
            model();
            this.komponen("awal");
        }catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        // TODO add your handling code here:
        String idjamaah = text_id_jamaah.getText();
        try{
            Connection conn = (Connection)tabungan_haji.koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select* from data_peserta where id_jamaah = "+idjamaah);
            if (result.next()){
                String namaResult = result.getString("nama");
                String alamatResult = result.getString("alamat");
                String tempatlahirResult = result.getString("tempatlahir");
                String tanggallahirResult = result.getString("tanggallahir");
                String bulanlahirResult = result.getString("bulanlahir");
                String tahunlahirResult = result.getString("tahunlahir");
                String jeniskelaminResult = result.getString("jenis_kelamin");
                String jenishajiResult = result.getString("jenis_haji");
                String batas_angsuran = result.getString("batas_angsuran");
                String nomorteleponResult = result.getString("nomor_telepon");
                
                text_nama.setText(namaResult);
                text_alamat.setText(alamatResult);
                text_tempat.setText(tempatlahirResult);
                combo_tanggal.getModel().setSelectedItem(tanggallahirResult);
                combo_bulan.getModel().setSelectedItem(bulanlahirResult);
                text_tahun.setText(tahunlahirResult);
               
                if (jeniskelaminResult.equals ("Laki-laki"))
                    RB_laki.setSelected(true);
                else 
                    RB_perempuan.setSelected(true);
                
                combo_jenis_haji.getModel().setSelectedItem(jenishajiResult);
                text_batas.setText(batas_angsuran);
                text_nomor_telepon.setText(nomorteleponResult);
                JOptionPane.showMessageDialog(null, "Data Jamaah "+namaResult+" ditemukan",  "Pencarian Data", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("icons8-search-48.png"));
            
                this.komponen("cari");
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Pencarian Data", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("icons8-access-denied-48.png"));
                kosongForm();
                this.komponen("refres");
            }
            
        }catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Anda belum memasukkan ID", "Pencarian Data", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("icons8-access-denied-48.png"));
    }
}                                       

    private void t_hapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cariActionPerformed

    private void bt_nabungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nabungActionPerformed
        // TODO add your handling code here:
        String id = text_id_jamaah.getText();
        String nama= text_nama.getText();
        String jenis= combo_jenis_haji.getSelectedItem().toString();
        String batas= text_batas.getText();
        new Nabung(id,nama,jenis,batas).setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_bt_nabungActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
        String idjamaah = text_id_jamaah.getText();
        String nama = text_nama.getText();
        String alamat = text_alamat.getText();
        String tempat = text_tempat.getText();
        String tanggal = combo_tanggal.getSelectedItem().toString();
        String bulan = combo_bulan.getSelectedItem().toString();
        String tahun = text_tahun.getText();
        RB_laki.setActionCommand("Laki-laki");
        RB_perempuan.setActionCommand("Perempuan");
        String jenis_kelamin = buttonGroup1.getSelection().getActionCommand();
        String jenis_haji = combo_jenis_haji.getSelectedItem().toString();
        String batas_angsuran = text_batas.getText();
        String telepon = text_nomor_telepon.getText();
        
        
        try{
            String sql = "update data_peserta set "
                    +"nama ='"+nama
                    +"',alamat ='"+alamat
                    +"',tempatlahir ='"+tempat
                    +"',tanggallahir ='"+tanggal
                    +"',bulanlahir ='"+bulan
                    +"',tahunlahir ='"+tahun
                    +"',jenis_kelamin ='"+jenis_kelamin
                    +"',jenis_haji ='"+jenis_haji
                    +"',batas_angsuran ='"+batas_angsuran
                    +"',nomor_telepon ='"+telepon
                    +"'where id_jamaah="+idjamaah;
            
            
            
            Connection conn = (Connection)tabungan_haji.koneksi.koneksiDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Data telah diubah", "Edit Data", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("icons8-save-as-48.png"));
            kosongForm();
            this.komponen("refres");
            model();
        }catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bt_editActionPerformed

    private void text_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_alamatActionPerformed

    private void bt_refresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refresActionPerformed
        // TODO add your handling code here:
        kosongForm();
        this.komponen("refres");
        
    }//GEN-LAST:event_bt_refresActionPerformed

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_keluarActionPerformed

    private void tabel_pesertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pesertaMouseClicked
        // TODO add your handling code here:
        try {
            int row = tabel_peserta.rowAtPoint(evt.getPoint());

            String id = tabel_peserta.getValueAt(row, 0).toString();
            String nama = tabel_peserta.getValueAt(row, 1).toString();
            String alamat = tabel_peserta.getValueAt(row, 2).toString();
            String tempat_lahir = tabel_peserta.getValueAt(row, 3).toString();
            String tgl_lahir = tabel_peserta.getValueAt(row, 4).toString();
            String bln_lahir = tabel_peserta.getValueAt(row, 5).toString();
            String thn_lahir = tabel_peserta.getValueAt(row, 6).toString();
            String jenis_kelamin = tabel_peserta.getValueAt(row, 7).toString();
            String jenis_haji = tabel_peserta.getValueAt(row, 8).toString();
            String batas_angsuran = tabel_peserta.getValueAt(row, 9).toString();
            String telepon = tabel_peserta.getValueAt(row, 10).toString();

            text_id_jamaah.setText(String.valueOf(id));
            text_nama.setText(String.valueOf(nama));
            text_alamat.setText(String.valueOf(alamat));
            text_tempat.setText(String.valueOf(tempat_lahir));
            combo_tanggal.getModel().setSelectedItem(String.valueOf(tgl_lahir));
            combo_bulan.getModel().setSelectedItem(String.valueOf(bln_lahir));
            text_tahun.setText(String.valueOf(thn_lahir));
            
            if (jenis_kelamin.equals ("Laki-laki"))
                    RB_laki.setSelected(true);
            else 
                    RB_perempuan.setSelected(true);
            
            combo_jenis_haji.getModel().setSelectedItem(String.valueOf(jenis_haji));
            text_batas.setText(String.valueOf(batas_angsuran));
            text_nomor_telepon.setText(String.valueOf(telepon));
            
            this.komponen("klik");

        } catch (Exception e) {
        }

    }//GEN-LAST:event_tabel_pesertaMouseClicked

    private void text_batasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_batasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_batasActionPerformed

    private void combo_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tanggalActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RB_laki;
    private javax.swing.JRadioButton RB_perempuan;
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_nabung;
    private javax.swing.JButton bt_refres;
    private javax.swing.JButton bt_simpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combo_bulan;
    private javax.swing.JComboBox combo_bulan_awal;
    private javax.swing.JComboBox combo_jenis_haji;
    private javax.swing.JComboBox combo_tanggal;
    private javax.swing.JComboBox combo_tanggal_awal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_peserta;
    private javax.swing.JTextField text_alamat;
    private javax.swing.JTextField text_batas;
    private javax.swing.JTextField text_id_jamaah;
    private javax.swing.JTextField text_nama;
    private javax.swing.JTextField text_nomor_telepon;
    private javax.swing.JTextField text_tabungan_awal;
    private javax.swing.JTextField text_tahun;
    private javax.swing.JTextField text_tahun_awal;
    private javax.swing.JTextField text_tempat;
    // End of variables declaration//GEN-END:variables
}
