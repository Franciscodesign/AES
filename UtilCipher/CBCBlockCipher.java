package UtilCipher;


/**
 * CBCBlockCipher.java TODO:
 * 
 * @author Kim Dinh Son Email:sonkdbk@gmail.com
 */

public class CBCBlockCipher extends BlockCipher {

	private BlockCipher blockCipher;
	private byte[] iv;
	private byte[] temp;

	public CBCBlockCipher(BlockCipher blockCipher) {
		super(blockCipher.keySize(), blockCipher.blockSize());
		this.blockCipher = blockCipher;
		iv = new byte[4*blockSize()]; // 16 byte
		zeroBlock(iv);
		temp = new byte[4*blockSize()];
	}

	// Key routines.

	// Set the key.
	public void setKey(byte[] key) {
		blockCipher.setKey(key);
	}

	// IV routines.

	public void setIv(byte[] iv) {
		copyBlock(iv, this.iv);
	}

	public byte[] setRandomIv() {
		byte[] riv = new byte[blockSize()];
		randomBlock128(riv);
		setIv(riv);
		return riv;
	}

	// Block encryption routines.

	public void encrypt(byte[] clearText, int clearOff, byte[] cipherText,
			int cipherOff) {
		xorBlock(clearText, clearOff, iv, 0, temp, 0, blockSize);
		blockCipher.encrypt(temp, 0, cipherText, cipherOff);
		copyBlock(cipherText, cipherOff, iv, 0, blockSize);		
	}

	// / Decrypt a block of bytes.
	public void decrypt(byte[] cipherText, int cipherOff, byte[] clearText,
			int clearOff) {
		blockCipher.decrypt(cipherText, cipherOff, temp, 0);
		xorBlock(temp, 0, iv, 0, clearText, clearOff, blockSize);
		copyBlock(cipherText, cipherOff, iv, 0, blockSize);
	}

}
