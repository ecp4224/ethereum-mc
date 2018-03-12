package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;
import org.ethereum.listener.EthereumListener;

public class EthSyncDoneEvent extends EthEvent {

    private static final HandlerList handlers = new HandlerList();

    private EthereumListener.SyncState syncState;
    public EthSyncDoneEvent(Ethereum eth, EthereumListener.SyncState syncState) {
        super(eth);

        this.syncState = syncState;
    }

    /**
     * Get the state of syncing
     * @return
     */
    public EthereumListener.SyncState getSyncState() {
        return syncState;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
