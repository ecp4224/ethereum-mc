package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.core.Transaction;
import org.ethereum.facade.Ethereum;
import org.ethereum.net.message.Message;
import org.ethereum.net.server.Channel;

import java.util.List;

public class EthPendingTransactionsReceivedEvent extends EthEvent {
    private List<Transaction> transactionList;

    private static final HandlerList handlers = new HandlerList();

    public EthPendingTransactionsReceivedEvent(Ethereum eth, List<Transaction> list) {
        super(eth);
        this.transactionList = list;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
