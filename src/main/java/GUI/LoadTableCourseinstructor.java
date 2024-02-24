/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.courseBLL;
import BLL.courseinstructorBLL;
import BLL.personBLL;
import DTO.courseDTO;
import DTO.courseinstructorDTO;
import DTO.personDTO;
import GUI.quanLyPhanCong;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Admin
 */
public class LoadTableCourseinstructor {
    JTable table;
    quanLyPhanCong ql;
    private JPanel jpnView;
    private JButton btnsave,btnremove,btnstatis;
    private JTextField jtfTim;
    private courseinstructorBLL courseinstructorbll=new courseinstructorBLL();
    private personBLL personbll=new personBLL();
    private List<personDTO> listps = personbll.selectAll();
    private courseBLL coursebll=new courseBLL();
    private String[] listColumn = {"CouseID","Title", "Credits","Departments","PersonID","FirstName"};
    private TableRowSorter<TableModel> rowSorter = null;

    public LoadTableCourseinstructor(JPanel jpnView, JButton btnsave, JTextField jtfTim,JButton btnremove,JButton btnstatis,quanLyPhanCong ql){
        this.jpnView = jpnView;
        this.btnsave = btnsave;
        this.jtfTim = jtfTim;
        this.btnremove=btnremove;
        this.btnstatis=btnstatis;
        this.ql=ql;
    }
    public java.sql.Date cover(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }
    public void setDateToTable(){
        List<courseDTO> listcourse = coursebll.selectAll();
        List<courseinstructorDTO> listcourseinstructor = courseinstructorbll.selectAll();
        
        DefaultTableModel model = new TableCourseinstructor().setTableKH(listcourse,listcourseinstructor, listColumn);
        table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfTim.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfTim.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfTim.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        //chỉnh bảng
        table.setRowHeight(40);
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
//        CenterRenderer centerRendererRow = new CenterRenderer();
//
//        
//        table.getColumnModel().getColumn(0).setCellRenderer(centerRendererRow);
//        table.getColumnModel().getColumn(1).setCellRenderer(centerRendererRow);
//        table.getColumnModel().getColumn(2).setCellRenderer(centerRendererRow);
//        table.getColumnModel().getColumn(3).setCellRenderer(centerRendererRow);
//        table.getColumnModel().getColumn(4).setCellRenderer(centerRendererRow);
//        table.getColumnModel().getColumn(5).setCellRenderer(centerRendererRow);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int SRow = table.getSelectedRow();                       //Lay Index dong duoc chon
                    SRow = table.convertRowIndexToModel(SRow);     //Khi sap xep, Index dong duoc chon van dung                   
                    
                    ql.getJtfCourseID().setText( model.getValueAt(SRow, 0).toString());
                    ql.getJtfTitle().setText(model.getValueAt(SRow,1).toString());
                    ql.getJtfCredits().setText(model.getValueAt(SRow,2).toString());
                    ql.getJtfDepartment().setText(model.getValueAt(SRow,3).toString());
                    ql.getJboxPersonID().removeAllItems();
                    ql.getJboxPersonID().addItem("null");
                    for(personDTO ps: listps){
                        if(ps.getHireDate()!=null)
                        ql.getJboxPersonID().addItem(""+ps.getPersonID());
                    }
                    if(model.getValueAt(SRow, 4) != null)
                        ql.getJboxPersonID().setSelectedItem(model.getValueAt(SRow, 4).toString());

                    
                    
                }
            }
            
        });
        //chỉnh tiêu đề
       JTableHeader header = table.getTableHeader();
       header.setFont(new Font("Tahoma", Font.BOLD, 14));
       header.setPreferredSize(new Dimension(50, 50));
       // Căn giữa tiêu đề theo chiều dọc
       DefaultTableCellRenderer centerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
       centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(800,400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
        }
//    public void setEvent(){
//        btnThem.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                GUI_ThemThongTinNhanVien frame =new GUI_ThemThongTinNhanVien(QuanLyNhanVienController.this);
//                frame.setTitle("Thông tin nhân viên thêm");
//                frame.setLocationRelativeTo(null);
//                frame.setResizable(false);
//                frame.setVisible(true);
//                
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnThem.setBackground(new Color(255,143,246));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnThem.setBackground(new Color(255,204,255));
//            }
//            
//        });

    public JTable getTable() {
        return table;
    }
    
    
}
