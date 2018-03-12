package io.edkek.mc.ethapi;

import io.edkek.mc.ethapi.events.*;
import org.ethereum.core.*;
import org.ethereum.facade.Ethereum;
import org.ethereum.listener.EthereumListener;
import org.ethereum.net.eth.message.StatusMessage;
import org.ethereum.net.message.Message;
import org.ethereum.net.p2p.HelloMessage;
import org.ethereum.net.rlpx.Node;
import org.ethereum.net.server.Channel;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class EthLinker implements EthereumListener {
    private final McEthereum mcEthereum;
    private final Logger log;
    private final Ethereum ethereum;


    private HashMap<Channel, StatusMessage> statusCache = new HashMap<>();

    public EthLinker(McEthereum mcEthereum) {
        this.mcEthereum = mcEthereum;
        this.log = mcEthereum.getLogger();
        this.ethereum = mcEthereum.getEthInstance();
    }

    @Override
    public void trace(String s) {
        log.info(s);
    }

    @Override
    public void onNodeDiscovered(Node node) {
        EthNodeDiscoveredEvent event = new EthNodeDiscoveredEvent(ethereum, node);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onHandShakePeer(Channel channel, HelloMessage helloMessage) {

    }

    @Override
    public void onEthStatusUpdated(Channel channel, StatusMessage statusMessage) {
        StatusMessage old = null;
        if (statusCache.containsKey(channel))
            old = statusCache.get(channel);

        EthStatusEvent event = new EthStatusEvent(ethereum, channel, statusMessage, old);
        mcEthereum.getServer().getPluginManager().callEvent(event);

        statusCache.put(channel, statusMessage); //Save previous message
    }

    @Override
    public void onRecvMessage(Channel channel, Message message) {
        EthMessageReceivedEvent event = new EthMessageReceivedEvent(ethereum, channel, message);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onSendMessage(Channel channel, Message message) {
        EthMessageSentEvent event = new EthMessageSentEvent(ethereum, channel, message);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onBlock(BlockSummary blockSummary) {
        EthBlockEvent event = new EthBlockEvent(ethereum, blockSummary);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onPeerDisconnect(String s, long l) {

    }

    @Override
    public void onPendingTransactionsReceived(List<Transaction> list) {
        EthPendingTransactionsReceivedEvent event = new EthPendingTransactionsReceivedEvent(ethereum, list);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onPendingStateChanged(PendingState pendingState) {
        EthPendingStateChangedEvent event = new EthPendingStateChangedEvent(ethereum, pendingState);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onPendingTransactionUpdate(TransactionReceipt transactionReceipt, PendingTransactionState pendingTransactionState, Block block) {
        EthPendingTransactionUpdate event = new EthPendingTransactionUpdate(ethereum, transactionReceipt, pendingTransactionState, block);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onSyncDone(SyncState syncState) {
        EthSyncDoneEvent event = new EthSyncDoneEvent(ethereum, syncState);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onNoConnections() {
        EthNoConnectEvent event = new EthNoConnectEvent(ethereum);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onVMTraceCreated(String s, String s1) {

    }

    @Override
    public void onTransactionExecuted(TransactionExecutionSummary transactionExecutionSummary) {
        EthTransactionExecutedEvent event = new EthTransactionExecutedEvent(ethereum, transactionExecutionSummary);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onPeerAddedToSyncPool(Channel channel) {
        EthPeerAddedEvent event = new EthPeerAddedEvent(ethereum, channel);
        mcEthereum.getServer().getPluginManager().callEvent(event);
    }
}
