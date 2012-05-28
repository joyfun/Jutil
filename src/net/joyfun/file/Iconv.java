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
		if(args.length<3){
			System.out.println("usage:Iconv sourcedir todir encoding ");
		}
		cpEncDir(args[0], args[1],args[2]);
//		cpEncDir("F:/movie/Root", "F:/movie/Test","UTF-8");
	}

	public static File[] listDir(String path) {
		File[] fileList = null;
		File aFile = new File(path);
		if (aFile.isDirectory()) {
			fileList = aFile.listFiles();
		}
		return fileList;
	}
/**
 * recreate folder and move files
 * @param fromdir
 * @param toDir
 * @param encoding
 * @throws UnsupportedEncodingException
 */
	public static void cpEncDir(String fromdir, String toDir,String encoding)
			throws UnsupportedEncodingException {
		if(null==encoding){
			encoding="UTF-8";
		}
		File[] afileList = listDir(fromdir);
		File[] tolist = new File[afileList.length];
		ChangeCharset test = new ChangeCharset();
		for (int i = 0; i < afileList.length; i++) {

			tolist[i] = new File(toDir + "/"
					+ test.changeCharset(afileList[i].getName(),encoding));
			if (afileList[i].isDirectory()) {
				tolist[i].mkdirs();
				cpEncDir(afileList[i].getPath(), tolist[i].getPath(),encoding);
			} else {
				afileList[i].renameTo(tolist[i]);
				
			}
	//		System.out.println(tolist[i].getPath());

		}
	}

}
