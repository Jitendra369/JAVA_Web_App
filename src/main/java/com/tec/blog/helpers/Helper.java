package com.tec.blog.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {

	public static boolean deleteFile(String filePath) {
		boolean isFileDeleted= false;
		
		try {
			
			File file = new File(filePath);
			isFileDeleted =	file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isFileDeleted;
	}
	
	
	public static boolean saveFile(InputStream is , String path) {
		boolean isFileSaved = false;
		
		try {
			byte[] by = new byte[is.available()];
			is.read(by);
			FileOutputStream fop = new FileOutputStream(path);
			fop.write(by);
			fop.flush();

			isFileSaved = true;
			System.out.println("File has been saved");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isFileSaved;
	}
}
