package dao;

/**
 * Interface que armazena os dados de configuracao do banco de dados SQLite.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 19-abr-2020 22:00:00
 */
public interface SQLiteDadosBanco {

    //Altere aqui os dados do seu banco de dados	
    public String DATABASE = "cliente.db";
    public String DRIVER = "org.sqlite.JDBC";
}
