
import controle.CtrCliente;

/**
 * Classe que possui a operação main da aplicação. Server para dar inicio ao
 * sistema.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 19-abr-2020 22:00:00
 */
public class Principal {

    /**
     * Inicia a aplicaçãoo.
     *
     * @param args args
     */
    public static void main(String[] args) {

        CtrCliente controle = new CtrCliente();
        controle.executar();

    }
}
