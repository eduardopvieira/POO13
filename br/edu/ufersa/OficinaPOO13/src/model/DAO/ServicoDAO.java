package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.Servico;

public class ServicoDAO extends BaseDAOImpl <Servico>{
    	
	@Override
	public void inserir(Servico entity) {
		
		Connection con = getConnection();  
        String sql = "INSERT INTO tb_servicos (servico_nome, servico_desc, servico_preco, servico_id) values (?,?,?,?)";

		try {
				PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, entity.getServicoNome());
                statement.setString(2, entity.getServicoDescricao());
                statement.setDouble(3, entity.getServicoPreco());
                statement.setInt(4, entity.getServicoId());
                statement.execute();
                statement.close();
                System.out.println("Serviço adicionado com sucesso");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {closeConnection();}
    	}
	
 
//=================================== Inserir ====================================================
	@Override
    public void deletar(Servico entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_servicos WHERE servico_id = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, entity.getServicoId());
            ps.execute();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally {closeConnection();}
    }
//=======================================================================================
	@Override
    public Servico alterar (Servico entity) throws SQLException{
        Connection con = getConnection();
        String sql = "UPDATE tb_servicos SET servico_nome = ?, servico_desc = ?, servico_preco = ? WHERE servico_id = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getServicoNome());
            ps.setString(2, entity.getServicoDescricao());
            ps.setDouble(3, entity.getServicoPreco());
            ps.setInt(4, entity.getServicoId());
            ps.execute();
            ps.close();
            return entity;
        }
        catch(SQLException e)
        {
        	throw e;
        }
        finally {closeConnection();}
    }

    //===============================BUSCAR POR ID====================================================
	@Override
	public ResultSet buscar(Servico entity) {

        String sql = "SELECT * FROM tb_servicos WHERE servico_id = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setInt(1, entity.getServicoId());
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
	
//================================BUSCAR POR NOME=======================================
	public ResultSet buscarPorNome (Servico entity) {

        String sql = "SELECT * FROM tb_servicos WHERE servico_nome = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getServicoNome());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //====================================== LISTAR ==================================
	 @Override
	    public List<Servico> listar()
	    {
	        Connection con = getConnection();
	        String sql = "SELECT * FROM tb_servicos";
	        List<Servico> pc = new ArrayList<>();

	        try {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while(rs.next())
	            {
	            	Servico usu = new Servico();

	                try
	                {
	                    usu.setServicoId(rs.getInt("servico_id"));
	                	usu.setServicoNome(rs.getString("servico_nome"));
	                    usu.setServicoDescricao(rs.getString("servico_desc"));
	                	usu.setServicoPreco(rs.getDouble("servico_preco"));
	                }
	                catch (Exception e)
	                {
	                    e.printStackTrace();
	                }
	                pc.add(usu);
	            }
	            ps.close();
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        finally {closeConnection();}
	        return pc;
	    }

}