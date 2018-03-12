package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.core.TransactionExecutionSummary;
import org.ethereum.facade.Ethereum;

public class EthTransactionExecutedEvent extends EthEvent {
    private final TransactionExecutionSummary executionSummary;


    private static final HandlerList handlers = new HandlerList();

    public EthTransactionExecutedEvent(Ethereum eth, TransactionExecutionSummary summary) {
        super(eth);
        this.executionSummary = summary;
    }

    /**
     * Get the execution summary of this transaction
     * @return The summary as a {@link TransactionExecutionSummary}
     */
    public TransactionExecutionSummary getExecutionSummary() {
        return executionSummary;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
