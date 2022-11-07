package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Accounts;

public class AccountDAO {

    private Connection conn;

    public AccountDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=SachGiaoKhoa;"
                    + "username=tuan;password=tuan123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addAcc(Accounts acc) {
        String sql = "INSERT INTO tbAccount(maTk, userName, password, fullName, birthday)"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getMaTK());
            ps.setString(2, acc.getUserName());
            ps.setString(3, acc.getPassword());
            ps.setString(4, acc.getFullName());
            ps.setString(5, acc.getBirthday());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Accounts getAcc(String maTK) {
        Accounts s = new Accounts();
        String sql = "SELECT * FROM tbAccount WHERE maTk = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maTK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setMaTK(rs.getString("maTk"));
                s.setUserName(rs.getString("userName"));
                s.setPassword(rs.getString("password"));
                s.setFullName(rs.getString("fullName"));
                s.setBirthday(rs.getString("birthday"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<Accounts> getListAcc() throws SQLException {
        ArrayList<Accounts> accs = new ArrayList<>();
        String sql = "SELECT * FROM tbAccount";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Accounts s = new Accounts();
                s.setMaTK(rs.getString("maTk"));
                s.setUserName(rs.getString("userName"));
                s.setPassword(rs.getString("password"));
                s.setFullName(rs.getString("fullName"));
                s.setBirthday(rs.getString("birthday"));
                accs.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accs;
    }
}
