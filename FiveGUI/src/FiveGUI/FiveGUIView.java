package FiveGUI;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FiveGUIView extends JFrame {
	public JPanel panelContainer;

	public FiveGUIView(String title) throws HeadlessException {
		super(title);
		panelContainer = new JPanel();

		JPanel panelBai1 = new JPanel();
		JLabel labelBai1 = new JLabel("Nhập vào xâu ký tự");
		JTextField fieldBai1 = new JTextField(50);
		JButton buttonBai1 = new JButton("In ra màn hình");
		panelBai1.setLayout(new BorderLayout(10, 0));
		panelBai1.add(labelBai1, BorderLayout.WEST);
		panelBai1.add(fieldBai1, BorderLayout.CENTER);
		panelBai1.add(buttonBai1, BorderLayout.EAST);
		panelContainer.add(panelBai1, BorderLayout.NORTH);

		JPanel panelBai2 = new JPanel();
		panelBai2.setLayout(new BorderLayout());
		JPanel panelBai2Item1 = new JPanel();
		JPanel panelBai2Item2 = new JPanel();
		JLabel labelBai2ChieuDai = new JLabel("Nhập chiều dài");
		JLabel labelBai2ChieuRong = new JLabel("Nhập chiều rộng");
		JTextField fieldBai2ChieuDai = new JTextField(50);
		JTextField fieldBai2ChieuRong = new JTextField(50);
		JButton buttonBai2 = new JButton("Tính toán chu vi, diện tích");
		panelBai2Item1.add(labelBai2ChieuDai);
		panelBai2Item1.add(fieldBai2ChieuDai);
		panelBai2Item2.add(labelBai2ChieuRong);
		panelBai2Item2.add(fieldBai2ChieuRong);
		panelBai2.setLayout(new BorderLayout());
		panelBai2.add(panelBai2Item1, BorderLayout.NORTH);
		panelBai2.add(panelBai2Item2, BorderLayout.SOUTH);
		panelContainer.add(panelBai2);
		panelContainer.add(buttonBai2);

		JPanel panelBai3 = new JPanel();
		panelBai3.setLayout(new BorderLayout());
		JLabel labelBai3 = new JLabel("Nhập vào n");
		JTextField fieldBai3 = new JTextField(50);
		JButton buttonBai3 = new JButton("Tính toán 1 + 2 + 3 + ... + n");

		panelBai3.add(labelBai3, BorderLayout.WEST);
		panelBai3.add(fieldBai3, BorderLayout.CENTER);
		panelBai3.add(buttonBai3, BorderLayout.EAST);

		panelContainer.add(panelBai3);

		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		JPanel panel4Item1 = new JPanel();
		JPanel panel4Item2 = new JPanel();
		JLabel label4BienA = new JLabel("Nhập a");
		JLabel label4BienB = new JLabel("Nhập b");
		JTextField field4BienA = new JTextField(50);
		JTextField field4BienB = new JTextField(50);
		JButton buttonBai4 = new JButton("Tìm nghiệm ax + b = 0");
		panel4Item1.add(label4BienA);
		panel4Item1.add(field4BienA);
		panel4Item2.add(label4BienB);
		panel4Item2.add(field4BienB);
		panel4.setLayout(new BorderLayout());
		panel4.add(panel4Item1, BorderLayout.NORTH);
		panel4.add(panel4Item2, BorderLayout.SOUTH);
		panelContainer.add(panel4);
		panelContainer.add(buttonBai4);

		JPanel panelBai5 = new JPanel();
		panelBai5.setLayout(new BorderLayout());
		JLabel labelBai5 = new JLabel("Nhập vào n");
		JTextField fieldBai5 = new JTextField(50);
		JButton buttonBai5 = new JButton("Kiểm tra nguyên tố");

		panelBai5.add(labelBai5, BorderLayout.WEST);
		panelBai5.add(fieldBai5, BorderLayout.CENTER);
		panelBai5.add(buttonBai5, BorderLayout.EAST);

		panelContainer.add(panelBai5);

		this.add(panelContainer);

		buttonBai1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = fieldBai1.getText();
				if (!s.equals("")) {
					JOptionPane.showMessageDialog(panelContainer, "Bạn vừa nhập chuỗi: " + fieldBai1.getText(),
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(panelContainer, "Chuỗi không được để trống!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonBai2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(fieldBai2ChieuDai.getText());
					int b = Integer.parseInt(fieldBai2ChieuRong.getText());
					if (a <= 0 || b <= 0) {
						JOptionPane.showMessageDialog(panelContainer, "Cách cạnh phải là số dương", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					int chuVi = (a + b) * 2;
					int dienTich = a * b;
					JOptionPane.showMessageDialog(panelContainer, "Chiều dài: " + chuVi + "\nChiều rộng: " + dienTich,
							"Kết quả tính toán", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(panelContainer, "Có lỗi xảy ra! Vui lòng thử lại!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonBai3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int n = Integer.parseInt(fieldBai3.getText());
					if (n <= 0) {
						JOptionPane.showMessageDialog(panelContainer, "Số nhập vào phải là số dương", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					long res = n * (n + 1) / 2;
					JOptionPane.showMessageDialog(panelContainer, "Tổng của 1 + 2 + 3 + ... + n = " + res,
							"Kết quả tính toán", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(panelContainer, "Có lỗi xảy ra! Vui lòng thử lại!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonBai4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(field4BienA.getText());
					int b = Integer.parseInt(field4BienB.getText());
					float res = (float) -b / a;
					String s = "";
					if (a != 0) {
						if (b >= 0) {
							s = "Phương trình " + a + "x + " + b + " = 0 có nghiệm là x = " + res;
						} else {
							s = "Phương trình " + a + "x " + b + " = 0 có nghiệm là x = " + res;
						}
					}
					else {
						if (b != 0) {
							s = "Phương trình vô nghiệm";
						}
						else {
							s = "Phương trình vô số nghiệm";
						}
					}
					JOptionPane.showMessageDialog(panelContainer, s, "Kết quả tính toán",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(panelContainer, "Có lỗi xảy ra! Vui lòng thử lại!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonBai5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int n = Integer.parseInt(fieldBai5.getText());
					boolean check = true;
					if (n < 2) {
						check = false;
					} else {
						for (int i = 2; i <= Math.sqrt(n); i++) {
							if (n % i == 0) {
								check = false;
							}
						}
					}
					String res = check ? n + " là số nguyên tố" : n + " không là số nguyên tố";
					JOptionPane.showMessageDialog(panelContainer, res, "Kết quả kiểm tra",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(panelContainer, "Có lỗi xảy ra! Vui lòng thử lại!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
