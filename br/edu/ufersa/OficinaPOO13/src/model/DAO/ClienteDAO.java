package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.Cliente;

public class ClienteDAO extends BaseDAOImpl <Cliente>{
    
//====================================== INSERIR ====================================================================
    @Override
    public void inserir (Cliente entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_clientes (cpf_cliente, nome_cliente, endereco_cliente) " + "values (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getCPF());
            ps.setString(2, entity.getNome());
            ps.setString(3, entity.getEndereco());
            ps.execute();
            ps.close();
            System.out.println("Adicionado com sucesso.");
        
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        finally {closeConnection();
            System.out.println("Chegou aqui!"); }
         
    }
//===================================================================================================================
    @Override
    public void deletar(Cliente entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_clientes WHERE cpf_cliente = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getCPF());
            ps.execute();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally {closeConnection();}
    }
//====================================================================================================================
    @Override
    public Cliente alterar (Cliente entity) throws SQLException  {
        Connection con = getConnection();
        String sql = "UPDATE tb_clientes SET nome_cliente = ?, endereco_cliente = ? WHERE cpf_cliente = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getCPF());
            ps.setString(3, entity.getEndereco());
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

//==================================================================================================================
    @Override
    public ResultSet buscar (Cliente entity) {

        String sql = "SELECT * FROM tb_clientes WHERE cpf_cliente = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getCPF());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
//==================================BUSCAR POR NOME====================================
    public ResultSet buscarPorNome (String nome) {

        String sql = "SELECT * FROM tb_clientes WHERE nome_cliente = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, nome);
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
//=======================================================================================
    @Override
    public List<Cliente> listar()
    {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_clientes";
        List<Cliente> pc = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
            	Cliente usu = new Cliente();

                try
                {
                	
                    usu.setCPF(rs.getString("cpf_cliente"));
                    usu.setNome(rs.getString("nome_cliente"));
                    usu.setEndereco(rs.getString("endereco_cliente"));
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
