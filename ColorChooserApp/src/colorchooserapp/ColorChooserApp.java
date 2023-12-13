/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colorchooserapp;

/**
 *
 * @author dnm14
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Tạo một mảng màu để hiển thị trong JComboBox
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange"};

        // Tạo JComboBox với danh sách màu
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        frame.add(colorComboBox, BorderLayout.NORTH);

        JPanel colorPanel = new JPanel();
        frame.add(colorPanel, BorderLayout.CENTER);

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                if (selectedColor != null) {
                    switch (selectedColor) {
                        case "Red":
                            colorPanel.setBackground(Color.RED);
                            break;
                        case "Green":
                            colorPanel.setBackground(Color.GREEN);
                            break;
                        case "Blue":
                            colorPanel.setBackground(Color.BLUE);
                            break;
                        case "Yellow":
                            colorPanel.setBackground(Color.YELLOW);
                            break;
                        case "Orange":
                            colorPanel.setBackground(Color.ORANGE);
                            break;
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
