import javax.swing.*;

public class TelaMenu extends JFrame {

    public TelaMenu() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton btCadastrar = new JButton("Cadastrar Produto");
        btCadastrar.setBounds(100, 50, 200, 30);
        add(btCadastrar);

        JButton btListar = new JButton("Listar Produtos");
        btListar.setBounds(100, 100, 200, 30);
        add(btListar);

        JButton btSair = new JButton("Sair");
        btSair.setBounds(100, 150, 200, 30);
        add(btSair);

        btCadastrar.addActionListener(e -> {
            new TelaCadastroProduto(this).setVisible(true);
            setVisible(false);
        });

        btListar.addActionListener(e -> {
            new TelaListaProdutos(this).setVisible(true);
            setVisible(false);
        });

        btSair.addActionListener(e -> System.exit(0));
    }
}
