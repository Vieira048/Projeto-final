import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaListaProdutos extends JFrame {

    private JFrame telaAnterior;

    public TelaListaProdutos(JFrame telaAnterior) {
        this.telaAnterior = telaAnterior;

        setTitle("Lista de Produtos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        String[] colunas = {"ID", "Nome", "Quantidade", "Preço"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Produto p : BancoDeDados.produtos) {
            modelo.addRow(new Object[]{
                p.getId(), p.getNome(), p.getQuantidade(), p.getPreco()
            });
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 20, 550, 280);
        add(scroll);

        JButton btVoltar = new JButton("Voltar");
        btVoltar.setBounds(240, 320, 120, 30);
        add(btVoltar);

        btVoltar.addActionListener(e -> {
            telaAnterior.setVisible(true);
            dispose();
        });
    }
}
