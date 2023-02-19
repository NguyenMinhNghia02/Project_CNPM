package views;

import controllers.MuonTraPanelController;
import services.MuonTraService;
import services.PhongBanService;
import services.StringService;
import services.TimeService;
import views.MuonTraFrame.DangKySuDungFrame;
import views.MuonTraFrame.XemChiTietMuonTraFrame;
import views.PhongBanFrame.DoiTenPhongBanFrame;

import javax.swing.JFrame;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;

import javax.swing.JPopupMenu;

/**
 *
 * @author Hai
 */
public class MuonTraPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhanKhauManagePanel
     */
    private MuonTraPanelController controller = null;
    private JFrame parentJFrame;
    
    public MuonTraPanel(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        timeService = new TimeService();
        initComponents();
      controller = new MuonTraPanelController(tablePanel, nguoiMuonJtfSearch, lienheJtfSearch, tuNgayJdc, denNgayJdc, popupMenu);
        

        GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
        gl_tablePanel.setHorizontalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 566, Short.MAX_VALUE)
        );
        gl_tablePanel.setVerticalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 211, Short.MAX_VALUE)
        );
        tablePanel.setLayout(gl_tablePanel);
        controller.setParentJFrame(parentJFrame);
        controller.setDataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        tablePanel = new javax.swing.JPanel();
        
        popupMenu = new JPopupMenu();
        addPopup(tablePanel, popupMenu);
        
        xemChiTiet = new JMenuItem("Xem chi tiết");
        popupMenu.add(xemChiTiet);
        xemChiTiet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				xemChiTietActionPerformed(evt);
			}

		});
        
        hoanTra = new JMenuItem("Hoàn trả toàn bộ");
        popupMenu.add(hoanTra);
        hoanTra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				hoanTraActionPerformed(evt);
			}

		});
        
        huyMuon = new JMenuItem("Huỷ mượn");
        popupMenu.add(huyMuon);
        huyMuon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				huyMuonActionPerformed(evt);
			}

		});
        
        
        addNewBtn = new javax.swing.JButton();
        addNewBtn.setBorder(null);
        addNewBtn.setIcon(new ImageIcon(MuonTraPanel.class.getResource("/Icons/add.png")));
        nguoiMuonJtfSearch = new javax.swing.JTextField();

        setBackground(Color.WHITE);

        addNewBtn.setBackground(new java.awt.Color(255, 255, 255));
        addNewBtn.setFont(new java.awt.Font("Arial", 1, 14));
        addNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtnActionPerformed(evt);
            }
        });

        nguoiMuonJtfSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        
        JLabel lblNewLabel = new JLabel("Người mượn:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblNewLabel_1 = new JLabel("Liên hệ:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        lienheJtfSearch = new JTextField();
        lienheJtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lienheJtfSearch.setColumns(10);
        
        JPanel SearchTImepanel = new JPanel();
        SearchTImepanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        SearchTImepanel.setBackground(Color.WHITE);
        
        filterJButton = new JButton("Lọc");
        filterJButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
                filterJButton.setBackground(new Color(12, 122, 10));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
                filterJButton.setBackground(new Color(28, 155, 26));
        	}
        	
        	@Override
        	public void mouseReleased(MouseEvent e) {
                filterJButton.setBackground(new Color(12, 122, 10));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
                filterJButton.setBackground(new Color(28, 155, 26));
        	}
        });
        filterJButton.setBorder(null);
        filterJButton.setAlignmentY(Component.TOP_ALIGNMENT);
        filterJButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		jtfSearchActionPerformed(evt);
        	}
        });
        filterJButton.setForeground(Color.WHITE);
        filterJButton.setBackground(new Color(28, 155, 26));
        filterJButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(tablePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(10)
        							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(nguoiMuonJtfSearch, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        							.addGap(26)
        							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lienheJtfSearch, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(SearchTImepanel, GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
        							.addGap(27)
        							.addComponent(filterJButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
        					.addGap(21)
        					.addComponent(addNewBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(9)
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lienheJtfSearch, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(2)
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(nguoiMuonJtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(9)
        							.addComponent(SearchTImepanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGap(8))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(filterJButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(47)
        					.addComponent(addNewBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
        			.addGap(0)
        			.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(75))
        );
        
        timeJLabel = new JLabel("Thời gian mượn:");
        timeJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        tuNgayJlb = new JLabel("Từ:");
        tuNgayJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        denNgayJlb = new JLabel("Đến:");
        denNgayJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        tuNgayJdc = new JDateChooser();
        tuNgayJdc.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 14));
        tuNgayJdc.setDate(timeService.changeDateFromNow(0, -1, 0));
        
        denNgayJdc = new JDateChooser();
        denNgayJdc.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 14));
        denNgayJdc.setDate(timeService.changeDateFromNow(0, 1, 0));
        GroupLayout gl_SearchTImepanel = new GroupLayout(SearchTImepanel);
        gl_SearchTImepanel.setHorizontalGroup(
        	gl_SearchTImepanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_SearchTImepanel.createSequentialGroup()
        			.addGap(6)
        			.addComponent(timeJLabel, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tuNgayJlb)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tuNgayJdc, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(denNgayJlb)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(denNgayJdc, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        			.addGap(12))
        );
        gl_SearchTImepanel.setVerticalGroup(
        	gl_SearchTImepanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_SearchTImepanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_SearchTImepanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(denNgayJdc, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(denNgayJlb, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        				.addComponent(tuNgayJdc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_SearchTImepanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(timeJLabel, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        					.addComponent(tuNgayJlb, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        SearchTImepanel.setLayout(gl_SearchTImepanel);
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	DangKySuDungFrame themDangKySuDungCoSoVatChatFrame = new DangKySuDungFrame(this.controller, this.parentJFrame);
    	themDangKySuDungCoSoVatChatFrame.setLocationRelativeTo(null);
    	themDangKySuDungCoSoVatChatFrame.setResizable(false);
    	themDangKySuDungCoSoVatChatFrame.setVisible(true);
    }//GEN-LAST:event_addNewBtnActionPerformed

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
    	String tenNguoiMuon = StringService.covertToString(nguoiMuonJtfSearch.getText());
    	String lienHe = StringService.covertToString(lienheJtfSearch.getText());
    	Timestamp tuNgay = timeService.convertDateToTimestamp(tuNgayJdc.getDate());
    	Timestamp denNgay = timeService.convertDateToTimestamp(denNgayJdc.getDate());
    	System.out.println(tuNgay);
    	controller.setData(tenNguoiMuon, lienHe, tuNgay, denNgay);
    }//GEN-LAST:event_jtfSearchActionPerformed

    private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
    
	private void xemChiTietActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JTable xemChiTietTable = this.controller.getTable();
		int row = xemChiTietTable.getSelectedRow();
		if(row == -1) {
    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
  			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
  		return;
		}
		String tenNguoiMuonDetail = xemChiTietTable.getModel().getValueAt(row, 2).toString();
		String idDetail = xemChiTietTable.getModel().getValueAt(row, 7).toString();
		String lienHeDetail = xemChiTietTable.getModel().getValueAt(row, 4).toString();
		String thoiGianMuonDetail = xemChiTietTable.getModel().getValueAt(row, 5).toString();
		String thoiGianTraDetail = xemChiTietTable.getModel().getValueAt(row, 6).toString();
		XemChiTietMuonTraFrame xemChiTietMuonTraFrame = new XemChiTietMuonTraFrame(this.controller, this.parentJFrame, tenNguoiMuonDetail, idDetail, lienHeDetail, thoiGianMuonDetail, thoiGianTraDetail);
		xemChiTietMuonTraFrame.setLocationRelativeTo(null);
		xemChiTietMuonTraFrame.setResizable(false);
		xemChiTietMuonTraFrame.setVisible(true);
	}
	
	
	private void hoanTraActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				JTable xemChiTietTable = this.controller.getTable();
				int row = xemChiTietTable.getSelectedRow();
				if(row == -1) {
		    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
		  			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
		  		return;
				}
				String tenNguoiMuon = xemChiTietTable.getModel().getValueAt(row, 1).toString();
				String cccdNguoiMuon = xemChiTietTable.getModel().getValueAt(row, 2).toString();
				String thoiGianMuon = xemChiTietTable.getModel().getValueAt(row, 4).toString();
				Timestamp thoiGianMuonTS = timeService.convertDatetableToTimestamp(thoiGianMuon);
				  if (JOptionPane.showConfirmDialog(null, "Bạn sẽ hoàn trả toàn bộ cơ sở vật chất và phòng ban đã mượn của " + tenNguoiMuon + " ??", "Question??", JOptionPane.YES_NO_OPTION) == 0) {
			        	 try {
			             	MuonTraService muonTraService = new MuonTraService();
			             	if(muonTraService.hoanTraToanBo(cccdNguoiMuon, thoiGianMuonTS))
			                     JOptionPane.showMessageDialog(null, "Hoàn trả thành công!!");
			                controller.refreshData();
			           
			             } catch (Exception e) {
			                 System.out.println(e.getMessage());
			                 JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
			             }
			        }
	}
	
	private void huyMuonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JTable xemChiTietTable = this.controller.getTable();
		int row = xemChiTietTable.getSelectedRow();
		if(row == -1) {
    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
  			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
  		return;
		}
		String tenNguoiMuon = xemChiTietTable.getModel().getValueAt(row, 2).toString();
		String cccdNguoiMuon = xemChiTietTable.getModel().getValueAt(row, 4).toString();
		String thoiGianMuon = xemChiTietTable.getModel().getValueAt(row, 5).toString();
		Timestamp thoiGianMuonTS = timeService.convertDatetableToTimestamp(thoiGianMuon);
        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn hủy lịch mượn của " + tenNguoiMuon + " ??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
        	 try {
             	MuonTraService muonTraService = new MuonTraService();
             	if(muonTraService.huyLichMuon(cccdNguoiMuon, thoiGianMuonTS))
                     JOptionPane.showMessageDialog(null, "Hủy thành công!!");
                else {
                    JOptionPane.showMessageDialog(null, "Đã quá lịch mượn, không thể hủy", "Warning", JOptionPane.WARNING_MESSAGE);

                }
                controller.refreshData();
           
             } catch (Exception e) {
                 System.out.println(e.getMessage());
                 JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
             }
        }
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
	private TimeService timeService;
    private javax.swing.JButton addNewBtn;
    private javax.swing.JTextField nguoiMuonJtfSearch;
    private javax.swing.JPanel tablePanel;
    private JTextField lienheJtfSearch;
    private JLabel timeJLabel;
    private JLabel tuNgayJlb;
    private JLabel denNgayJlb;
    private JDateChooser tuNgayJdc;
    private JDateChooser denNgayJdc;
    private JPopupMenu popupMenu;
    private JMenuItem xemChiTiet;
	private JMenuItem hoanTra;
	private JMenuItem huyMuon;
	private JButton filterJButton;
}
