package com.afzaal.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.afzaal.modal.DaoImpl.Register;
import com.afzaal.model.CustomerBean;

public class Control {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Register register = new Register();
		System.out.println("<<<<<<----Welcome to Electronic Store--->>>>>>");
		System.out.println("<<<<list of product in Store>>>>");
		System.out.println();
		register.Mana_ShowItem();

		System.out.println("Enter 1)To Buy 2)Exit 3)For Manager");
		int inout = Integer.parseInt(br.readLine());
		if (inout == 1) {
			System.out.println("First register User");
			manager();
		} else if (inout == 2) {
			System.out.println("<<<<<Thnakyou>>>>>");
			System.out.println("Visit Again");
		} else if (inout == 3) {
			System.out.println("THIS IS MANAGER LOGIN PORTAL");
			System.out.println("ENTER TO ADD PRODUCT");
			ShowItem();
		} else {
			System.out.println("enter valid input....");
		}

	}

	public static void ShowItem() {

		Register register = new Register();
		System.out.println("Welcome to electronics Store");
		while (true) {
			try {
				System.out.println("This are the product In our Store");
				register.Mana_ShowItem();
				System.out.println("Enter 1)To add New Product 2)To update Existing product");
				int i = Integer.parseInt(br.readLine());
				if (i == 1) {
					register.Mana_Add();
				} else if (i == 2) {
					register.Mana_Update();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

	public static void manager() {
		CustomerBean bean = new CustomerBean();
		Register register = new Register();
		try {
			
				System.out.println(" Enter input 1) Add User");
				int input = Integer.parseInt(br.readLine());
				if (input == 1) {
					register.Customer_AddUser();
					System.out.println("You have been registered");
					System.out.println("select operation to complete the processes");
				}
				while(true) {
				System.out.println("1)Update User Information");
				System.out.println("2)Show User Information");
				System.out.println("3)Buy Product And Bill");
				System.out.println("4)Delete User Info");
				int process = Integer.parseInt(br.readLine());
				if (process == 1) {
					register.Cust_UpdateDetail();
				} else if (process == 2) {
					register.Cust_showDetail(bean);
				} else if (process == 3) {
					register.product();
				} else if (process == 4) {
					register.product();
				} else {
					System.out.println("Invalid input !!!!!!");
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
