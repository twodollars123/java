package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.SachGiaoKhoa;
import model.SachThamKhoa;

public class DAO {

    private Connection conn;

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=SachGiaoKhoa;"
                    + "username=tuan;password=tuan123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addSGK(SachGiaoKhoa sgk) {
        String sql = "INSERT INTO tbSGK(maS, donGia, soLuong, nhaXuatBan, tinhTrang, thanhTien)"
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sgk.getMaS());
            ps.setFloat(2, sgk.getDonGia());
            ps.setInt(3, sgk.getSoLuong());
            ps.setString(4, sgk.getNhaXuatBan());
            ps.setString(5, sgk.getTinhTrang());
            ps.setFloat(6, sgk.getThanhTien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addSTK(SachThamKhoa s) {
        String sql = "INSERT INTO tbSTK(maS, donGia, soLuong, nhaXuatBan, thue, thanhTien)"
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaS());
            ps.setFloat(2, s.getDonGia());
            ps.setInt(3, s.getSoLuong());
            ps.setString(4, s.getNhaXuatBan());
            ps.setFloat(5, s.getThue());
            ps.setFloat(6, s.getThanhTien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SachThamKhoa> getListSTK() throws SQLException {
        ArrayList<SachThamKhoa> list = new ArrayList<>();
        String sql = "SELECT * FROM tbSTK";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SachThamKhoa s = new SachThamKhoa();
                s.setMaS(rs.getString("maS"));
                s.setDonGia(rs.getFloat("donGia"));
                s.setSoLuong(rs.getInt("soLuong"));
                s.setNhaXuatBan(rs.getString("nhaXuatBan"));
                s.setThue(rs.getFloat("thue"));
                s.setThanhTien(s.getThue());
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean suaSGK(SachGiaoKhoa sgk) {
        String sql = "UPDATE tbSGK SET maS = ?, donGia = ?, soLuong = ?, "
                + "nhaXuatBan = ?, tinhTrang = ?, thanhTien = ? WHERE maS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sgk.getMaS());
            ps.setFloat(2, sgk.getDonGia());
            ps.setInt(3, sgk.getSoLuong());
            ps.setString(4, sgk.getNhaXuatBan());
            ps.setString(5, sgk.getTinhTrang());
            ps.setFloat(6, sgk.getThanhTien());
            ps.setString(7, sgk.getMaS());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaSTK(SachThamKhoa sgk) {
        String sql = "UPDATE tbSTK SET maS = ?, donGia = ?, soLuong = ?, nhaXuatBan = ?,"
                + " thue = ?, thanhTien = ? WHERE maS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sgk.getMaS());
            ps.setFloat(2, sgk.getDonGia());
            ps.setInt(3, sgk.getSoLuong());
            ps.setString(4, sgk.getNhaXuatBan());
            ps.setFloat(5, sgk.getThue());
            ps.setFloat(6, sgk.getThanhTien());
            ps.setString(7, sgk.getMaS());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaSGK(SachGiaoKhoa sgk) {
        String sql = "DELETE FROM tbSGK WHERE maS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sgk.getMaS());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaSTK(SachThamKhoa sgk) {
        String sql = "DELETE FROM tbSTK WHERE maS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sgk.getMaS());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public SachGiaoKhoa timSGK(String maS) {
        SachGiaoKhoa s = new SachGiaoKhoa();
        String sql = "SELECT * FROM tbSGK WHERE maS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setMaS(rs.getString("maS"));
                s.setDonGia(rs.getFloat("donGia"));
                s.setSoLuong(rs.getInt("soLuong"));
                s.setNhaXuatBan(rs.getString("nhaXuatBan"));
                s.setTinhTrang(rs.getString("tinhTrang"));
                s.setThanhTien(s.getTinhTrang());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<SachGiaoKhoa> getListSGK() throws SQLException {
        ArrayList<SachGiaoKhoa> list = new ArrayList<>();
        String sql = "SELECT * FROM tbSGK";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SachGiaoKhoa s = new SachGiaoKhoa();
                s.setMaS(rs.getString("maS"));
                s.setDonGia(rs.getFloat("donGia"));
                s.setSoLuong(rs.getInt("soLuong"));
                s.setNhaXuatBan(rs.getString("nhaXuatBan"));
                s.setTinhTrang(rs.getString("tinhTrang"));
                s.setThanhTien(s.getTinhTrang());
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        new DAO();
    }
}
