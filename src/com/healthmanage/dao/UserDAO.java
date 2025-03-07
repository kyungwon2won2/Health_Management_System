package com.healthmanage.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

import com.healthmanage.model.Gym;

public class UserDAO {
	private static final String USER_FILE = "C:\\Temp\\infousers.txt";
	private static final String ADMIN_FILE = "C:\\Temp\\infoadmins.txt";
	private static final String COUPON_FILE = "C:\\Temp\\infocoupons.txt";

	public void infoSave(Object obj, String filePath) {
		File file = new File(filePath);

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);

			oos.writeObject(obj);
		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			try {
				fos.close();
				bos.close();
				oos.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	Object infoLoad(String filePath) {
		File file = new File(filePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			return ois.readObject();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		} finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception

			}
		}
	}
	
	 public void saveUsers() {
	        infoSave(Gym.users, USER_FILE);
	    }
	 
	 public void saveAdmins() {
	        infoSave(Gym.admins, ADMIN_FILE);
	    }
	 
	 public void saveCoupons() {
	        infoSave(Gym.coupons, COUPON_FILE);
	    }
	 
	 public void loadUsers() {
		 infoLoad(USER_FILE);
	    }
	 
	 public void loadAdmins() {
		 infoLoad(ADMIN_FILE);
	    }
	 
	 public void loadCoupons() {
		 infoLoad(COUPON_FILE);
	    }
}
