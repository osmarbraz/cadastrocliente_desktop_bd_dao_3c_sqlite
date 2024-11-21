package dao;

import dao.cliente.ClienteDAO;

/**
 * Abstrai as fontes de dados do sistema.
 *
 * @author osmarbraz
 */
public abstract class DAOFactory {

    //Tipos de Fonte de Dados suportados pela Factory
    public static final int SQLITE = 1;

    //Retorna o DAO instanciado
    public abstract ClienteDAO getClienteDAO();

    //Retorna a Factory do tipo especificado	
    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case SQLITE:
                return new SQLiteDAOFactory();
            default:
                return null;
        }
    }
}
