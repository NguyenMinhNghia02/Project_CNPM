package ControllersAddNewController;

import Bean.CoSoVatChatBean;
import Bean.MuonTraBean;
import Bean.PhongBanBean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JOptionPane;

import models.PhongBanModel;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.NhaTaiTroModel;
import models.ThoiGianModel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
// lop thuc hien cac chuc nang trong giao dien them moi nhan khau
public class AddNewController {

    //add thong tin nguoi muon vao database, neu add that bai tra ve false
    public boolean addNewNguoiMuon(MuonTraBean muonTraBean) throws SQLException, ClassNotFoundException {

        NguoiMuonModel nguoiMuonModel = muonTraBean.getNguoiMuonModel();
        ThoiGianModel thoiGianModel = muonTraBean.getThoiGianModel();
        List<CoSoVatChatModel> listCoSoVatChatModels = muonTraBean.getListCoSoVatChatModels();
        List<PhongBanModel> listPhongBanModels = muonTraBean.getListPhongBanModels();
        int idNguoiMuon = 100;
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String query1 = "INSERT INTO registers (user_name, user_phone, cccd)"
                    + " SELECT ?, ?, ? WHERE NOT EXISTS(SELECT * FROM registers where (user_name, user_phone, cccd) = (?, ?, ?))";

            PreparedStatement st1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);

            st1.setString(1, nguoiMuonModel.getTenNguoiMuon());
            st1.setString(2, nguoiMuonModel.getLienHe());
            st1.setString(3, nguoiMuonModel.getCccd());
            st1.setString(4, nguoiMuonModel.getTenNguoiMuon());
            st1.setString(5, nguoiMuonModel.getLienHe());
            st1.setString(6, nguoiMuonModel.getCccd());
            st1.execute();
            String query2 = "SELECT user_id from registers where (user_name, user_phone, cccd) = (?,?,?)";
            PreparedStatement st11 = connection.prepareStatement(query2);
            st11.setString(1, nguoiMuonModel.getTenNguoiMuon());
            st11.setString(2, nguoiMuonModel.getLienHe());
            st11.setString(3, nguoiMuonModel.getCccd());
            ResultSet rs = st11.executeQuery();
            while (rs.next()) {
                idNguoiMuon = rs.getInt("user_id");

            }
//            st1.close();
//            st11.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }

//        if(idNguoiMuon < 0) return false;
        final int id = idNguoiMuon;
        String query2 = "INSERT INTO schedule (time_start, time_end, real_time_end) values (?, ?, ?)";
        PreparedStatement st2 = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);

        st2.setTimestamp(1, (Timestamp) thoiGianModel.getThoiGianMuon());
        st2.setTimestamp(2, (Timestamp) thoiGianModel.getThoiGianTra());
        st2.setTimestamp(3, null);
        st2.executeUpdate();
        ResultSet keys = st2.getGeneratedKeys();
        int temp = 0;
        while (keys.next()) {
            temp = keys.getInt("event_no");
        }
        final int event_no = temp;
        listCoSoVatChatModels.forEach(coSoVatChat -> {
//                    System.out.println(coSoVatChat.getTenCoSoVatChat());
            int soLuongMuon = coSoVatChat.getSoLuongMuon();
            String query3 = "INSERT INTO itemregistered (item_id, user_id, event_no, item_number) values "
                    + "((SELECT item_id FROM item WHERE item_name = '"
                    + coSoVatChat.getTenCoSoVatChat()
                    + "'), ?, ?, ?)";
            try {
                PreparedStatement st3 = connection.prepareStatement(query3);
                st3.setInt(1, id);
                st3.setInt(2, event_no);
                st3.setInt(3, coSoVatChat.getSoLuongMuon());
                st3.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.err.println(e.getMessage());
            }
        });
        listPhongBanModels.forEach(phongBan -> {
            String query3 = "INSERT INTO infraregistered (infra_id, user_id, event_no) values "
                    + "((SELECT infra_id FROM infrastructure WHERE infra_name = '"
                    + phongBan.getTenPhongBan()
                    + "'), ?, ?)";
            try {
                PreparedStatement st3 = connection.prepareStatement(query3);
                st3.setInt(1, id);
                st3.setInt(2, event_no);
                st3.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.err.println(e.getMessage());
            }
        });
        st2.close();
        connection.close();
        return true;
    }

    //add thong tin co so vat chat vao database, neu add that bai tra ve false
    @SuppressWarnings("resource")
    public boolean addNewCoSoVatChat(CoSoVatChatBean coSoVatChatBean) {
        CoSoVatChatModel coSoVatChatModel = coSoVatChatBean.getCoSoVatChatModel();
        NhaTaiTroModel nhaTaiTroModel = coSoVatChatBean.getNhaTaiTroModel();
        Connection connection;
        try {
            connection = MysqlConnection.getMysqlConnection();

            String query = "SELECT item_id FROM item WHERE item_name = '"
                    + coSoVatChatModel.getTenCoSoVatChat()
                    + "'";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = preparedStatement.executeQuery();
            int idCoSoVatChat = -1;
            while (rs.next()) {
                idCoSoVatChat = rs.getInt("item_id");
                break;
            }
            if (idCoSoVatChat > 0) {
                String query1 = "UPDATE item SET item_quantity = item_quantity + "
                        + coSoVatChatModel.getSoLuong()
                        + " WHERE item_name = '"
                        + coSoVatChatModel.getTenCoSoVatChat() + "'";
                preparedStatement = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.execute();
            } else {
                String query1 = "INSERT INTO item (item_name, item_quantity) "
                        + "values (?, ?)";
                preparedStatement = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, coSoVatChatModel.getTenCoSoVatChat());
                preparedStatement.setInt(2, coSoVatChatModel.getSoLuong());
                preparedStatement.executeUpdate();
                String query2 = "INSERT INTO money (item_id, item_number, date, reason) "
                        + "values ((SELECT item_id FROM item WHERE item_name = '"
                        + coSoVatChatModel.getTenCoSoVatChat()
                        + "'), ?, CURRENT_DATE, ?)";
                preparedStatement = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, coSoVatChatModel.getSoLuong());
                preparedStatement.setString(2, nhaTaiTroModel.getLyDo());
                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return false;
        }
        return true;
    }

    //add thong tinphong ban vao database, neu add that bai tra ve false
    public boolean addNewPhongBan(PhongBanBean phongBanBean) throws SQLException, ClassNotFoundException {
        PhongBanModel phongBanModel = phongBanBean.getPhongBanModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO infrastructure (infra_name, reason) "
                + "values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, phongBanModel.getTenPhongBan());
        preparedStatement.setString(2, phongBanModel.getLyDo());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
