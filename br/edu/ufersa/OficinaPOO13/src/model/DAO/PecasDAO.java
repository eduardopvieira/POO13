package model.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.Orcamento;
import model.VO.Pecas;

public class PecasDAO extends BaseDAOImpl <Pecas>{
	
	@Override
	public void inserir(Pecas entity) {
        try {
            Connection con = BaseDAOImpl.getConnection();
            String sql = "INSERT INTO tb_pecas (desc_peca, fab_peca, preco_peca, estoque_peca, id_peca) " + "values (?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getDescricaoItem());
            statement.setString(2, entity.getFabricante());
            statement.setDouble(3, entity.getPrecoItem());
            statement.setInt(4, entity.getEstoqueItem());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("A inserção falhou. Nenhuma linha foi alterada.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setIdItem(generatedKeys.getInt(1));
            } else {
                throw new Exception("A inserção falhou. Nenhum id foi retornado.");
            }
            statement.close();
            BaseDAOImpl.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   //===================================ALTERAR=========================================
	@Override	
	public Pecas alterar(Pecas entity) throws SQLException {
		Connection con = BaseDAOImpl.getConnection();
        String sql = "UPDATE tb_pecas SET desc_peca = ?, fab_peca = ?, preco_peca = ?, estoque_peca = ? WHERE id_peca = ?";    
		try {
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, entity.getDescricaoItem());
	            statement.setString(2, entity.getFabricante());
	            statement.setDouble(3, entity.getPrecoItem());
	            statement.setInt(4, entity.getEstoqueItem());
	            statement.setInt(5, entity.getIdItem());
	            statement.executeUpdate();
	            statement.close();
	            return entity;
		}
        catch(SQLException e)
        {
			throw e;
        }
        finally {closeConnection();}
    }
//=====================================BUSCAR POR NOME==================================
	@Override	
	public ResultSet buscar (Pecas entity) {

	        String sql = "SELECT * FROM tb_pecas WHERE nome_peca = ?";
	        PreparedStatement ptst;
	        ResultSet rs = null;
	    
	        try {
	            ptst = getConnection().prepareStatement(sql);
	            ptst.setString(1, entity.getDescricaoItem());
	            System.out.println(ptst);
	            rs = ptst.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }

//==================================BUSCAR POR FAB=====================================================
	    public ResultSet buscarPorFab (Pecas entity) {

	        String sql = "SELECT * FROM tb_pecas WHERE fab_peca = ?";
	        PreparedStatement ptst;
	        ResultSet rs = null;
	    
	        try {
	            ptst = getConnection().prepareStatement(sql);
	            ptst.setString(1, entity.getFabricante());
	            System.out.println(ptst);
	            rs = ptst.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }
//==================================LISTAR=============================================
	    @Override
	    public List<Pecas> listar()
	    {
	        Connection con = getConnection();
	        String sql = "SELECT * FROM tb_pecas";
	        List<Pecas> pc = new ArrayList<>();

	        try {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while(rs.next())
	            {
	            	Pecas usu = new Pecas();

	                try
	                {
	                    usu.setIdItem(rs.getInt("id_peca"));
	                	usu.setDescricaoItem(rs.getString("desc_peca"));
	                    usu.setFabricante(rs.getString("fab_peca"));
	                	usu.setPrecoItem(rs.getDouble("preco_peca"));
	                    usu.setEstoqueItem(rs.getInt("estoque_peca"));
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
//=======================================DELETAR=========================================
	@Override
	public void deletar(Pecas entity) {
        try {
            Connection con = BaseDAOImpl.getConnection();
            String sql = "DELETE FROM tb_pecas WHERE id_peca = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, entity.getIdItem());
            statement.executeUpdate();
            statement.close();
            BaseDAOImpl.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}