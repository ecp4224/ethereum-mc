package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;
import org.ethereum.net.server.Channel;

public class EthPeerAddedEvent extends EthChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    public EthPeerAddedEvent(Ethereum eth, Channel channel) {
        super(eth, channel);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
