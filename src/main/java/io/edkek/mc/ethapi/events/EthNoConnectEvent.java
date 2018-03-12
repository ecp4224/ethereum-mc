package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;

public class EthNoConnectEvent extends EthEvent {

    private static final HandlerList handlers = new HandlerList();

    public EthNoConnectEvent(Ethereum eth) {
        super(eth);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
