package net.joyfun.file;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Iconv {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		cpEncDir("F:/movie/Root", "F:/movie/Test");
	}

	public static File[] listDir(String path) {
		File[] fileList = null;
		File aFile = new File(path);
		if (aFile.isDirectory()) {
			fileList = aFile.listFiles();
		}
		return fileList;
	}

	public static void cpEncDir(String fromdir, String toDir)
			throws UnsupportedEncodingException {
		File[] afileList = listDir(fromdir);
		File[] tolist = new File[afileList.length];
		ChangeCharset test = new ChangeCharset();
		for (int i = 0; i < afileList.length; i++) {

			tolist[i] = new File(toDir + "/"
					+ test.toUTF_8(afileList[i].getName()));
			if (afileList[i].isDirectory()) {
				tolist[i].mkdirs();
				cpEncDir(afileList[i].getPath(), tolist[i].getPath());
			} else {
				System.out.println(tolist[i].getPath());
				afileList[i].renameTo(tolist[i]);
			}

		}
	}

}
