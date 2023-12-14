package page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class BookingPanel {

    private JFrame frame;

    public BookingPanel() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Hotel Booking");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        createBookingPanel();

        frame.setVisible(true);
    }

    private void createBookingPanel() {
        JPanel bookingPanel = new JPanel(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Hotel Booking Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel);

        // Room Information
        JPanel roomInfoPanel = new JPanel();
        roomInfoPanel.setLayout(new BoxLayout(roomInfoPanel, BoxLayout.Y_AXIS));

        // Image
        ImageIcon hotelImage = new ImageIcon("hotel_image.jpg"); // Add your hotel image path
        JLabel imageLabel = new JLabel(hotelImage);
        roomInfoPanel.add(imageLabel);

        // Room details
        JLabel roomDetailsLabel = new JLabel("Deluxe Room - King Bed");
        roomInfoPanel.add(roomDetailsLabel);

        // Price
        JLabel priceLabel = new JLabel("Price per night: $150");
        roomInfoPanel.add(priceLabel);

        // Date Selection
        JPanel datePanel = new JPanel();
        JLabel checkinLabel = new JLabel("Check-in Date:");
        UtilDateModel checkinModel = new UtilDateModel();
        JDatePanel checkinDatePanel = new JDatePanelImpl(checkinModel); // Modify this line
        JDatePicker checkinDatePicker = new JDatePickerImpl(checkinDatePanel, null); // Modify this line
        datePanel.add(checkinLabel);
        datePanel.add(checkinDatePicker);

        JLabel checkoutLabel = new JLabel("Check-out Date:");
        UtilDateModel checkoutModel = new UtilDateModel();
        JDatePanel checkoutDatePanel = new JDatePanelImpl(checkoutModel); // Modify this line
        JDatePicker checkoutDatePicker = new JDatePickerImpl(checkoutDatePanel, null); // Modify this line
        datePanel.add(checkoutLabel);
        datePanel.add(checkoutDatePicker);

        // Guest Information
        JPanel guestInfoPanel = new JPanel();
        guestInfoPanel.setLayout(new BoxLayout(guestInfoPanel, BoxLayout.Y_AXIS));

        JLabel guestsLabel = new JLabel("Number of Guests:");
        JTextField guestsField = new JTextField(5);

        JLabel guestNamesLabel = new JLabel("Guest Names:");
        JTextArea guestNamesTextArea = new JTextArea(4, 20);
        JScrollPane guestNamesScrollPane = new JScrollPane(guestNamesTextArea);

        guestInfoPanel.add(guestsLabel);
        guestInfoPanel.add(guestsField);
        guestInfoPanel.add(guestNamesLabel);
        guestInfoPanel.add(guestNamesScrollPane);

        JButton bookButton = new JButton("Book Now");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement booking logic
                String checkinDate = checkinDatePicker.getJFormattedTextField().getText();
                String checkoutDate = checkoutDatePicker.getJFormattedTextField().getText();
                String numGuests = guestsField.getText();
                String guestNames = guestNamesTextArea.getText();

                // You can add your booking logic here

                JOptionPane.showMessageDialog(frame, "Booking Successful!");
                frame.dispose();
            }
        });

        // Price Information
        JPanel pricePanel = new JPanel();
        JLabel totalPriceLabel = new JLabel("Total Price: $300"); // You can calculate the total price based on the
                                                                  // selected dates and room rate
        pricePanel.add(totalPriceLabel);

        // Add components to booking panel
        bookingPanel.add(headerPanel, BorderLayout.NORTH);
        bookingPanel.add(roomInfoPanel, BorderLayout.CENTER);
        bookingPanel.add(datePanel, BorderLayout.WEST);
        bookingPanel.add(guestInfoPanel, BorderLayout.EAST);
        bookingPanel.add(bookButton, BorderLayout.SOUTH);
        bookingPanel.add(pricePanel, BorderLayout.SOUTH);

        // Add booking panel to the frame
        frame.add(bookingPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookingPanel bookingPanel = new BookingPanel();
        });
    }
}