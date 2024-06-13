import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppRobo {
    private JFrame jFrame;
    private JTextField txtId, txtNome, txtModelo;
    private JTextArea textArea;
    private CadastraRobo cadastraRobo;

    public AppRobo() {
        cadastraRobo = new CadastraRobo();
        initialize();
    }


    private void initialize() {

        jFrame = new JFrame("Cadastro robo");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(400, 300);
        jFrame.setLayout(new BorderLayout());

        JPanel panelF = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Arial", Font.BOLD, 14));
        panelF.add(lblId, gbc);

        Dimension dim = new Dimension(200, 20);
        txtId = new JTextField();
        txtId.setPreferredSize(dim);
        panelF.add(txtId, gbc);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 14));
        panelF.add(lblNome, gbc);

        txtNome = new JTextField();
        txtNome.setPreferredSize(dim);
        panelF.add(txtNome, gbc);

        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[a-zA-Z\\s]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z\\s]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(new Font("Arial", Font.BOLD, 14));
        panelF.add(lblModelo, gbc);

        txtModelo = new JTextField();
        txtModelo.setPreferredSize(dim);
        panelF.add(txtModelo, gbc);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarRobo();
            }
        });
        panelF.add(btnCadastrar);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        panelF.add(btnLimpar);

        jFrame.add(panelF, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        jFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelBotao = new JPanel();
        panelBotao.setLayout(new GridLayout(1, 2));

        JButton btnListar = new JButton("Listar robos");
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarRobos();
            }
        });
        panelBotao.add(btnListar);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        panelBotao.add(btnFechar);

        jFrame.add(panelBotao, BorderLayout.SOUTH);

        jFrame.setVisible(true);
    }


    private void cadastrarRobo() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String modelo = txtModelo.getText();

            if (nome.isBlank() || modelo.isBlank()) {
                throw new IllegalArgumentException("Nome e modelo são obrigatórios.");
            }

            Robo robo = new Robo(id, nome, modelo);
            cadastraRobo.adicionarRobo(robo);

            textArea.setText("Robô cadastrado com sucesso.\n" + robo);
        } catch (NumberFormatException e) {
            textArea.setText("ID deve ser um número inteiro.");
        } catch (IllegalArgumentException e) {
            textArea.setText(e.getMessage());
        } catch (Exception e) {
            textArea.setText("Erro inesperado: " + e.getMessage());
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtModelo.setText("");
        textArea.setText("");
    }

    private void listarRobos() {
        textArea.setText(cadastraRobo.listarRobo());
    }
}
