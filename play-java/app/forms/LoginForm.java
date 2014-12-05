package forms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginForm {
	public String login;
	public String password;

	public String getHashedPassword() {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA1");

			byte[] b = md.digest(this.password.getBytes());
			String result = "";
			for (int i = 0; i < b.length; i++) {
				result += Integer.toString((b[i] & 0xff) + 0x100, 16)
						.substring(1);
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
