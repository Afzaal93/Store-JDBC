package com.afzaal.modal.DaoImpl;

import java.sql.Statement;

import com.afzaal.model.CustomerBean;
import com.afzaal.model.Managerbean;
import com.afzaal.model.Dao.WorkDao;
import com.afzaal.model.Utility.Connect;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register implements WorkDao {
	static Connection con;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public void Customer_AddUser() {
		try {
			String demo="demo";
			int Cid=1;
		    con=Connect.creatc();
		    PreparedStatement st=con.prepareStatement("insert into storeinfo (Customername) values(?)");
		    st.setString(1, demo);
		    int check = st.executeUpdate();
			if(check==1) {
				Statement ct = con.createStatement();
				ResultSet set = ct.executeQuery("select * from storeinfo");
				while(set.next()) {
					Cid = set.getInt(1);
					
				}
				System.out.println("Customer Id :-"+Cid);
				System.out.println("Enter Customer Name :-");
				String name = br.readLine();
				CustomerBean bean=new CustomerBean(Cid, name);
				st=con.prepareStatement("update Storeinfo set Customername=? where Cid=?");
				st.setString(1, bean.getCustomername());
				st.setInt(2, Cid);
				st.executeUpdate();
				
			}
			
			
			
			
			
			
			
			
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}


	public static void product() {
		try {
			try {
				con = Connect.creatc();
				String q = "select * from storeinfo inner join managerside where pid=? and cid=?";
				PreparedStatement st = con.prepareStatement(q);
				System.out.println("enter product id:");
				int pid = Integer.parseInt(br.readLine());
				System.out.println("enter customer id:");
				int cid = Integer.parseInt(br.readLine());
				st.setInt(1, pid);
				st.setInt(2, cid);
				ResultSet set = st.executeQuery();
				while (set.next()) {

					System.out.println("Customer id:" + set.getInt(1));
					System.out.println("Customer name:" + set.getString(2));
					System.out.println("Product id :" + set.getInt(6));
					System.out.println("Product    :" + set.getString(3));
					System.out.println("price      :" + set.getInt(4));
					System.out.println("Discount   :" + set.getInt(5) + "%");

					String filename = "C:\\Users\\Techskilkl\\Desktop\\afzaalpdf\\Bill.pdf";
					Document document = new Document();
					PdfWriter.getInstance(document, new FileOutputStream(filename));
					document.open();
					Paragraph paragraph = new Paragraph("<<<<<<CHROMA ELECTRONIC STORE>>>>>>"+"\n"+
							"Customer id		:" + set.getInt(1) + "\n" + "Customer name	   :" + set.getString(2) + "\n"
									+ "Product id		:" + set.getInt(6) + "\n" + "Product		:" + set.getString(3) + "\n"
									+ "price		:" + set.getInt(4) + "\n" + "Discount		:" + set.getInt(5) + "%"+"\n"+"<<<THANKYOU VISIT AGAIN>>>");
					document.add(paragraph);
					document.close();
					System.out.println("Done");

				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			System.out.println("done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void Cust_showDetail(CustomerBean bean) {
		try {
			con = Connect.creatc();
			String q = "select * from StoreInfo";
			Statement stt = con.createStatement();
			ResultSet st = stt.executeQuery(q);
			String filename = "C:\\Users\\Techskilkl\\Desktop\\pdf\\new.pdf";
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			while (st.next()) {
				int id = st.getInt(1);
				String name = st.getString(2);
				

				System.out.println("Id :" + id);
				System.out.println("Customer name:" + name);
				

				PdfPTable table = new PdfPTable(2);
				Paragraph paragraph = new Paragraph("Id" + st.getInt(1) + "\n" + "Customer name:" + st.getString(2));
				document.add(paragraph);
				// document.close();
				System.out.println("Done");

			}
			document.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void Cust_UpdateDetail() {

		try {

			con = Connect.creatc();
			String q = "update Storeinfo set Customername=? where Cid=?";
			PreparedStatement st = con.prepareStatement(q);
			System.out.println("Enter id to update");
			int id = Integer.parseInt(br.readLine());
			System.out.println("enter Name to update");
			String elec = br.readLine();

			st.setInt(2, id);
			st.setString(1, elec);
			st.execute();
			System.out.println("succesfull updated");

		} catch (Exception e) {
			// TODO: handl e.printStackTrace();
		}

	}

	@Override
	public void Cust_Delete() {
		try {
			con = Connect.creatc();
			String q = "Delete from StoreInfo where Cid=?";
			PreparedStatement st = con.prepareStatement(q);

			int id = Integer.parseInt(br.readLine());
			st.setInt(1, id);
			st.execute();

			System.out.println("deleted");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void Mana_Add() {
		try {
			System.out.println("enter id");
			int id = Integer.parseInt(br.readLine());

			System.out.println("Enter product");
			String pro = br.readLine();

			System.out.println(" enter discount");
			int dis = Integer.parseInt(br.readLine());

			System.out.println("Enter price");
			int price = Integer.parseInt(br.readLine());
			Managerbean managerbean = new Managerbean(id, pro, price, dis);

			con = Connect.creatc();
			String q = "insert into managerside values (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(q);
			st.setString(1, managerbean.getProduct());
			st.setInt(2, managerbean.getPrice());
			st.setInt(3, managerbean.getDiscount());
			st.setInt(4, managerbean.getMid());

			st.execute();
			System.out.println(managerbean);
			System.out.println("added new Item");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void Mana_Update() {

		try {
			con = Connect.creatc();
			String q = "update managerside set product=?,price=?,Discount=? where pid=?";
			PreparedStatement st = con.prepareStatement(q);
			System.out.println("Enter id to update");
			int id = Integer.parseInt(br.readLine());

			System.out.println("Enter product to update");
			String pro = br.readLine();

			System.out.println("enter price");
			int price = Integer.parseInt(br.readLine());

			System.out.println("enter discount");
			int dis = Integer.parseInt(br.readLine());

			st.setString(1, pro);
			st.setInt(2, price);
			st.setInt(3, dis);
			st.setInt(4, id);

			st.execute();
			System.out.println("Updated");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void Mana_ShowItem() {
		try {
			con = Connect.creatc();
			String q = "select * from managerside";
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(q);

			while (set.next()) {
				System.out.println("Product id :" + set.getInt(4));
				System.out.println("Product    :" + set.getString(1));
				System.out.println("price      :" + set.getInt(2));
				System.out.println("Discount   :" + set.getInt(3) + "%");
				System.out.println("------------------");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
