/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shoeStore.main;

import com.shoeStore.component.CpnItem;
import com.shoeStore.model.Category;
import com.shoeStore.model.Shoe;
import com.shoeStore.service.CategoryService;
import com.shoeStore.service.ShoeService;
import com.shoeStore.swing.WrapLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {
    private JPanel panelContainer;
    private JPanel panelContainerCate;
    private ShoeService shoeService;
    private CategoryService categoryService;
    private JScrollPane ScrollPane;
    private JLabel lbCate;
    List<Shoe> shoes;
    List<Category> categorys;
    private CpnItem cpnItem ;
    public Main() {
        myInitComponents();
        this.setLocationRelativeTo(null);
        setView();
    }
    public void initCate(){
        // hiển thị danh sách các loại giày trong filter
        
        panelContainerCate = new JPanel();
        panelContainerCate.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        categoryService = new CategoryService();
        categorys = categoryService.getAllCategory();
        for(Category cate : categorys){
            lbCate = new JLabel();
            lbCate.setText(cate.getCname());
            lbCate.setFont(new Font("SansSerif", Font.BOLD, 14));
            lbCate.setCursor(new Cursor(Cursor.HAND_CURSOR));
            //log ra tên cate khi click vào
            lbCate.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent me){
                    if(SwingUtilities.isLeftMouseButton(me)){
                        shoes = shoeService.getProductFromCate(cate.getCid());
                        System.out.println(shoes);
                        panelContainer.removeAll();
                        for(Shoe shoe : shoes){
                            initItem(shoe);
                        }
                        panelContainer.revalidate();
                        panelContainer.repaint();
                    }
                }
            });
            panelContainerCate.add(lbCate);
            panelContainerCate.setBackground(Color.WHITE);
            // Kiểm tra nếu component đã được thêm vào thành công
