package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;
import org.ethereum.net.eth.message.StatusMessage;
import org.ethereum.net.rlpx.Node;
import org.ethereum.net.server.Channel;

public class EthStatusEvent extends EthChannelEvent {
    private StatusMessage message;
    private StatusMessage oldMessage;

    public EthStatusEvent(Ethereum eth, Channel channel, StatusMessage statusMessage) {
        super(eth, channel);
        this.message = statusMessage;
    }

    public EthStatusEvent(Ethereum eth, Channel channel, StatusMessage statusMessage, StatusMessage oldMessage) {
        super(eth, channel);
        this.message = statusMessage;
        this.oldMessage = oldMessage;
    }

    /***
     * Get the new status message as a {@link StatusMessage} object
     * @return The new status message
     */
    public StatusMessage getStatusMessage() {
        return message;
    }

    /**
     * Returns true if this channel had a previous status update. If true, then
     * {@link EthStatusEvent#getPreviousStatusMessage()} should not return null.
     * @return Whether if this channel had a previous status update
     */
    public boolean hasPreviousStatus() {
        return oldMessage != null;
    }

    /**
     * Get the previous status message of this channel or null if there was no previous
     * status message
     * @return The old status message
     */
    public StatusMessage getPreviousStatusMessage() {
        return oldMessage;
    }

    private static final HandlerList handlers = new HandlerList();
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
