import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JFrame {

    private JPanel contentPane;
    private JTextField tfUsuario;
    private JPasswordField pfSenha;
    private int tentativa = 0;

    public TelaLogin() {
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbUsuario = new JLabel("Usuário:");
        lbUsuario.setForeground(Color.WHITE);
        lbUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        lbUsuario.setBounds(70, 100, 100, 20);
        contentPane.add(lbUsuario);

        tfUsuario = new JTextField();
        tfUsuario.setBounds(150, 100, 180, 25);
        contentPane.add(tfUsuario);

        JLabel lbSenha = new JLabel("Senha:");
        lbSenha.setForeground(Color.WHITE);
        lbSenha.setFont(new Font("Arial", Font.BOLD, 16));
        lbSenha.setBounds(70, 150, 100, 20);
        contentPane.add(lbSenha);

        pfSenha = new JPasswordField();
        pfSenha.setBounds(150, 150, 180, 25);
        contentPane.add(pfSenha);

        JButton btEntrar = new JButton("Entrar");
        btEntrar.setBounds(160, 210, 120, 35);
        contentPane.add(btEntrar);

        btEntrar.addActionListener(e -> {
            Usuario u = BancoDeDados.autenticar(
                tfUsuario.getText(),
                new String(pfSenha.getPassword())
            );

            if (u != null) {
                JOptionPane.showMessageDialog(null, "Login realizado!");
                new TelaMenu().setVisible(true);
                dispose();
            } else {
                tentativa++;
                JOptionPane.showMessageDialog(null, "Usuário/Senha incorretos (" + tentativa + "/3)");

                if (tentativa >= 3) {
                    btEntrar.setEnabled(false);
                    tfUsuario.setEditable(false);
                    pfSenha.setEditable(false);
                }
            }

            limparCampos();
        });

        JButton cadastro = new JButton("Cadastrar Usuário");
        cadastro.setBounds(140, 180, 160, 20);
        cadastro.setContentAreaFilled(false);
        cadastro.setBorderPainted(false);
        cadastro.setForeground(Color.YELLOW);
        contentPane.add(cadastro);

        cadastro.addActionListener(e -> {
            new TelaCadastroUsuario(this).setVisible(true);
            setVisible(false);
        });

        contentPane.setBackground(new Color(40, 40, 40));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void limparCampos() {
        tfUsuario.setText("");
        pfSenha.setText("");
        tfUsuario.requestFocus();
    }
}
