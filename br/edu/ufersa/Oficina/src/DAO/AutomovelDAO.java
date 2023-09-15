package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Automovel;
import model.entity.Cliente;

public class AutomovelDAO extends BaseDAOImpl <Automovel>{
    
    @Override
    public Long inserir (Automovel entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_automovel (placa, cor, modelo, ano, quilometragem, dono) " + "values (?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getPlaca());
            ps.setString(2, entity.getCor());
            ps.setString(3, entity.getModelo());
            ps.setInt(4, entity.getAno());
            ps.setInt(5, entity.getKm());
            ps.setString(6, entity.getDono().getCPF());
            ps.execute();
            ps.close();
        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {closeConnection();
            System.out.println("Chegou aqui!"); }
            return null;
    }
    //=======================================================================================

    public void deletar(Automovel entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_auto WHERE placa = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getPlaca());
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

    public void alterar (Automovel entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_automovel SET placa = ?, cor = ?, modelo = ?, ano = ?, quilometragem = ? WHERE cpf_d = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getPlaca());
            ps.setString(2, entity.getCor());
            ps.setString(3, entity.getModelo());
            ps.setInt(4, entity.getAno());
            ps.setInt(5, entity.getKm());
            ps.setString(6, entity.getDono().getCPF());
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
    public ResultSet buscar (Automovel entity) {

        String sql = "SELECT * FROM tb_auto WHERE placa=? OR modelo=?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getPlaca()); // Parâmetro para o nome
            ptst.setString(2, entity.getModelo()); // Parâmetro para o CPF
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
}
   
//=======================================================================================
@Override   
public List<Automovel> listar()
    {
        Connection con = getConnection();
        String sql = "SELECT * FROM paciente";
        List<Automovel> pc = new ArrayList<Automovel>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Cliente usu = new Cliente();
                Automovel auto = new Automovel();
                usu.setAuto(auto);

                try {
                    usu.setCpf(rs.getString("cpf"));
                    usu.setNome(rs.getString("nome_p"));
                    usu.setEndereco(rs.getString("endereco"));
                    usu.getProntuario().setId(rs.getLong("p_id"));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                pc.add(usu);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {closeConnection();}
        return pc;
    }
}



 /*public void cadastrarAuto(Automovel auto) {};
    public void excluirAuto(Automovel auto) {};
    public void editarAuto(Automovel auto) {};
    public void buscarPlaca(String placa) {};
    public void buscarModelo(String modelo) {};*/
