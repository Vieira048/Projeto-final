import javax.swing.*;

public class TelaCadastroUsuario extends JFrame {

    private JFrame telaAnterior;

    public TelaCadastroUsuario(JFrame telaAnterior) {
        this.telaAnterior = telaAnterior;

        setTitle("Cadastro de Usuário");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lbUser = new JLabel("Usuário:");
        lbUser.setBounds(30, 30, 100, 25);
        add(lbUser);

        JTextField tfUser = new JTextField();
        tfUser.setBounds(120, 30, 150, 25);
        add(tfUser);

        JLabel lbSenha = new JLabel("Senha:");
        lbSenha.setBounds(30, 70, 100, 25);
        add(lbSenha);

        JPasswordField pfSenha = new JPasswordField();
        pfSenha.setBounds(120, 70, 150, 25);
        add(pfSenha);

        JButton btSalvar = new JButton("Cadastrar");
        btSalvar.setBounds(100, 130, 120, 30);
        add(btSalvar);

        JButton btVoltar = new JButton("Voltar");
        btVoltar.setBounds(100, 170, 120, 30);
        add(btVoltar);

        btVoltar.addActionListener(e -> {
            telaAnterior.setVisible(true);
            dispose();
        });

        btSalvar.addActionListener(e -> {
            Usuario novo = new Usuario(tfUser.getText(), new String(pfSenha.getPassword()));
            BancoDeDados.usuarios.add(novo);

            JOptionPane.showMessageDialog(null, "Usuário cadastrado!");

            limparCampos(tfUser, pfSenha);
        });
    }

    private void limparCampos(JTextField tfUser, JPasswordField pfSenha) {
        tfUser.setText("");
        pfSenha.setText("");
        tfUser.requestFocus();
    }
}
