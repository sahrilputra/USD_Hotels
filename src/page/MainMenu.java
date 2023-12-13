package page;

import Components.CustomCardPanel;
import Components.navHeader;
import Components.navbar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.displayHomePage();
        });
    }

    public void displayHomePage() {

        frame = new JFrame("Homepage");
        frame.setSize(949, 758);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setUndecorated(false);

        frame.setLayout(new BorderLayout());

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        navHeader navHeader = new navHeader();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        navbar navbar = new navbar(cardLayout, cardPanel);

        navPanel.add(navHeader);
        navPanel.add(navbar);

        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);

        cardPanel = new JPanel(new GridLayout(0, 1));
        cardPanel.setPreferredSize(new Dimension(400, 300 * 5));
        cardPanel = new JPanel(new GridLayout(0, 1, 0, 10));
        cardLayout = new CardLayout();

        List<CustomCardPanel> homeCards = createHomePage();
        for (CustomCardPanel homeCard : homeCards) {
            cardPanel.add(homeCard);
        }

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private List<CustomCardPanel> createHomePage() {
        List<CustomCardPanel> homeCards = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CustomCardPanel homeCard = new CustomCardPanel();
            homeCard.setPreferredSize(new Dimension(400, 300));
            homeCard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            homeCards.add(homeCard);
        }

        return homeCards;
    }
}
