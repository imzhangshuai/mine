package com.team.mine.common;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.regex.Pattern;

public class StringHelper {

	private final static char[] HEXES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	protected final static Pattern REPLACE_VARIABLE_PATTERN = Pattern.compile("\\$\\{\\s*(\\w|\\.|-|_|\\$)+\\s*\\}",
			Pattern.CASE_INSENSITIVE);

	/**
	 * 空串
	 */
	public final static String EMPTY_STRING = "";

	@SuppressWarnings("unused")
	private static final byte[] ROW_BYTES = "80e36e39f34e678c".getBytes();

	public static String trim(String value) {
		return value == null ? null : value.trim();
	}

	public static boolean isEmpty(final String value) {
		final int length;
		if (value == null || (length = value.length()) == 0) {
			return true;
		}
		char ch;
		for (int index = 0; index < length; index++) {
			ch = value.charAt(index);
			if (ch == 32 || ch == 160 || Character.isISOControl(ch)) {
				continue;
			}
			return false;
		}
		return true;
	}

	public static void filterHTML(final Appendable writer, final String str) throws IOException {
		if (StringHelper.isEmpty(str)) {
			return;
		}
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (Character.isISOControl(ch)) {
				continue;
			}
			switch (ch) {
			case '<':
			case '>':
			case '"':
			case '\'':
			case '&': {
				writer.append("&#");
				writer.append(Integer.toString(ch));
				writer.append(';');
				break;
			}
			default: {
				writer.append(ch);
			}
			}
		}
	}

	public static void filterQuoter(final Appendable writer, final String str) throws IOException {
		if (StringHelper.isEmpty(str)) {
			return;
		}
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '"') {
				writer.append('\\');
			}
			writer.append(ch);
		}
	}

	public static void filterSingleQuoter(final Appendable writer, final String str) throws IOException {
		if (StringHelper.isEmpty(str)) {
			return;
		}
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '\'') {
				writer.append('\\');
			}
			writer.append(ch);
		}
	}

	/**
	 * 计算摘要.
	 * 
	 * @param content
	 *            待计算的字符串
	 * @return String 十六进制表示
	 * @throws Throwable
	 */
	public static String digest(final String content) throws Throwable {
		if (StringHelper.isEmpty(content)) {
			return content;
		}
		final MessageDigest digest = MessageDigest.getInstance("SHA-1");
		byte[] ciphertext = digest.digest(content.getBytes());
		char[] chars = new char[ciphertext.length + ciphertext.length];
		int i = 0;
		for (final byte element : ciphertext) {
			chars[i++] = HEXES[element & 0xf];
			chars[i++] = HEXES[(element >> 4) & 0xf];
		}
		return new String(chars);
	}

//	public static String encode(final String content) throws Throwable {
//		if (StringHelper.isEmpty(content)) {
//			return content;
//		}
//		Cipher cipher = Cipher.getInstance("AES");
//		SecretKeySpec keySpec = new SecretKeySpec(ROW_BYTES, "AES");
//		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//		byte[] ciphertext = cipher.doFinal(content.getBytes());
//		return Base64.encodeBase64String(ciphertext);
//	}
//
//	public static String decode(final String content) throws Throwable {
//		if (StringHelper.isEmpty(content)) {
//			return content;
//		}
//		Cipher cipher = Cipher.getInstance("AES");
//		SecretKeySpec keySpec = new SecretKeySpec(ROW_BYTES, "AES");
//		cipher.init(Cipher.DECRYPT_MODE, keySpec);
//		byte[] ciphertext = cipher.doFinal(Base64.decodeBase64(content));
//		return new String(ciphertext);
//	}

	public static String truncation(String string, int maxLength) {
		if (isEmpty(string)) {
			return "";
		}
		try {
			StringBuilder out = new StringBuilder();
			truncation(out, string, maxLength, null);
			return out.toString();
		} catch (IOException e) {
			return "";
		}
	}

	public static String truncation(String string, int maxLength, String replace) {
		if (isEmpty(string)) {
			return "";
		}
		try {
			StringBuilder out = new StringBuilder();
			truncation(out, string, maxLength, replace);
			return out.toString();
		} catch (IOException e) {
			return "";
		}
	}

	public static void truncation(Appendable out, String string, int maxLength) throws IOException {
		truncation(out, string, maxLength, null);
	}

	public static void truncation(final Appendable out, final String string, int maxLength, String replace)
			throws IOException {
		if (isEmpty(string) || maxLength <= 0) {
			return;
		}
		if (isEmpty(replace)) {
			replace = "...";
		}
		int index = 0;
		final int end = Math.min(string.length(), maxLength);
		for (; index < end; index++) {
			out.append(string.charAt(index));
		}
		if (string.length() > maxLength) {
			out.append(replace);
		}
	}

}
