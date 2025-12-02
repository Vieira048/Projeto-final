import javax.swing.*;

public class TelaCadastroProduto extends JFrame {

    private JFrame telaAnterior;

    public TelaCadastroProduto(JFrame telaAnterior) {
        this.telaAnterior = telaAnterior;

        setTitle("Cadastro de Produto");
        setSize(400, 330);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lbNome = new JLabel("Nome:");
        lbNome.setBounds(30, 40, 120, 25);
        add(lbNome);

        JTextField tfNome = new JTextField();
        tfNome.setBounds(150, 40, 180, 25);
        add(tfNome);

        JLabel lbQtd = new JLabel("Quantidade:");
        lbQtd.setBounds(30, 90, 120, 25);
        add(lbQtd);

        JTextField tfQtd = new JTextField();
        tfQtd.setBounds(150, 90, 180, 25);
        add(tfQtd);

        JLabel lbPreco = new JLabel("Preço:");
        lbPreco.setBounds(30, 140, 120, 25);
        add(lbPreco);

        JTextField tfPreco = new JTextField();
        tfPreco.setBounds(150, 140, 180, 25);
        add(tfPreco);

        JButton btSalvar = new JButton("Salvar");
        btSalvar.setBounds(140, 210, 120, 30);
        add(btSalvar);

        JButton btVoltar = new JButton("Voltar");
        btVoltar.setBounds(140, 250, 120, 30);
        add(btVoltar);

        btVoltar.addActionListener(e -> {
            telaAnterior.setVisible(true);
            dispose();
        });

        btSalvar.addActionListener(e -> {
            Produto p = new Produto(
                BancoDeDados.produtos.size() + 1,
                tfNome.getText(),
                Integer.parseInt(tfQtd.getText()),
                Double.parseDouble(tfPreco.getText())
            );

            BancoDeDados.produtos.add(p);
            JOptionPane.showMessageDialog(null, "Produto cadastrado!");

            limparCampos(tfNome, tfQtd, tfPreco);
        });
    }

    private void limparCampos(JTextField tfNome, JTextField tfQtd, JTextField tfPreco) {
        tfNome.setText("");
        tfQtd.setText("");
        tfPreco.setText("");
        tfNome.requestFocus();
    }
}
