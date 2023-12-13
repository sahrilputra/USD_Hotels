package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class navbar extends JPanel {
    private JLabel mainMenuLabel;
    private JLabel historyLabel;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public navbar(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        mainMenuLabel = new JLabel("Home");
        historyLabel = new JLabel("History");

        historyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Ganti ke halaman riwayat saat label "History" diklik
                cardLayout.show(cardPanel, "historyPage");
            }
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.decode("#AA323C"));

        add(mainMenuLabel);
        add(Box.createHorizontalStrut(10));
        add(historyLabel);

        mainMenuLabel.setForeground(Color.WHITE);
        mainMenuLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        historyLabel.setForeground(Color.WHITE);
        historyLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        mainMenuLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        historyLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
    }
}