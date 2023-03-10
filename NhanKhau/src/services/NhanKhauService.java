package services;

import Bean.NhanKhauBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import models.ChungMinhThuModel;
import models.GiaDinhModel;
import models.NhanKhauModel;
import models.QuanHeModel;
import models.TieuSuModel;

/**
 *
 * @author Hai
 */
public class NhanKhauService {
    
    /* 
     * Ham lay ra 1 nhan khau trong db bang chung minh thu
     * 
     */
//    public NhanKhauBean getNhanKhau(String cmt) {
//        NhanKhauBean nhanKhauBean = new NhanKhauBean();  
//        // truy cap db
//        try {
//            Connection connection = MysqlConnection.getMysqlConnection();
//            String query = "SELECT * FROM nhan_khau INNER JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau WHERE soCMT = " + cmt;
//            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//            int idNhanKhau = -1;
//            while (rs.next()){
//                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
//                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
//                idNhanKhau = rs.getInt("idNhanKhau");
//                nhanKhau.setID(idNhanKhau);
//                nhanKhau.setBietDanh(rs.getString("bietDanh"));
//                nhanKhau.setHoTen(rs.getString("hoTen"));
//                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
//                nhanKhau.setNamSinh(rs.getDate("namSinh"));
//                nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
//                nhanKhau.setTonGiao(rs.getString("tonGiao"));
//                nhanKhau.setDanToc(rs.getString("danToc"));
//                nhanKhau.setQuocTich(rs.getString("quocTich"));
//                nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
//                nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
//                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
//                // con nhieu nua
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
//            }
//            preparedStatement.close();
//            if (idNhanKhau > 0) {
//                query = "SELECT * FROM tieu_su WHERE idNhanKhau = " + idNhanKhau;
//                preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//                rs = preparedStatement.executeQuery();
//                List<TieuSuModel> listTieuSuModels = new ArrayList<>();
//                while (rs.next()) {                    
//                    TieuSuModel tieuSuModel = new TieuSuModel();
//                    tieuSuModel.setID(rs.getInt("ID"));
//                    tieuSuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                    tieuSuModel.setTuNgay(rs.getDate("tuNgay"));
//                    tieuSuModel.setDenNgay(rs.getDate("denNgay"));
//                    tieuSuModel.setDiaChi(rs.getString("diaChi"));
//                    tieuSuModel.setNgheNghiep(rs.getString("ngheNghiep"));
//                    tieuSuModel.setNoiLamViec(rs.getString("noiLamViec"));
//                    listTieuSuModels.add(tieuSuModel);
//                }
//                nhanKhauBean.setListTieuSuModels(listTieuSuModels);
//                preparedStatement.close();
//                
//                query = "SELECT * FROM gia_dinh WHERE idNhanKhau = " + idNhanKhau;
//                preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//                rs = preparedStatement.executeQuery();
//                List<GiaDinhModel> listGiaDinhModels = new ArrayList<>();
//                while (rs.next()) {
//                    GiaDinhModel giaDinhModel = new GiaDinhModel();
//                    giaDinhModel.setID(rs.getInt("ID"));
//                    giaDinhModel.setHoTen(rs.getString("hoTen"));
//                    giaDinhModel.setNamSinh(rs.getDate("namSinh"));
//                    giaDinhModel.setGioiTinh(rs.getString("gioiTinh"));
//                    giaDinhModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                    giaDinhModel.setDiaChiHienTai(rs.getString("diaChiHienTai"));
//                    giaDinhModel.setNgheNghiep(rs.getString("ngheNghiep"));
//                    giaDinhModel.setQuanHeVoiNhanKhau(rs.getString("quanHeVoiNhanKhau"));
//                    listGiaDinhModels.add(giaDinhModel);
//                }                    
//                nhanKhauBean.setListGiaDinhModels(listGiaDinhModels);
//                preparedStatement.close();
//            }
//            connection.close();
//        } catch (Exception e) {
//            this.exceptionHandle(e.getMessage());
//        }
//        return nhanKhauBean;
//    }
    
