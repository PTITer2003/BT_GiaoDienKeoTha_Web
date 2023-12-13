package database;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
	ArrayList<TacGia> data = new ArrayList<TacGia>();

	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");

				TacGia tacgia = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				ketQua.add(tacgia);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia where matacgia = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");

				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				break;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
	private String getDateTimeSql(TacGia t) {
		int day = t.getNgaySinh().getDate();
		int month = t.getNgaySinh().getMonth() + 1;
		int year = t.getNgaySinh().getYear() + 1900;
		return year + "-" + month + "-" + day;
	}

	@Override
	public int insert(TacGia t) {
		int kq = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO tacgia (matacgia, hovaten, ngaysinh, tieusu) values (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			st.setString(2, t.getHoVaTen());
			st.setDate(3, java.sql.Date.valueOf(getDateTimeSql(t)));
			st.setString(4, t.getTieuSu());

			// Bước 3: thực thi câu lệnh SQL
			kq = st.executeUpdate();

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.insert(tacGia);
		}
		return dem;
	}

	@Override
	public int delete(TacGia t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE from tacgia WHERE matacgia = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			
			System.out.println(sql);
			kq = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + kq + " dòng bị thay đổi");
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.delete(tacGia);
		}
		return dem;
	}

	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE tacgia "+
					 " SET " +
					 " hovaten=?"+
					 ", ngaysinh=?"+
					 ", tieusu=?"+
					 " WHERE matacgia=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoVaTen());
			st.setDate(2, java.sql.Date.valueOf(getDateTimeSql(t)));
			st.setString(3, t.getTieuSu());
			st.setString(4, t.getMaTacGia());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	public static void main(String[] args) {
		TacGiaDAO tgd = new TacGiaDAO();
		
//		tgd.delete(new TacGia("TG4", null, null, null));
		
		tgd.update(new TacGia("TG5", "Nguyễn Xuân Sáng", new Date("2003/01/01"), "Xin chào, tôi tên là Sáng"));
		
		ArrayList<TacGia> kq = tgd.selectAll();
		for (TacGia tacGia : kq) {
			System.out.println(tacGia);
		}
	}
}
