package AES;

import UtilCipher.Printer;

/**
 * TestAES.java
 * TODO: 
 *
 * @author Kim Dinh Son
 * Email:sonkdbk@gmail.com
 */

public class TestAES { 
	public static void main(String[] args){
		String plaintext = "328831e0435a3137f6309807a88da234";
		String cipherKey = "2b28ab097eaef7cf15d2154f16a6883c";
		AES aes = new AES(4,4); 
		// AES-128: keySize = 4, blockSize = 4
		// result = 3902dc1925dc116a8409850b1dfb9732
		aes.encrypt(aes.toByteArray(plaintext), aes.toByteArray(cipherKey));
		Printer.printVector(aes.getCipherT());
		
		System.out.println();
		aes.decrypt(aes.getCipherT(), aes.toByteArray(cipherKey));
		Printer.printVector(aes.getClearT());
	}
}
