package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;
import org.ethereum.net.message.Message;
import org.ethereum.net.server.Channel;

public abstract class EthMessageEvent extends EthChannelEvent {

    private final Message message;
    public EthMessageEvent(Ethereum eth, Channel channel, Message message) {
        super(eth, channel);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
