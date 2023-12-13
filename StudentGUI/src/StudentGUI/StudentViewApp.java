package StudentGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentViewApp extends JFrame {
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton readButton;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton resetButton;

	private JTextField textId;
	private JTextField textName;
	private JTextField textClassName;
	private JTextField textGpa;

	private static String DB_URL = "jdbc:mysql://localhost:3306/jframe";
	private static String USER_NAME = "root";
	private static String PASSWORD = "quangminh1";

	public StudentViewApp(String title) throws HeadlessException, ClassNotFoundException, SQLException {
		super(title);

		tableModel = new DefaultTableModel(new String[] { "Mã sinh viên", "Họ và tên", "Lớp", "Email" }, 0);
		table = new JTable(tableModel);

		readButton = new JButton("Đọc từ file");
		render();
		addButton = new JButton("Thêm mới");
		editButton = new JButton("Sửa dữ liệu");
		deleteButton = new JButton("Xóa dữ liệu");
		resetButton = new JButton("Reset dữ liệu");

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(resetButton);

		JPanel textPanel = new JPanel();
		textId = new JTextField(50);
		textName = new JTextField(50);
		textClassName = new JTextField(50);
		textGpa = new JTextField(50);
		textPanel.add(textId);
		textPanel.add(textName);
		textPanel.add(textClassName);
		textPanel.add(textGpa);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				String id = textId.getText();
				String name = textName.getText();
				String className = textClassName.getText();
				String gpa = textGpa.getText();
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					String sql = "insert into sinhvien values (?,?,?,?) ";
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1,Integer.parseInt(id));
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, className);
					preparedStatement.setFloat(4, (float) Double.parseDouble(gpa));
					int resultSet = preparedStatement.executeUpdate();
					render();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				String id = textId.getText();
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					String sql = "delete from sinhvien where id = ? ";
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1,Integer.parseInt(id));
					int resultSet = preparedStatement.executeUpdate();
					render();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				String id = textId.getText();
				String name = textName.getText();
				String className = textClassName.getText();
				String gpa = textGpa.getText();
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					String sql = "update sinhvien set name = ?, class_name = ?, gpa = ? where id = ? ";
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(4,Integer.parseInt(id));
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, className);
					preparedStatement.setFloat(3, (float) Double.parseDouble(gpa));
					int resultSet = preparedStatement.executeUpdate();
					render();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				reset();
				textId.setText("");
				textName.setText("");
				textClassName.setText("");
				textGpa.setText("");
				String sql = "delete from sinhvien";
				PreparedStatement preparedStatement;
				try {
					connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
					preparedStatement = connection.prepareStatement(sql);
					int resultSet = preparedStatement.executeUpdate();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					render();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		this.setLayout(new BorderLayout());
		this.add(buttonPanel, BorderLayout.NORTH);
		this.add(textPanel, BorderLayout.CENTER);
		this.add(new JScrollPane(table), BorderLayout.EAST);
	}
	
	private void render() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		ArrayList<SinhVien> sinhVienList = new ArrayList<>();
		try {
			String sql = "select * from sinhvien s ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SinhVien sinhVien = new SinhVien(resultSet.getString("id"), resultSet.getString("name"),
						resultSet.getString("class_name"), resultSet.getFloat("gpa"));

				sinhVienList.add(sinhVien);
				tableModel.addRow(new String[] { sinhVien.getId(), sinhVien.getName(), sinhVien.getClassName(),
						sinhVien.getGpa() + "" });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void reset() {
		for (int row = 0; row < tableModel.getRowCount(); row++) {
			String id = tableModel.getValueAt(row, 0).toString();
			String name = tableModel.getValueAt(row, 1).toString();
			String className = tableModel.getValueAt(row, 2).toString();
			double gpa = Double.parseDouble(tableModel.getValueAt(row, 3).toString());
		}

		tableModel.setRowCount(0);
	}

}
