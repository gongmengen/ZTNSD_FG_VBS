package com.spider.utils;

import com.lawstar.law.util.FileType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class FileTypeJudge {
	/** * Constructor */
	private FileTypeJudge() {
	}

	/** * 将文件头转换成16进制字符串 * * @param 原生byte * @return 16进制字符串 */
	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/** * 得到文件头 * * @param filePath * 文件路径 * @return 文件头 * @throws IOException */
	private static String getFileContent(String filePath) throws IOException {
		byte[] b = new byte[28];
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
			inputStream.read(b, 0, 28);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}
		return bytesToHexString(b);
	}

	/** * 判断文件类型 * * @param filePath * 文件路径 * @return 文件类型 */
	public static com.lawstar.law.util.FileType getType(String filePath) throws IOException {
		String fileHead = getFileContent(filePath);
		if (fileHead == null || fileHead.length() == 0) {
			return null;
		}
		fileHead = fileHead.toUpperCase();
		System.out.println(fileHead);
		com.lawstar.law.util.FileType[] fileTypes = com.lawstar.law.util.FileType.values();
		for (com.lawstar.law.util.FileType type : fileTypes) {
			if (fileHead.startsWith(type.getValue())) {
				return type;
			}
		}
		return null;
	}
	/** * 判断文件类型 * * @param filePath * 文件路径 * @return 文件类型 */
	public static String getTypeByBytes(byte [] b) throws IOException {
		String fileHead =  bytesToHexString(b);
		if (fileHead == null || fileHead.length() == 0) {
			return null;
		}
		fileHead = fileHead.toUpperCase();
		System.out.println(fileHead);
		com.lawstar.law.util.FileType[] fileTypes = com.lawstar.law.util.FileType.values();
		for (FileType type : fileTypes) {
			if (fileHead.startsWith(type.getValue())) {
				return type.toString();
			}
		}
		return "";
	}
	public static void main(String args[]) throws Exception {
		System.out.println(FileTypeJudge.getType("D:/ee1111.doc"));
	}
}