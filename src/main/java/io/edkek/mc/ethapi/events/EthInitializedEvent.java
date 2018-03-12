package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;

public class EthInitializedEvent extends EthEvent {

    private static final HandlerList handlers = new HandlerList();

    public EthInitializedEvent(Ethereum eth) {
        super(eth, false);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
