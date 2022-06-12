package co.qwan.home.security;

import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		String result = Sha512DigestUtils.shaHex(rawPassword.toString());
//		System.out.println(rawPassword.toString()+" to "+result);
		return result;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String rawEncoded = Sha512DigestUtils.shaHex(rawPassword.toString());
		return rawEncoded.equals(encodedPassword);
	}

}
