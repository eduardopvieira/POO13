package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class CadastrarServicoController {

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
    void cadastrarServico(ActionEvent event) throws Exception {
    	
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuServicoGerente(UsuarioAutenticado.getGerenteAutenticado());
    }

}
