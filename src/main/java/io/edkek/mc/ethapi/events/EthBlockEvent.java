package io.edkek.mc.ethapi.events;

import org.bukkit.event.HandlerList;
import org.ethereum.core.Block;
import org.ethereum.core.BlockSummary;
import org.ethereum.facade.Ethereum;

public class EthBlockEvent extends EthEvent {
    private static final HandlerList handlers = new HandlerList();
    private BlockSummary blockSummary;

    public EthBlockEvent(Ethereum eth, BlockSummary blockSummary) {
        super(eth);
        this.blockSummary = blockSummary;
    }

    /**
     * Get the block associated with this event
     * @return The block as a {@link Block}
     */
    public Block getBlock() {
        return blockSummary.getBlock();
    }

    /**
     * Get the summary of the block that was just received
     * @return The summary of the block as a {@link BlockSummary}
     */
    public BlockSummary getBlockSummary() {
        return blockSummary;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
