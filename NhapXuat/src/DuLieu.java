import java.util.Scanner;

public class DuLieu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao name: ");
		String name = sc.nextLine();
		System.out.println("Nhap vao so nguyen: ");
		long num = sc.nextLong();
		System.out.println("Nhap vao so thap phan: ");
		float tp = sc.nextFloat();
		
		System.out.println("Du lieu in ra: " + name + " " + num + " " + tp);
	}
}
