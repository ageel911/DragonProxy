/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *                       Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *
 * You can view LICENCE file for details. 
 *
 * @author The Dragonet Team
 */
package org.dragonet.proxy.network.translator.pe;

import org.dragonet.proxy.network.ClientConnection;
import org.dragonet.proxy.network.translator.PEPacketTranslator;
import org.spacehq.mc.protocol.data.MagicValues;
import org.spacehq.mc.protocol.data.game.entity.metadata.Position;
import org.spacehq.mc.protocol.data.game.entity.player.Hand;
import org.spacehq.mc.protocol.data.game.world.block.BlockFace;
import org.spacehq.mc.protocol.packet.ingame.client.player.ClientPlayerPlaceBlockPacket;
import org.spacehq.mc.protocol.packet.ingame.client.player.ClientPlayerSwingArmPacket;
import org.spacehq.packetlib.packet.Packet;

import sul.protocol.pocket100.play.UseItem;

public class PEUseItemPacketTranslator implements PEPacketTranslator<UseItem> {

    @Override
    public Packet[] translate(ClientConnection session, UseItem packet) {
        if (packet.face == 0xFF) {
            //Left click AIR
            ClientPlayerSwingArmPacket pk = new ClientPlayerSwingArmPacket(Hand.MAIN_HAND);
            return new Packet[]{pk};
        }
        
        BlockFace magic = (BlockFace) MagicValues.key(BlockFace.class, packet.face);
        if(magic == null){
        	magic = BlockFace.UP;
        }
        ClientPlayerPlaceBlockPacket pk = new ClientPlayerPlaceBlockPacket(new Position((int) packet.position.x, (int) packet.position.y, (int) packet.position.z), magic, Hand.MAIN_HAND, 0.5f, 0.5f, 0.5f);
        return new Packet[]{pk};
    }

}
