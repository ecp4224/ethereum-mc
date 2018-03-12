package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;

public class EthShutdownEvent extends EthEvent {
    private static final HandlerList handlers = new HandlerList();

    public EthShutdownEvent(Ethereum eth) {
        super(eth, false);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
