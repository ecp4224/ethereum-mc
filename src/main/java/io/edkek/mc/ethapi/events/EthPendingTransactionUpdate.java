package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.core.Block;
import org.ethereum.core.TransactionReceipt;
import org.ethereum.facade.Ethereum;
import org.ethereum.listener.EthereumListener;

public class EthPendingTransactionUpdate extends EthEvent {

    private static final HandlerList handlers = new HandlerList();

    private TransactionReceipt receipt;
    private EthereumListener.PendingTransactionState pendingState;
    private Block block;

    public EthPendingTransactionUpdate(Ethereum eth, TransactionReceipt transactionReceipt, EthereumListener.PendingTransactionState pendingTransactionState, Block block) {
        super(eth);
    }

    /**
     * Get the block associated with this event
     * @return The block as a {@link Block}
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Get the receipt for this pending transaction
     * @return The receipt as a {@link TransactionReceipt}
     */
    public TransactionReceipt getReceipt() {
        return receipt;
    }

    /**
     * Get the pending state for this transcation
     * @return The pending state as a {@link org.ethereum.listener.EthereumListener.PendingTransactionState}
     */
    public EthereumListener.PendingTransactionState getPendingState() {
        return pendingState;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
