package controller;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BO.ServicoBO;
import model.VO.Servico;
import model.VO.UsuarioAutenticado;
import view.Telas;
import view.util.Alerts;

public class EditarServicoController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldDescricaoServico;

    @FXML
    private TextField textfieldNomeServico;

    @FXML
    private TextField textfieldPrecoServico;

    @FXML
    private Label textoID;

    @FXML
    public void Initialize(Servico serv) {
        try {
        	textfieldNomeServico.setText(serv.getServicoNome());
            textfieldDescricaoServico.setText(serv.getServicoDescricao());
            textfieldPrecoServico.setText(Double.toString(serv.getServicoPreco())); 
            textoID.setText(Integer.toString(serv.getServicoId()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void editarServico(ActionEvent event) {
    	Servico serv = new Servico();
    	ServicoBO servBO = new ServicoBO();

        try
        {
            int ID = Integer.parseInt(textoID.getText());
        	serv.setServicoId(ID);
        	
        	double preco = Double.parseDouble(textfieldPrecoServico.getText());
        	serv.setServicoPreco(preco);
        	
        	serv.setServicoNome(textfieldNomeServico.getText());
        	
        	serv.setServicoDescricao(textfieldDescricaoServico.getText());

            servBO.alterar(serv);
            
            Telas.telaMenuServicoGerente(UsuarioAutenticado.getGerenteAutenticado());
        }
        catch (InfoNaoCompativelException e)
        {
        	Alerts.showAlert("Erro", "Campo vazio", "Nenhum campo pode ser deixado vazio.", AlertType.ERROR);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuServicoGerente(UsuarioAutenticado.getGerenteAutenticado());
    }

}
