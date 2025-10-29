package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Grafico extends JPanel {

    private final Map<String, Long> temposExecucao;
    private final String met_order;

    public Grafico(Map<String, Long> temposExecucao, String met_order) {
        this.temposExecucao = temposExecucao;
        this.met_order = met_order;
        setPreferredSize(new Dimension(900, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int largura = getWidth();
        int altura = getHeight();
        int margem = 80;
        int larguraBarra = (largura - 2 * margem) / temposExecucao.size();

        long maxTempo = temposExecucao.values().stream().max(Long::compare).orElse(1L);

        g2.setColor(Color.BLACK);
        g2.drawLine(margem, altura - margem, largura - margem, altura - margem);
        g2.drawLine(margem, altura - margem, margem, margem);

        int i = 0;
        for (Map.Entry<String, Long> entry : temposExecucao.entrySet()) {
            String nome = entry.getKey();
            long tempo = entry.getValue();

            int barHeight = (int) ((double) tempo / maxTempo * (altura - 2 * margem));
            int x = margem + i * larguraBarra + 20;
            int y = altura - margem - barHeight;

            g2.setColor(new Color(50, 100 + (i * 30) % 155, 200));
            g2.fillRoundRect(x, y, larguraBarra - 40, barHeight, 10, 10);

            g2.setColor(Color.DARK_GRAY);
            g2.drawRoundRect(x, y, larguraBarra - 40, barHeight, 10, 10);

            g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
            g2.setColor(Color.BLACK);
            g2.drawString(tempo + " ms", x + (larguraBarra / 6), y - 5);

            g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
            Graphics2D gRot = (Graphics2D) g2.create();
            int textX = x + (larguraBarra / 4);
            int textY = altura - margem + 40;
            gRot.rotate(-Math.PI / 4, textX, textY);
            gRot.drawString(nome, textX, textY);
            gRot.dispose();

            i++;
        }

        g2.setFont(new Font("SansSerif", Font.BOLD, 18));
        g2.drawString(met_order, largura / 2 - 150, 50);
    }

    public static void gerarGrafico(Map<String, Long> temposExecucao, String met_order) {
        JFrame frame = new JFrame("Desempenho dos Métodos de Ordenação");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new Grafico(temposExecucao, met_order));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