//            boolean isAdded = panelContainer.isAncestorOf(jLabel);
//            if (isAdded) {
//                System.out.println("Component đã được thêm thành công!");
//            } else {
//                System.out.println("Component chưa được thêm vào.");
//            }
        }
        ScrollPane = new JScrollPane();
        ScrollPane.setViewportView(panelContainerCate);
        ScrollPane.setBorder(null);
        jpCate.add(ScrollPane);
    }
    public void initItem(Shoe shoe){
        cpnItem = new CpnItem();
        cpnItem.setData(shoe);
        cpnItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    setData(shoe);
                }
            }
        });
        panelContainer.add(cpnItem);
    }
    private void setView(){
        panelContainer = new JPanel();
        panelContainer.setLayout(new WrapLayout(FlowLayout.LEFT));
        panelContainer.setBackground(Color.WHITE);
        shoeService = new ShoeService();
        shoes = shoeService.getAllShoes();
        for(Shoe shoe : shoes){
            initItem(shoe);
        }
        scroll.setViewportView(panelContainer);
        scroll.setBorder(null);
        //hien thi danh sach cac category
        initCate();
    }
    private Shoe shoe;
    private void setData(Shoe shoe){
        this.shoe = shoe;
        shoeService = new ShoeService();
        lbItemName.setText(shoe.getName());
        ImageIcon imageIcon = shoeService.fitSize(shoe,lbPic);
        lbPic.setIcon(imageIcon);
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        lbPrice.setText(df.format(shoe.getPrice()));
        // lấy ra tên của cate thông qua cateID
        String cateName = shoeService.getCateFromProduct(shoe);
        lbBrand.setText(cateName);
        txtDescription.setText(shoe.getDescription());
        lbTotal.setText(df.format(shoe.getPrice()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMain = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        jSideBar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbItemName = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbPic = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPlus = new javax.swing.JButton();
        lbQuantity = new javax.swing.JLabel();
        btnMinus = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        btnAddCart = new javax.swing.JButton();
        jHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnCart = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jFill = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jpCate = new javax.swing.JPanel();
        btnAll = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jMain.setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSideBar.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setText("Item Name");

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setText("$0.00");

        lbBrand.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand.setText("Brand");

        lbPic.setPreferredSize(new java.awt.Dimension(200, 150));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtDescription.setBorder(null);
        txtDescription.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(178, 178, 178));
        txtDescription.setFocusable(false);
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Tổng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số lượng");

        btnPlus.setText("+");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        lbQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuantity.setText("1");

        btnMinus.setText("-");
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(76, 76, 76));
        lbTotal.setText("$0.00");

        btnAddCart.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnAddCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoeStore/icons/cart_icon_20.png"))); // NOI18N
        btnAddCart.setText("Thêm vào giỏ hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbPrice)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMinus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPlus)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTotal)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnAddCart)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPic, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBrand)
                    .addComponent(lbPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnPlus)
                    .addComponent(lbQuantity)
                    .addComponent(btnMinus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddCart)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jSideBarLayout = new javax.swing.GroupLayout(jSideBar);
        jSideBar.setLayout(jSideBarLayout);
        jSideBarLayout.setHorizontalGroup(
            jSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSideBarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jSideBarLayout.setVerticalGroup(
            jSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoeStore/image/logo_shop_small.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Rage Italic", 2, 12)); // NOI18N
        jLabel2.setText("Shoe Shop");

        btnReset.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoeStore/icons/reset_icon_24.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCart.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoeStore/icons/cart_icon_20.png"))); // NOI18N
        btnCart.setText("Giỏ hàng");

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoeStore/icons/search_icon.png"))); // NOI18N
        jButton2.setText("Tìm kiếm");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel7.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        jLabel7.setText("Hello");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("MyName");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoeStore/icons/logout_icon.png"))); // NOI18N
        jButton1.setText("Đăng xuất");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jHeaderLayout = new javax.swing.GroupLayout(jHeader);
        jHeader.setLayout(jHeaderLayout);
        jHeaderLayout.setHorizontalGroup(
            jHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jHeaderLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(241, 241, 241))
                    .addGroup(jHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addContainerGap())))
        );
        jHeaderLayout.setVerticalGroup(
            jHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jHeaderLayout.createSequentialGroup()
                .addGroup(jHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jHeaderLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCart, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jFill.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/shoeStore/icons/filter_icon_20.png"))); // NOI18N

        jpCate.setBackground(new java.awt.Color(255, 255, 255));
        jpCate.setLayout(new java.awt.BorderLayout());

        btnAll.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAll.setText("ALL");
        btnAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAllMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jFillLayout = new javax.swing.GroupLayout(jFill);
        jFill.setLayout(jFillLayout);
        jFillLayout.setHorizontalGroup(
            jFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFillLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFillLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jpCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFillLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAll)))
                .addContainerGap())
        );
        jFillLayout.setVerticalGroup(
            jFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFillLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFillLayout.createSequentialGroup()
                        .addGroup(jFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAll)
                            .addComponent(jpCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout jMainLayout = new javax.swing.GroupLayout(jMain);
        jMain.setLayout(jMainLayout);
        jMainLayout.setHorizontalGroup(
            jMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainLayout.createSequentialGroup()
                .addComponent(jSideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jMainLayout.createSequentialGroup()
                        .addComponent(jFill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jMainLayout.setVerticalGroup(
            jMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainLayout.createSequentialGroup()
                .addComponent(jHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jMainLayout.createSequentialGroup()
                        .addComponent(jFill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        if(this.shoe == null ){
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 sản phẩm!");
            return;
        }
        if(getQuantity()<=1){
            JOptionPane.showMessageDialog(this, "Bạn cần chọn nhiều hơn 1!");
        }else{
            setQuantity(--quantity);
            lbQuantity.setText(String.valueOf(getQuantity()));
            total = total();
            lbTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        if(this.shoe == null ){
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 sản phẩm!");
            return;
        }
        setQuantity(++quantity);
        lbQuantity.setText(String.valueOf(getQuantity()));
        total = total();
        lbTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        shoes = shoeService.getAllShoes();
        categorys = categoryService.getAllCategory();
        panelContainer.removeAll();
        jpCate.removeAll();
        for(Shoe shoe : shoes){
            initItem(shoe);
        }
        for(Category cate : categorys){
            System.out.println(cate.getCname());
        }
        initCate();
        panelContainer.revalidate();
        panelContainer.repaint();
        jpCate.revalidate();
        jpCate.repaint();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAllMouseClicked
        shoes = shoeService.getAllShoes();
        panelContainer.removeAll();
        for(Shoe shoe : shoes){
            initItem(shoe);
        }
        panelContainer.revalidate();
        panelContainer.repaint();
    }//GEN-LAST:event_btnAllMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private double total(){
        return shoe.getPrice()*getQuantity();   
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    //main
    public static void main(String args[]) {
       
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    private int quantity = 1;
    private double total ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JLabel btnAll;
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jFill;
    private javax.swing.JPanel jHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jMain;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jSideBar;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel jpCate;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPic;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextPane txtDescription;
    // End of variables declaration//GEN-END:variables

    private void myInitComponents() {
        initComponents();
        jScrollPane1.setBorder(null);
    }
}
