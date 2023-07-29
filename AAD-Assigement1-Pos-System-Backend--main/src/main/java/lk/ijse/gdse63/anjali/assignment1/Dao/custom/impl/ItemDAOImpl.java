package lk.ijse.gdse63.shaili.assignment1.Dao.custom.impl;

import lk.ijse.gdse63.shaili.assignment1.DB.DBConnection;
import lk.ijse.gdse63.shaili.assignment1.Dao.custom.ItemDAO;
import lk.ijse.gdse63.shaili.assignment1.Entity.Item;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ItemDAOImpl implements ItemDAO {
    private static String error_Info = "";

    public static String getError_Info() {
        return error_Info;
    }

    public void setError_Info(String e) {
        error_Info = e;

    }
    @Override
    public boolean add(Item item) throws SQLException {
        int status = 0;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
            ps.setString(1,item.getId());
            ps.setString(2,item.getName());
            ps.setInt(3,item.getQty());
            ps.setDouble(4,item.getPrice());
            status = ps.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        if (status > 0){
            System.out.println("pass true");
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Item item) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Optional<Item> search(String s) {
        return Optional.empty();
    }

    @Override
    public List<Item> getAll() {
        return null;
    }
}
