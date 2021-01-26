package entidade;

import java.util.List;

import dao.cliente.ClienteDAO;
import dao.DAOFactory;
import dao.Factory;

/**
 * Classe que representa a abstração principal do sistema.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 19-abr-2020 22:00:00
 */
public class Cliente {

    /**
     * Serve para identificar um cliente.
     */
    private String clienteId;
    /**
     * Nome do Cliente.
     */
    private String nome;
    /**
     * CPF do cliente
     */
    private String cpf;

    /**
     * Construtor sem argumentos da classe.
     */
    public Cliente() {
        this("", "", "");
    }

    /**
     * Construtor com argumentos da classe.
     *
     * @param clienteId
     * @param nome
     */
    public Cliente(String clienteId, String nome, String cpf) {
        setClienteId(clienteId);
        setNome(nome);
        setCpf(cpf);
    }

    /**
     * Retorna o id de um cliente.
     */
    public String getClienteId() {
        return clienteId;
    }

    /**
     * Modifica o id de um cliente.
     *
     * @param clienteId Um literal com o id de um cliente.
     */
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setClienteId(int clienteId) {
        setClienteId(clienteId + "");
    }

    /**
     * Retorna o nome de um cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome de um cliente.
     *
     * @param nome Um literal com o nome de um cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o cpf de um cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Modifica o CPF de um cliente.
     *
     * @param cpf Um literal com o cpf de um cliente
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna uma string com o estado do objeto.
     */
    public String paraString() {
        return ("clienteId:" + getClienteId() + " - Nome :" + getNome() + " - CPF :" + getCpf());
    }

    /**
     * Persiste um objeto.
     */
    public boolean inserir() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.inserir(this);
    }

    /**
     * Altera o estado de um objeto persistente.
     */
    public int alterar() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.alterar(this);
    }

    /**
     * Exclui um objeto da persist�ncia atrav�s do identificado.
     */
    public int excluir() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.excluir(this);
    }

    /**
     * Retorna uma lista de objetos que atende os valores passados pelo objeto.
     * O Id realiza compara��o e o nome realiza uma compara��o parcial.
     */
    public List aplicarFiltro() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.aplicarFiltro(this);
    }

    /**
     * Retorna uma lista com todos os objetos.
     */
    public List getLista() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        return clientedao.getLista();
    }

    /**
     * Restaura o estado do objeto apartir do id.
     */
    public boolean abrir() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        List lista = clientedao.aplicarFiltro(this);
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            setNome(oCliente.getNome());
            setCpf(oCliente.getCpf());
            return true;
        } else {
            return false;
        }
    }
}
