package id.or.greenlabs.spring.demo.dao;

import id.or.greenlabs.spring.demo.entity.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MahasiswaDAOImpl implements MahasiswaDAO {
    Connection connection;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional
    @Override
    public Mahasiswa save(Mahasiswa entity) {
        String sql = "INSERT INTO Mahasiswa(nim, nama)" +
                "vVALUES(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, entity.getNim());
                ps.setString(2, entity.getNama());
                ps.setString(3, entity.getAlamat());
                return ps;
            }
        }, keyHolder);
        entity.setId(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public Mahasiswa delete(Mahasiswa entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mahasiswa update(Mahasiswa entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mahasiswa> find(Mahasiswa param, int offset, int limit) {
        String sql = "SELECT & FROM Mahasiswa";
        
        return jdbcTemplate.query(sql, new RowMapper<Mahasiswa>() {
            @Override
            public Mahasiswa mapRow(ResultSet rs, int i) throws SQLException {
               Mahasiswa mahasiswa = new Mahasiswa();
               mahasiswa.setId(rs.getInt("id"));
               mahasiswa.setNim(rs.getString("nim"));
               mahasiswa.setNama(rs.getString("nama"));
               mahasiswa.setAlamat(rs.getString("alamat"));
               return mahasiswa;
            }
        });
    }

    @Override
    public Mahasiswa findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count(Mahasiswa param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
