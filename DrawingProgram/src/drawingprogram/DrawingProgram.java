/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package drawingprogram;

/**
 *
 * @author dnm14
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DrawingProgram {
    private JFrame frame;
    private JPanel drawingPanel;
    private JComboBox<String> shapeComboBox;
    private JComboBox<String> fillComboBox;
    private JComboBox<String> colorComboBox;
    private JButton drawButton;
    
    public DrawingProgram() {
        frame = new JFrame("Drawing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        drawingPanel = new JPanel();
        drawingPanel.setPreferredSize(new Dimension(400, 400));
        frame.add(drawingPanel, BorderLayout.CENTER);
        
        shapeComboBox = new JComboBox<>(new String[]{"Square", "Rectangle", "Circle", "Polygon"});
        fillComboBox = new JComboBox<>(new String[]{"Empty", "Solid"});
        colorComboBox = new JComboBox<>(new String[]{"Red", "Blue", "Green", "Black"});
        drawButton = new JButton("Draw");
        
        JPanel controlPanel = new JPanel();
        controlPanel.add(shapeComboBox);
        controlPanel.add(fillComboBox);
        controlPanel.add(colorComboBox);
        controlPanel.add(drawButton);
        frame.add(controlPanel, BorderLayout.SOUTH);
        
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawShape();
            }
        });
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void drawShape() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        String selectedFill = (String) fillComboBox.getSelectedItem();
        String selectedColor = (String) colorComboBox.getSelectedItem();
        
        Graphics g = drawingPanel.getGraphics();
        
        if (selectedFill.equals("Solid")) {
            g.setColor(getColor(selectedColor));
            g.fillRect(100, 100, 200, 200);
        } else {
            g.setColor(getColor(selectedColor));
            g.drawRect(100, 100, 200, 200);
        }
        
        if (selectedShape.equals("Circle")) {
            g.fillOval(100, 100, 200, 200);
        } else if (selectedShape.equals("Polygon")) {
            int[] xPoints = {100, 200, 300, 250};
            int[] yPoints = {100, 50, 100, 200};
            int nPoints = 4;
            g.fillPolygon(xPoints, yPoints, nPoints);
        }
    }
    
    private Color getColor(String colorName) {
        switch (colorName) {
            case "Red":
                return Color.RED;
            case "Blue":
                return Color.BLUE;
            case "Green":
                return Color.GREEN;
            case "Black":
                return Color.BLACK;
            default:
                return Color.BLACK;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawingProgram();
            }
        });
    }
}
