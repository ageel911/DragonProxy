/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

public class PlayerFall extends Packet {

	public static final byte ID = (byte)37;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public float distance;

	public PlayerFall() {}

	public PlayerFall(float distance) {
		this.distance = distance;
	}

	@Override
	public int length() {
		return 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeLittleEndianFloat(distance);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		distance=readLittleEndianFloat();
	}

	public static PlayerFall fromBuffer(byte[] buffer) {
		PlayerFall ret = new PlayerFall();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerFall(distance: " + this.distance + ")";
	}

}
