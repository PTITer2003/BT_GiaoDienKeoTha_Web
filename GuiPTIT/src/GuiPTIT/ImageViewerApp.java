package GuiPTIT;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ImageViewerApp extends JFrame implements ActionListener{
	private JPanel imagePanel;
	private JButton openButton;
	private JFileChooser fileChooser;

	public ImageViewerApp(String title) throws HeadlessException {
		super(title);
		setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

		imagePanel = new JPanel();
		imagePanel.setLayout(new FlowLayout());
		
		scrollPane.setViewportView(imagePanel);

		openButton = new JButton("Open Image");
		fileChooser = new JFileChooser();

		openButton.addActionListener(this);

		add(openButton, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			displayImage(selectedFile);
		}
	}

	private void displayImage(File file) {
		try {
			BufferedImage image = ImageIO.read(file);
			Image scaledImage = image.getScaledInstance(800, -1, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(icon);
			imagePanel.add(label);
			revalidate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
