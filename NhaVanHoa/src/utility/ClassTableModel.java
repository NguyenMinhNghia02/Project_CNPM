package utility;

import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import models.CoSoVatChatModel;
import models.LichSuModel;
import models.ListMuonTraDetailModel;
import models.ListNguoiMuonCoSoVatChatDetailModel;
import models.MuonTraModel;
import models.NguoiMuonModel;
import models.PhongBanModel;
import models.ThoiGianModel;
import models.muonTra.AddMuonTraModel;
import services.TimeService;

/**
 *
 * @author Hai
 * class dinh nghia cac dang table co trong phan mem
 */
public class ClassTableModel {

	//table muon tra
	private TimeService timeService = new TimeService();
	private int i;
    public DefaultTableModel setTableMuonTra(List<MuonTraModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
            	if(columnIndex == 0 || columnIndex == 7) return Integer.class;
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        i = 1;
        listItem.forEach(item -> {
            obj[0] = i++;
            obj[2] = item.getTenNguoiMuon();
            obj[4] = item.getid();
            obj[7] = item.getLienHe();
            
            obj[5] = timeService.convertToDateShowInTable(item.getThoiGianMuon());
            obj[6] = timeService.convertToDateShowInTable(item.getThoiGianTra());
            obj[1] = item.getCoSoVatChat();
            obj[3] = item.getSoLuong();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    // table cho co so vat chat
    public DefaultTableModel setTableCoSoVatChat(List<CoSoVatChatModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex != 1 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        i = 1;
        listItem.forEach((CoSoVatChatModel item) -> {
            obj[0] = i++;
            obj[1] = item.getTenCoSoVatChat();
            obj[2] = item.getSoLuong();
            obj[3] = item.getSoLuongMuon();
            obj[4] = item.getSoLuongTrongKho();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    // table cho  Phong Ban
    public DefaultTableModel setTablePhongBan(List<PhongBanModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 1 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        i = 1;
        listItem.forEach((PhongBanModel item) -> {
            obj[0] = i++;
            obj[1] = item.getTenPhongBan();
            obj[2] = item.getThoiGianSuDung();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    // table cho Lich Su
    public DefaultTableModel setTableLichSu(List<LichSuModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
            	if(columnIndex == 1 || columnIndex == 3) return Integer.class;
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        i = 1;
        listItem.forEach((LichSuModel item) -> {
            obj[0] = i++;
            obj[1] = item.getLyDo();
            obj[2] = item.getDungCu();
            obj[3] = item.getSoLuong();
            obj[4] = timeService.convertToDateShowInTable(item.getThoiGian());
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableAddMuonTra(List<CoSoVatChatModel> listItemCoSoVatChat,List<PhongBanModel> listItemPhongBan, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
            	if(columnIndex == 1) return Integer.class;
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItemPhongBan.forEach((PhongBanModel item) -> {
            obj[0] = item.getTenPhongBan();
            obj[1] = 1;
            dtm.addRow(obj);
        });
        listItemCoSoVatChat.forEach((CoSoVatChatModel item) -> {
            obj[0] = item.getTenCoSoVatChat();
            obj[1] = item.getSoLuongMuon();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableCoSoVatChatDetail(List<ListNguoiMuonCoSoVatChatDetailModel> listNguoiMuonCoSoVatChatDetailModels, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
            	if(columnIndex == 0 || columnIndex == 2) return Integer.class;
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        i = 1;
        listNguoiMuonCoSoVatChatDetailModels.forEach(nguoiMuon -> {
        	obj[0] = i++;
        	obj[1] = nguoiMuon.getTenNguoiMuon();
        	obj[2] = nguoiMuon.getSoLuongMuon();
        	obj[3] = timeService.convertToDateShowInTable( nguoiMuon.getThoiGianMuon());
        	obj[4] = timeService.convertToDateShowInTable(nguoiMuon.getThoiGianTra());
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableMuonTraDetail(List<CoSoVatChatModel> listItemCoSoVatChat,List<PhongBanModel> listItemPhongBan, String[] listColumn) {
    	 final int columns = listColumn.length;
         DefaultTableModel dtm = new DefaultTableModel()  {
             @Override
             public boolean isCellEditable(int row, int column) {
                 return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
             }
             @Override
             public Class<?> getColumnClass(int columnIndex) {
             	if(columnIndex == 2 || columnIndex == 1) return Integer.class;
                 return String.class;
             }
         };
         dtm.setColumnIdentifiers(listColumn);
         Object[] obj;
         obj = new Object[columns];
         i = 1;
         listItemPhongBan.forEach((PhongBanModel item) -> {
        	 obj[0] = i++;
             obj[1] = item.getTenPhongBan();
             obj[2] = 1;
             obj[3] = item.getSoLuongDaTra();
 	         if(item.getThoiGianTraReal() == null) obj[4] = null;
 	         else obj[4] = timeService.convertToDateShowInTable(item.getThoiGianTraReal());
             dtm.addRow(obj);
         });
         listItemCoSoVatChat.forEach((CoSoVatChatModel item) -> {
        	 obj[0] = i++;
             obj[1] = item.getTenCoSoVatChat();
             obj[2] = item.getSoLuongMuon();
             obj[3] = item.getSoLuongDaTra();
 	         if(item.getThoiGianTraReal() == null) obj[4] = null;
 	         else obj[4] = timeService.convertToDateShowInTable(item.getThoiGianTraReal());
             dtm.addRow(obj);
         });
         return dtm;
    }
}
