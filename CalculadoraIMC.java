import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraIMC extends JFrame {
    // Componentes da interface
    private JTextField campoPeso;
    private JTextField campoAltura;
    private JButton botaoCalcular;
    private JLabel labelResultado;

    // Construtor da classe
    public CalculadoraIMC() {
        // Definir o layout como BorderLayout
        setLayout(new BorderLayout());

        // Criação dos componentes
        campoPeso = new JTextField();
        campoAltura = new JTextField();
        botaoCalcular = new JButton("Calcular");
        labelResultado = new JLabel();

        // Panel para agrupar os componentes
        JPanel painel = new JPanel();

        // Definir o layout do panel como BorderLayout
        painel.setLayout(new BorderLayout());

        // Adicionar os componentes ao painel
        painel.add(new JLabel("Peso (kg): "), BorderLayout.WEST);
        painel.add(campoPeso, BorderLayout.CENTER);
        painel.add(new JLabel("Altura (m): "), BorderLayout.NORTH);
        painel.add(campoAltura, BorderLayout.CENTER);

        // Adicionar o painel à janela principal
        add(painel, BorderLayout.CENTER);
        add(botaoCalcular, BorderLayout.SOUTH);
        add(labelResultado, BorderLayout.NORTH);

        // Definir tamanho e operação de fechar padrão
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Adicionar o ActionListener para o botão de calcular
        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter o peso e a altura digitados nos campos de texto
                double peso = Double.parseDouble(campoPeso.getText());
                double altura = Double.parseDouble(campoAltura.getText());

                // Calcular o IMC usando o método calcularIMC
                double imc = calcularIMC(peso, altura);

                // Exibir o resultado do IMC na labelResultado
                labelResultado.setText("IMC: " + imc);
            }
        });
    }

    // Método para calcular o IMC
    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        // Criar uma instância da classe CalculadoraIMC
        new CalculadoraIMC();
    }
}
