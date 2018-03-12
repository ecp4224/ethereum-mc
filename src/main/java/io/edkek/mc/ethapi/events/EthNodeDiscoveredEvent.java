package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.facade.Ethereum;
import org.ethereum.net.rlpx.Node;


public class EthNodeDiscoveredEvent extends EthEvent {
    private Node nodeDiscovered;

    private static final HandlerList handlers = new HandlerList();

    public EthNodeDiscoveredEvent(Ethereum eth, Node node) {
        super(eth);
        this.nodeDiscovered = node;
    }

    /**
     * Get the node that was discovered in this event
     * @return The node
     */
    public Node getNode() {
        return nodeDiscovered;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
