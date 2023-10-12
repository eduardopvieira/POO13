package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class EditarPecasFuncionarioController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldFabricantePeca;

    @FXML
    private TextField textfieldNomePeca;

    @FXML
    private TextField textfieldValorPeça;

    @FXML
    void editarPeca(ActionEvent event) throws Exception {
    
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuPecas();
    }

}
