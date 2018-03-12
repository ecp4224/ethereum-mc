package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.PendingState;

public class EthPendingStateChangedEvent extends EthEvent {
    private PendingState state;

    public EthPendingStateChangedEvent(Ethereum eth, PendingState newState) {
        super(eth);
        this.state = newState;
    }

    /**
     * Get the pending state related to this event
     * @return The new pending state as a {@link PendingState}
     */
    public PendingState getPendingState() {
        return state;
    }

    private static final HandlerList handlers = new HandlerList();
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
