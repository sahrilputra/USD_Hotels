package page;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import Data.CreateRooms;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Rooms extends JFrame {
    private JList<String> roomList;

    public Rooms(List<String> rooms) {
        setTitle("Hotel Rooms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(949, 758);
        setLocationRelativeTo(null);
        roomList = new JList<>(rooms.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(roomList);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        try {
            URL imageUrl = new URL(
                    "https://media.sketchfab.com/models/9f829643fdc242408ef4e380bf8e14cc/thumbnails/0484fb3f49c7405c89a5fc28e7c6ba92/51241fadfc1a4d79bb91d7aaa6ea2996.jpeg");
            BufferedImage image = ImageIO.read(imageUrl);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            getContentPane().add(imageLabel, BorderLayout.NORTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<String> rooms = new ArrayList<>();
            CreateRooms createRooms = new CreateRooms();
            createRooms.addRoom("Room 102");
            createRooms.addRoom("Room 102");
            createRooms.addRoom("Room 103");

            Rooms frame = new Rooms(rooms);
            frame.setVisible(true);
        });
    }
}
