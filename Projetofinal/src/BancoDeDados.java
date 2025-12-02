import java.util.ArrayList;

public class BancoDeDados {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Produto> produtos = new ArrayList<>();

    static {
        usuarios.add(new Usuario("admin", "123"));
    }

    public static Usuario autenticar(String usuario, String senha) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }
}
