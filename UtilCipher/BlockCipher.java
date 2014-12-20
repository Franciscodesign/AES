package UtilCipher;


/**
 * BlockCipher.java TODO:
 * 
 * @author Kim Dinh Son Email:sonkdbk@gmail.com
 */

public abstract class BlockCipher extends Cipher {

	public BlockCipher(int keySize, int blockSize) {
		super(keySize);
		this.blockSize = blockSize;
	}

	public int blockSize;

	public int blockSize() {
		return blockSize;
	}

	public abstract void encrypt(byte[] clearText, int clearOff,
			byte[] cipherText, int cipherOff);

	public abstract void decrypt(byte[] cipherText, int cipherOff,
			byte[] clearText, int clearOff);

	public void encrypt(byte[] clearText, byte[] cipherText) {
		encrypt(clearText, 0, cipherText, 0);
	}

	public void decrypt(byte[] cipherText, byte[] clearText) {
		decrypt(cipherText, 0, clearText, 0);
	}

}
