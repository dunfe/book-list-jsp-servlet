/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Key;
import model.ListAll;

/**
 *
 * @author Admin
 */
public class ListDAO extends DBContext{
        public Map<Key, List<String>>  getAll() {
        ArrayList<ListAll> listAll = new ArrayList<>();
        try {
            String sql = "select b.title, year(b.publishDate), c.name\n"
                    + "from author_article a\n"
                    + "inner join\n"
                    + "article b\n"
                    + "on a.arid = b.id\n"
                    + "inner join \n"
                    + "author c\n"
                    + "on a.auid = c.id";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ListAll d = new ListAll();
                d.setTitle(rs.getString(1));
                d.setDate(rs.getInt(2));
                d.setAuthor(rs.getString(3));
                listAll.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<Key, List<String>> map = new HashMap<>();
        listAll.forEach((a) -> {
            Key test = new Key();
            test.setDate(a.getDate());
            test.setTitle(a.getTitle());
            if(!map.containsKey(test))
                map.put(test, new ArrayList<>());
            map.get(test).add(a.getAuthor());
        });
                
        return map;
    }
}
