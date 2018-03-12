package io.edkek.mc.ethapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;

public abstract class EthEvent extends Event {
    private Ethereum ethereum;

    public EthEvent(Ethereum eth) {
        super(true);

        this.ethereum = eth;
    }

    public EthEvent(Ethereum eth, boolean isAsync) {
        super(isAsync);

        this.ethereum = eth;
    }

    /**
     * Get the {@link Ethereum} instance linked to this event
     * @return The {@link Ethereum} event
     */
    public Ethereum getEthInstance() {
        return ethereum;
    }
}
