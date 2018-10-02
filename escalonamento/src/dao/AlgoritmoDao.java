package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Algoritmo;
import model.Cpu;
import model.Pessoa;

public class AlgoritmoDao {
		
	public Algoritmo carregar(Algoritmo algoritmo) {
		String sql = "SELECT * FROM algoritmo WHERE id = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, algoritmo.getId());
			
			try (ResultSet rs = stm.executeQuery();) {
				
				if(rs.next()) {
					
					algoritmo.setId(rs.getInt("id"));
					algoritmo.setVelocidade(rs.getInt("velocidade"));
					algoritmo.setNome(rs.getString("nome"));
					algoritmo.setImg_r(rs.getString("img_r"));
					algoritmo.setImg_l(rs.getString("img_l"));
					algoritmo.setImg_background(rs.getString("img_background"));
										
					Cpu cpu = new Cpu();
					cpu.setId(rs.getInt("fk_cpu_id"));
					
					CpuDao cd = new CpuDao();
					cpu = cd.carregar(cpu);
					
					algoritmo.setCpu(cpu);
				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		algoritmo = this.carregarPessoasDoAlgoritmo(algoritmo);
		return algoritmo;
	}
	
	public Algoritmo carregarPessoasDoAlgoritmo(Algoritmo algoritmo) {
		String sql = "SELECT * FROM pessoa WHERE fk_algoritmo_id = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, algoritmo.getId());
			
			ArrayList<Pessoa> ap = new ArrayList<Pessoa>();
			
			try (ResultSet rs = stm.executeQuery();) {
				
				while(rs.next()) {
					Pessoa pessoa = new Pessoa();
					pessoa.setId(rs.getInt("id"));
					pessoa.setImg(rs.getString("img"));
					pessoa.setNome(rs.getString("nome"));
					pessoa.setUiIndex(rs.getInt("ui_index"));
					ap.add(pessoa);				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			algoritmo.setPessoa(ap);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return algoritmo;
	}
	
}