     // lay danh sach 10 nhan khau moi duoc them vao
//    public List<NhanKhauBean> getListNhanKhau() {
//        List<NhanKhauBean> list = new ArrayList<>();
//        try {
//            Connection connection = MysqlConnection.getMysqlConnection();
//            String query = "SELECT * FROM nhan_khau INNER JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau ORDER BY ngayTao DESC";
//            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//        	System.out.println(rs);
//            while (rs.next()){
//                NhanKhauBean nhanKhauBean = new NhanKhauBean();
//                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
//                nhanKhau.setID(rs.getInt("ID"));
//                nhanKhau.setHoTen(rs.getString("hoTen"));
//                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
//                nhanKhau.setNamSinh(rs.getDate("namSinh"));
//                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
//                nhanKhau.setTccString(rs.getString("tcc"));
//                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
//                list.add(nhanKhauBean);
//            }
//            preparedStatement.close();
//            connection.close();
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//        }
//        return list;
//    }
    public List<NhanKhauBean> getListNhanKhau() {
        List<NhanKhauBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h WHERE n.id = idchuho\r\n"
            		+ "UNION\r\n"
            		+ "SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h, thanh_vien_cua_ho tv\r\n"
            		+ "WHERE n.id = tv.idnhankhau \r\n"
            		+ "AND h.id = idhokhau\r\n"
            		+ "ORDER BY id";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
        	System.out.println(rs);
            while (rs.next()){
                NhanKhauBean nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setDiaChiHienNay(rs.getString("diachi"));
                nhanKhau.setTccString(rs.getString("tcc"));
//                System.err.println("sfsdf   " + rs.getString("hoTen"));
//                System.err.println(rs.getString("tcc"));
                
//                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<NhanKhauBean> getListKhongPhaiChuHo() {
        List<NhanKhauBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "select * from nhan_khau\r\n"
            		+ "where id not in (\r\n"
            		+ "	select idchuho from ho_khau\r\n"
            		+ "	union\r\n"
            		+ "	select idnhankhau from thanh_vien_cua_ho\r\n"
            		+ ")";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
        	System.out.println(rs);
            while (rs.next()){
                NhanKhauBean nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setDiaChiHienNay(rs.getString("diachi"));
                nhanKhau.setTccString(rs.getString("tcc"));
//                System.err.println("sfsdf   " + rs.getString("hoTen"));
//                System.err.println(rs.getString("tcc"));
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<QuanHeModel> getListKhongPhaiChuHo(int id) {
        List<QuanHeModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * \r\n"
            		+ "FROM nhan_khau n, (\r\n"
            		+ "	SELECT * FROM thanh_vien_cua_ho\r\n"
            		+ "	WHERE idhokhau = " + id
            		+ ") tv\r\n"
            		+ "WHERE n.id = tv.idnhankhau";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
        	System.out.println(rs);
            while (rs.next()){
            	QuanHeModel nhanKhau = new QuanHeModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setTccString(rs.getString("tcc"));
                nhanKhau.setQuanHeString(rs.getString("quanhevoichuho"));
                list.add(nhanKhau);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<NhanKhauBean> statisticNhanKhau(int TuTuoi, int denTuoi, String gender, String Status, int tuNam, int denNam) {
        List<NhanKhauBean> list = new ArrayList<>();
        
        String query = "SELECT * FROM nhan_khau "
                    + "\n"
                    + " LEFT JOIN tam_tru ON nhan_khau.ID = tam_tru.idNhanKhau \n"
                    + " LEFT JOIN tam_vang ON nhan_khau.ID = tam_vang.idNhanKhau\n "
                    + " WHERE DATE_PART('year', AGE(CURRENT_DATE, namSinh))  >= "
                    + TuTuoi
                    + " \nAND DATE_PART('year', AGE(CURRENT_DATE, namSinh))  <= "
                    + denTuoi;
        if (!gender.equalsIgnoreCase("To??n B???")) {
            query += " AND nhan_khau.gioiTinh = '" + gender + "'";
        }
        if (Status.equalsIgnoreCase("To??n b???")) {
            query += " AND (tam_tru.denNgay >= CURRENT_DATE OR tam_tru.denNgay IS NULL)"
                    + " AND (tam_vang.denNgay <= CURRENT_DATE OR tam_vang.denNgay IS NULL)";
        } else if (Status.equalsIgnoreCase("Th?????ng tr??")) {
            query += " AND tam_tru.denNgay IS NULL";
            
        } else if (Status.equalsIgnoreCase("T???m tr??")) {
            query += " AND (DATE_PART('year', tam_tru.tuNgay) BETWEEN "
                    + tuNam
                    + " AND "
                    + denNam
                    + ")";
        } else if (Status.equalsIgnoreCase("T???m v???ng")) {
            query += " AND (DATE_PART('year', tam_vang.tuNgay) BETWEEN "
                    + tuNam
                    + " AND "
                    + denNam
                    + ")";
        }
        query += " ORDER BY ngayTao ASC";
        System.out.println(query);
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int idNhanKhau = -1;
            while (rs.next()){
                NhanKhauBean  nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                idNhanKhau = rs.getInt("idNhanKhau");
                nhanKhau.setID(idNhanKhau);
                nhanKhau.setBietDanh(rs.getString("bietDanh"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhanKhau.setTonGiao(rs.getString("tonGiao"));
                nhanKhau.setDanToc(rs.getString("danToc"));
                nhanKhau.setQuocTich(rs.getString("quocTich"));
                nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
                nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                // con nhieu nua
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                
                if (idNhanKhau > 0) {
                    String sql = "SELECT * FROM tieu_su WHERE idNhanKhau = " + idNhanKhau;
                    PreparedStatement prst = (PreparedStatement)connection.prepareStatement(sql);
                    ResultSet rs_temp = prst.executeQuery();
                    List<TieuSuModel> listTieuSuModels = new ArrayList<>();
                    while (rs_temp.next()) {                    
                        TieuSuModel tieuSuModel = new TieuSuModel();
                        tieuSuModel.setID(rs_temp.getInt("ID"));
                        tieuSuModel.setIdNhanKhau(rs_temp.getInt("idNhanKhau"));
                        tieuSuModel.setTuNgay(rs_temp.getDate("tuNgay"));
                        tieuSuModel.setDenNgay(rs_temp.getDate("denNgay"));
                        tieuSuModel.setDiaChi(rs_temp.getString("diaChi"));
                        tieuSuModel.setNgheNghiep(rs_temp.getString("ngheNghiep"));
                        tieuSuModel.setNoiLamViec(rs_temp.getString("noiLamViec"));
                        listTieuSuModels.add(tieuSuModel);
                    }
                    nhanKhauBean.setListTieuSuModels(listTieuSuModels);
                    prst.close();

//                    sql = "SELECT * FROM gia_dinh WHERE idNhanKhau = " + idNhanKhau;
//                    prst = (PreparedStatement)connection.prepareStatement(sql);
//                    rs_temp = prst.executeQuery();
//                    List<GiaDinhModel> listGiaDinhModels = new ArrayList<>();
//                    while (rs_temp.next()) {
//                        GiaDinhModel giaDinhModel = new GiaDinhModel();
//                        giaDinhModel.setID(rs_temp.getInt("ID"));
//                        giaDinhModel.setHoTen(rs_temp.getString("hoTen"));
//                        giaDinhModel.setNamSinh(rs_temp.getDate("namSinh"));
//                        giaDinhModel.setGioiTinh(rs_temp.getString("gioiTinh"));
//                        giaDinhModel.setIdNhanKhau(rs_temp.getInt("idNhanKhau"));
//                        giaDinhModel.setDiaChiHienTai(rs_temp.getString("diaChiHienTai"));
//                        giaDinhModel.setNgheNghiep(rs_temp.getString("ngheNghiep"));
//                        giaDinhModel.setQuanHeVoiNhanKhau(rs_temp.getString("quanHeVoiNhanKhau"));
//                        listGiaDinhModels.add(giaDinhModel);
//                    }                    
//                    nhanKhauBean.setListGiaDinhModels(listGiaDinhModels);
//                    prst.close();
                }
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public List<NhanKhauBean> statisticNhanKhauXoa(int TuTuoi, int denTuoi, String gender, String lydoString, int tuNam, int denNam) {
        List<NhanKhauBean> list = new ArrayList<>();
        if (lydoString.equals("Chuy???n ??i")) {
        	lydoString = "Chuy???n ??i n??i kh??c";
        }
        String query = "SELECT * FROM xoa_nhan_khau WHERE lydo = '" + lydoString + "' ";
        query += " AND DATE_PART('year', AGE(CURRENT_DATE, namsinh))  >= "
	                + TuTuoi
	                + " \nAND DATE_PART('year', AGE(CURRENT_DATE, namsinh))  <= "
	                + denTuoi;
	    if (!gender.equalsIgnoreCase("To??n B???")) {
	        query += " AND gioitinh = '" + gender + "'";
	    }
	    
        query += " AND (DATE_PART('year', ngayxoa) BETWEEN "
                + tuNam
                + " AND "
                + denNam
                + ")";
        
        query += " ORDER BY ngayxoa DESC";
        System.out.println(query);
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean  nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                nhanKhau.setHoTen(rs.getString("hoten"));
                nhanKhau.setGioiTinh(rs.getString("gioitinh"));
                nhanKhau.setNamSinh(rs.getDate("namsinh"));
                nhanKhau.setNgayXoa(rs.getDate("ngayxoa"));
                
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public List<NhanKhauBean> statisticTamTru(int TuTuoi, int denTuoi, String gender, String lydoString, int tuNam, int denNam) {
        List<NhanKhauBean> list = new ArrayList<>();
        String query = "select * from nhan_khau n, tam_tru tt\r\n"
        		+ "where n.id = tt.idnhankhau";
        query += " AND DATE_PART('year', AGE(CURRENT_DATE, namsinh))  >= "
	                + TuTuoi
	                + " \nAND DATE_PART('year', AGE(CURRENT_DATE, namsinh))  <= "
	                + denTuoi;
	    if (!gender.equalsIgnoreCase("To??n B???")) {
	        query += " AND gioitinh = '" + gender + "'";
	    }
	    
        query += " AND (ngayxoa is NULL OR (DATE_PART('year', ngayxoa) BETWEEN "
                + tuNam
                + " AND "
                + denNam
                + "))";
        
        query += " ORDER BY denngay DESC";
        System.out.println(query);
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean  nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("idnhankhau"));
                nhanKhau.setHoTen(rs.getString("hoten"));
                nhanKhau.setGioiTinh(rs.getString("gioitinh"));
                nhanKhau.setNamSinh(rs.getDate("namsinh"));
                nhanKhau.setNgayXoa(rs.getDate("ngayxoa"));
                nhanKhau.setNgayChuyenDen(rs.getDate("tungay"));
                nhanKhau.setNgayChuyenDi(rs.getDate("denngay"));
                
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public List<NhanKhauBean> statisticTamVang(int TuTuoi, int denTuoi, String gender, String lydoString, int tuNam, int denNam) {
        List<NhanKhauBean> list = new ArrayList<>();
        String query = "select * from nhan_khau n, tam_vang tt\r\n"
        		+ "where n.id = tt.idnhankhau";
        query += " AND DATE_PART('year', AGE(CURRENT_DATE, namsinh))  >= "
	                + TuTuoi
	                + " \nAND DATE_PART('year', AGE(CURRENT_DATE, namsinh))  <= "
	                + denTuoi;
	    if (!gender.equalsIgnoreCase("To??n B???")) {
	        query += " AND gioitinh = '" + gender + "'";
	    }
	    
	    query += " AND (ngayxoa is NULL OR (DATE_PART('year', ngayxoa) BETWEEN "
                + tuNam
                + " AND "
                + denNam
                + "))";
        
        query += " ORDER BY denngay DESC";
        System.out.println(query);
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean  nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                nhanKhau.setHoTen(rs.getString("hoten"));
                nhanKhau.setGioiTinh(rs.getString("gioitinh"));
                nhanKhau.setNamSinh(rs.getDate("namsinh"));
                nhanKhau.setNgayXoa(rs.getDate("ngayxoa"));
                nhanKhau.setNgayChuyenDen(rs.getDate("tungay"));
                nhanKhau.setNgayChuyenDi(rs.getDate("denngay"));
                
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    /*
     * ham tim kiem nhan khau theo ten
     */
//    public List<NhanKhauBean> search(String keyword) {
//        List<NhanKhauBean> list = new  ArrayList<>();
//        String query;
//        if (keyword.trim().isEmpty()) {
//            return this.getListNhanKhau();
//        }
//        // truy cap db
//        // create query
//        try {
//            long a = Long.parseLong(keyword);
//            query = "SELECT * "
//                    + "FROM nhan_khau "
//                    + "INNER JOIN chung_minh_thu "
//                    + "ON nhan_khau.ID = chung_minh_thu.idNhanKhau "
//                    + "WHERE chung_minh_thu.soCMT LIKE '%"
//                    + keyword
//                    + "%'";
//        } catch (Exception e) {
//            query = "SELECT * "
//                    + "FROM nhan_khau "
//                    + "INNER JOIN chung_minh_thu "
//                    + "ON nhan_khau.ID = chung_minh_thu.idNhanKhau "
//                    + "WHERE MATCH(hoTen, bietDanh) AGAINST ('"
//                    + keyword
//                    + "' IN NATURAL LANGUAGE MODE);";
//        }
//        
//        // execute query
//        try {
//            Connection connection = MysqlConnection.getMysqlConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                NhanKhauBean temp = new NhanKhauBean();
//                NhanKhauModel nhanKhau = temp.getNhanKhauModel();
//                nhanKhau.setID(rs.getInt("ID"));
//                nhanKhau.setHoTen(rs.getString("hoTen"));
//                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
//                nhanKhau.setNamSinh(rs.getDate("namSinh"));
//                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
//                
//                ChungMinhThuModel chungMinhThuModel = temp.getChungMinhThuModel();
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
//                list.add(temp);
//            }
//            preparedStatement.close();
//            connection.close();
//        } catch (Exception mysqlException) {
//            this.exceptionHandle(mysqlException.getMessage());
//        }
//        return list;
//    }
    
    public List<NhanKhauBean> search(String keyword, String diachi) {
        List<NhanKhauBean> list = new  ArrayList<>();
        String query;
        String query1, query2, query3;
        
        // truy cap db
        // create query
        try {
            //long a = Long.parseLong(keyword);
        	Boolean hasAndBoolean = false;
        	query1 = "SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h \r\n"
        			+ "WHERE n.id = idchuho";
        	query2 = "SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h, thanh_vien_cua_ho tv\r\n"
        			+ "WHERE n.id = tv.idnhankhau \r\n"
        			+ "AND h.id = idhokhau";
        	query3 = "SELECT n.*, h.diachi FROM nhan_khau n FULL JOIN ho_khau h\r\n"
        			+ "ON n.id = h.idchuho FULL JOIN thanh_vien_cua_ho tv \r\n"
        			+ "ON n.id = tv.idnhankhau\r\n"
        			+ "WHERE n.id NOT IN (\r\n"
        			+ "	SELECT idchuho FROM ho_khau\r\n"
        			+ ") \r\n"
        			+ "AND n.id NOT IN (\r\n"
        			+ "	SELECT idnhankhau FROM thanh_vien_cua_ho\r\n"
        			+ ") ";
//            query = "SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h \r\n"
//            		+ "WHERE n.id = idchuho\r\n"
//            		+ "UNION\r\n"
//            		+ "SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h, thanh_vien_cua_ho tv\r\n"
//            		+ "WHERE n.id = tv.idnhankhau \r\n"
//            		+ "AND h.id = idhokhau\r\n"
//            		+ "UNION\r\n"
//            		+ "SELECT n.*, h.diachi FROM nhan_khau n FULL JOIN ho_khau h\r\n"
//            		+ "ON n.id = h.idchuho FULL JOIN thanh_vien_cua_ho tv \r\n"
//            		+ "ON n.id = tv.idnhankhau\r\n"
//            		+ "WHERE n.id NOT IN (\r\n"
//            		+ "	SELECT idchuho FROM ho_khau\r\n"
//            		+ ") \r\n"
//            		+ "AND n.id NOT IN (\r\n"
//            		+ "	SELECT idnhankhau FROM thanh_vien_cua_ho\r\n"
//            		+ ")";
            hasAndBoolean = true;
            if (!keyword.isEmpty()) {
            	if (hasAndBoolean == true) {
            		query1 += " AND ";
            		query2 += " AND ";
            		query3 += " AND ";
            	}
            	hasAndBoolean = true;
            	query1 += "hoten LIKE '%"
                        + keyword
                        + "%'"
    						;
            	query2 += "hoten LIKE '%"
                        + keyword
                        + "%'"
    						;
            	query3 += "hoten LIKE '%"
                        + keyword
                        + "%'"
    						;
            }
            if (!diachi.isEmpty()) {
            	if (hasAndBoolean == true) {
            		query1 += " AND ";
            		query2 += " AND ";
            		query3 += " AND ";
            	}
            	hasAndBoolean = true;
            	query1 += "diachi LIKE '%"
                        + diachi
                        + "%' "
						;
            	query2 += "diachi LIKE '%"
                        + diachi
                        + "%' "
						;
            	query3 += "diachi LIKE '%"
                        + diachi
                        + "%' "
						;
            }
            query = query1 + " UNION " + query2 + " UNION " + query3;
            query += " ORDER BY id";
            //System.err.println(query);
            
                    
        } catch (Exception e) {
           query = "SELECT * "
                    + "FROM nhan_khau "
                    + "WHERE (hoTen ilike '%"
                    + keyword
                    + "%'"
                    +"OR bietdanh ilike '%"
                    + keyword
                    + "%')";
        Boolean hasAndBoolean = false;
        if (!diachi.isEmpty()) {
//            	if (hasAndBoolean == true) {
//            		query += " AND ";
//            	}
            	hasAndBoolean = true;
            	query += " AND diachihiennay ILIKE '%"
                        + diachi
                        + "%' "					;
            }

            query += " ORDER BY nhan_khau.id";
                    System.err.println(query);
        }
        
        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean temp = new NhanKhauBean();
                NhanKhauModel nhanKhau = temp.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setDiaChiHienNay(rs.getString("diachi"));
                nhanKhau.setTccString(rs.getString("tcc"));
                nhanKhau.setLienheString(rs.getString("lienhe"));
                nhanKhau.setTonGiao(rs.getString("tongiao"));
                nhanKhau.setGhiChu(rs.getString("ghichu"));
//                ChungMinhThuModel chungMinhThuModel = temp.getChungMinhThuModel();
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    public List<NhanKhauBean> searchKhongPhaiChuHo(String keyword, String diachi) {
        List<NhanKhauBean> list = new  ArrayList<>();
        String query;
        
        // truy cap db
        // create query
        try {
            //long a = Long.parseLong(keyword);
        	Boolean hasAndBoolean = false;
            query = "select * from nhan_khau\r\n"
            		+ "where id not in (\r\n"
            		+ "	select idchuho from ho_khau\r\n"
            		+ "	union\r\n"
            		+ "	select idnhankhau from thanh_vien_cua_ho\r\n"
            		+ ")";
            if (!keyword.isEmpty() || !diachi.isEmpty()) {
            	query += " AND ";
            }
            if (!keyword.isEmpty()) {
            	hasAndBoolean = true;
            	query += "hoten LIKE '%"
                        + keyword
                        + "%'"
    						;
            }
            if (!diachi.isEmpty()) {
            	if (hasAndBoolean == true) {
            		query += " AND ";
            	}
            	hasAndBoolean = true;
            	query += "diachihiennay LIKE '%"
                        + diachi
                        + "%' "
						;
            }
            query += " ORDER BY id";
            //System.err.println(query);
            
                    
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM nhan_khau "
                    + "WHERE MATCH(hoTen, bietDanh) AGAINST ('"
                    + keyword
                    + "' IN NATURAL LANGUAGE MODE);";
        }
        
        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean temp = new NhanKhauBean();
                NhanKhauModel nhanKhau = temp.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                //nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                nhanKhau.setTccString(rs.getString("tcc"));
                nhanKhau.setLienheString(rs.getString("lienhe"));
                nhanKhau.setTonGiao(rs.getString("tongiao"));
                nhanKhau.setGhiChu(rs.getString("ghichu"));
//                ChungMinhThuModel chungMinhThuModel = temp.getChungMinhThuModel();
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    public List<NhanKhauBean> searchThanhVienCuaHo(int idchuho) {
        List<NhanKhauBean> list = new  ArrayList<>();
        String query;
        
        // truy cap db
        // create query
        try {
            //long a = Long.parseLong(keyword);
        	Boolean hasAndBoolean = false;
        	query = "select * from nhan_khau\r\n"
            		+ "where id in (\r\n"
            		+ "	select idnhankhau from thanh_vien_cua_ho\r\n"
            		+ "	where idhokhau = " + idchuho + "  and "
            		+ " (quanhevoichuho is null or quanhevoichuho != 'Ch??? h???')\r\n"
            		+ ")";
            query += " ORDER BY id";
            //System.err.println(query);
            
                    
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM nhan_khau "
                    + "WHERE MATCH(hoTen, bietDanh) AGAINST ('"
//                    + keyword
                    + "' IN NATURAL LANGUAGE MODE);";
        }
        
        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean temp = new NhanKhauBean();
                NhanKhauModel nhanKhau = temp.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                //nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                nhanKhau.setTccString(rs.getString("tcc"));
                nhanKhau.setLienheString(rs.getString("lienhe"));
                nhanKhau.setTonGiao(rs.getString("tongiao"));
                nhanKhau.setGhiChu(rs.getString("ghichu"));
//                ChungMinhThuModel chungMinhThuModel = temp.getChungMinhThuModel();
//                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
//                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
//                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
//                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    /*
     * Ham s??? l?? ngo???i l??? : th??ng b??o ra l???i nh???n ???????c
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
