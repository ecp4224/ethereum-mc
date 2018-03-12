package io.edkek.mc.ethapi.events;

import org.ethereum.facade.Ethereum;
import org.ethereum.net.server.Channel;

public abstract class EthChannelEvent extends EthEvent {
    private Channel channel;

    public EthChannelEvent(Ethereum eth, Channel channel) {
        super(eth);
        this.channel = channel;
    }

    /***
     * Get the {@link Channel} that is associated with this event.
     * @return The {@link Channel} object
     */
    public Channel getChannel() {
        return channel;
    }
}
