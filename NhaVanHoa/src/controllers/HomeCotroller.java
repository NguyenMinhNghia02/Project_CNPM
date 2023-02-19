package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
public class HomeCotroller {
    private JLabel tongCoSoVatChat;
    private JLabel tongSoPhong;
    

    public HomeCotroller(JLabel tongCoSoVatChat, JLabel tongSoPhong) {
        this.tongCoSoVatChat = tongCoSoVatChat;
        this.tongSoPhong = tongSoPhong;
    }
    
    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT count(*) AS tong "
                    + "FROM item i LEFT JOIN itemregistered ir ON i.item_id=ir.item_id where i.item_quantity>0 ";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongCoSoVatChat.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM infrastructure";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongSoPhong.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            
            
            connection.close();
        } catch (Exception e) {
        }
    }

    public JLabel getTongCoSoVatChat() {
        return tongCoSoVatChat;
    }

    public void setTongCoSoVatChat(JLabel tongCoSoVatChat) {
        this.tongCoSoVatChat = tongCoSoVatChat;
    }

    public JLabel getTongSoPhong() {
        return tongSoPhong;
    }

    public void setTongSoPhong(JLabel tongSoPhong) {
        this.tongSoPhong = tongSoPhong;
    }

    
    
}
