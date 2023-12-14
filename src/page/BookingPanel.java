package page;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class BookingPanel extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hotel Booking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Room Information Panel
        JPanel roomInfoPanel = new JPanel();
        roomInfoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomInfoPanel.setLayout(new BoxLayout(roomInfoPanel, BoxLayout.Y_AXIS));

        // Room details
        JLabel roomDetailsLabel = new JLabel("Deluxe Room - King Bed");
        roomDetailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomInfoPanel.add(roomDetailsLabel);

        // Price
        JLabel priceLabel = new JLabel("Price per night: $150");
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roomInfoPanel.add(priceLabel);

        mainPanel.add(roomInfoPanel);

        // Date Selection Panel
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
        JPanel dateSelectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dateSelectionPanel.add(new JLabel("Check-in Date:"));
        dateSelectionPanel.add(datePicker);
        dateSelectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(dateSelectionPanel);

        // Guest Information Panel
        JPanel guestInfoPanel = new JPanel();
        guestInfoPanel.setLayout(new BoxLayout(guestInfoPanel, BoxLayout.Y_AXIS));

        // Number of Guests Selector (set to 1, 2, 3, 4)
        Integer[] guestNumbers = {1, 2, 3, 4};
        JComboBox<Integer> guestsSelector = new JComboBox<>(guestNumbers);
        guestInfoPanel.add(new JLabel("Number of Guests:"));
        guestInfoPanel.add(guestsSelector);

        // Guest Name
        JTextField guestNameField = new JTextField(10); // Adjusted size
        guestInfoPanel.add(new JLabel("Guest Name:"));
        guestInfoPanel.add(guestNameField);

        mainPanel.add(guestInfoPanel);

        // Book button
        JButton bookButton = new JButton("Book Now");
        bookButton.addActionListener(e -> {
            Date selectedDate = (Date) model.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String checkinDate = sdf.format(selectedDate);
            int numGuests = (int) guestsSelector.getSelectedItem();
            String guestName = guestNameField.getText();

            JOptionPane.showMessageDialog(frame, "Booking Successful!\nCheck-in Date: " + checkinDate +
                    "\nNumber of Guests: " + numGuests + "\nGuest Name: " + guestName);
        });

        bookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bookButton);

        // Set up the main frame layout
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
