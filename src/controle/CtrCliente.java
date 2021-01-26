package controle;

import java.awt.event.ActionEvent;

import formulario.FrmCliente;
import entidade.Cliente;
import util.Valida;

import dao.cliente.ClienteDAO;
import dao.DAOFactory;
import dao.Factory;

/**
 * Classe que realiza a interação entre a interface e a entidade do sistema.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 19-abr-2020 22:00:00
 */
public class CtrCliente {

    private FrmCliente frmCliente;

    /**
     * Construtor sem argumentos.
     */
    public CtrCliente() {

        //Cria a tabela
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        clientedao.criar();

        // Instacia a janela
        setFrmCliente(new FrmCliente());

        // Associa os eventos aos componentes
        getFrmCliente().jBIncluir
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBIncluir_actionPerformed(e);
                    }
                });

        getFrmCliente().jBAlterar
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBAlterar_actionPerformed(e);
                    }
                });

        getFrmCliente().jBConsultar
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBConsultar_actionPerformed(e);
                    }
                });

        getFrmCliente().jBExcluir
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBExcluir_actionPerformed(e);
                    }
                });

        getFrmCliente().jBLimpar
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBLimpar_actionPerformed(e);
                    }
                });

        getFrmCliente().jBFechar
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jBFechar_actionPerformed(e);
                    }
                });
    }

    /**
     * Operação que inicia a sequência de interações da manutenção de cliente.
     */
    public void executar() {
        getFrmCliente().setVisible(true);
    }

    void jBIncluir_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().jTClienteId.getText());
        cliente.setNome(getFrmCliente().jTNome.getText());
        cliente.setCpf(getFrmCliente().jTCpf.getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido == true) {
            boolean resultado = cliente.inserir();
            if (resultado == true) {
                getFrmCliente().mostrarMensagem("Inclusao realizada com sucesso!");
            } else {
                getFrmCliente().mostrarMensagem("Inclusao nao realizada!");
            }
        } else {
            getFrmCliente().mostrarMensagem("CPF Invalido!");
        }
    }

    void jBAlterar_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().jTClienteId.getText());
        cliente.setNome(getFrmCliente().jTNome.getText());
        cliente.setCpf(getFrmCliente().jTCpf.getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido == true) {
            int resultado = cliente.alterar();
            if (resultado != 0) {
                getFrmCliente().mostrarMensagem("Alteracao realizada com sucesso!");
            } else {
                getFrmCliente().mostrarMensagem("Alteracao nao realizada!");
            }
        } else {
            getFrmCliente().mostrarMensagem("CPF Invalido!");
        }
    }

    void jBConsultar_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().jTClienteId.getText());
        boolean resultado = cliente.abrir();
        if (resultado == true) {
            getFrmCliente().jTNome.setText(cliente.getNome());
            getFrmCliente().jTCpf.setText(cliente.getCpf());
            getFrmCliente().mostrarMensagem("Cliente encontrado!");
        } else {
            getFrmCliente().mostrarMensagem("Cliente nao encontrado!");
        }
    }

    void jBExcluir_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().jTClienteId.getText());
        int resultado = cliente.excluir();
        if (resultado != 0) {
            getFrmCliente().mostrarMensagem("Exclusao realizada com sucesso!");
        } else {
            getFrmCliente().mostrarMensagem("Exclusao nao realizada!");
        }

    }

    void jBLimpar_actionPerformed(ActionEvent e) {
        getFrmCliente().jTClienteId.setText("");
        getFrmCliente().jTNome.setText("");
        getFrmCliente().jTCpf.setText("");
    }

    void jBFechar_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * Retorna o formulário utilizado por este controle.
     */
    public FrmCliente getFrmCliente() {
        return frmCliente;
    }

    /**
     * Modifica o formulário utilizando por este controle.
     *
     * @param frmCliente Um formulario do tipo FrmCliente.
     */
    public void setFrmCliente(FrmCliente frmCliente) {
        this.frmCliente = frmCliente;
    }
}
