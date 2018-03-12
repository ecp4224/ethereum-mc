package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;
import org.ethereum.net.message.Message;
import org.ethereum.net.server.Channel;

public class EthMessageSentEvent extends EthMessageEvent {
    private static final HandlerList handlers = new HandlerList();

    public EthMessageSentEvent(Ethereum eth, Channel channel, Message message) {
        super(eth, channel, message);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
