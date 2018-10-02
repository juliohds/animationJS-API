package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import model.Cpu;

public class CpuDao {
	
	public Cpu inserir(Cpu cpu) {
		String sql = "INSERT INTO cpu(img,height,width,status) VALUES (?,?,?,?)";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setString(1, cpu.getImg());
			stm.setInt(2, cpu.getHeight());
			stm.setInt(3, cpu.getWidth());
			stm.setString(4, cpu.getStatus());
			stm.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cpu;
	}
	
	public Cpu carregar(Cpu cpu) {
		String sql = "SELECT * FROM cpu WHERE id = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, cpu.getId());
			
			try (ResultSet rs = stm.executeQuery();) {
				
				if(rs.next()) {
					cpu.setId(rs.getInt("id"));
					cpu.setHeight(rs.getInt("height"));
					cpu.setImg(rs.getString("img"));
					cpu.setWidth(rs.getInt("width"));		
					cpu.setStatus(rs.getString("status"));
					cpu.setStatus_i(rs.getString("status_i"));
					cpu.setStatus_p(rs.getString("status_p"));
					cpu.setStatus_f(rs.getString("status_f"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cpu;
	}
}
