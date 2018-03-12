package io.edkek.mc.ethapi;

import io.edkek.mc.ethapi.events.EthInitializedEvent;
import io.edkek.mc.ethapi.events.EthShutdownEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;

public class McEthereum extends JavaPlugin {
    private static McEthereum INSTANCE;

    private Ethereum ethereum;
    private EthLinker linker;

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.linker = new EthLinker(this);

        //Ensure the spigot class loader is used before starting up ethereum
        Thread.currentThread().setContextClassLoader(getClassLoader());

        this.ethereum = EthereumFactory.createEthereum();
        this.ethereum.addListener(linker);

        ethereum.startPeerDiscovery();
        ethereum.initSyncing();

        EthInitializedEvent event = new EthInitializedEvent(ethereum);
        getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void onDisable() {
        this.ethereum.stopPeerDiscovery();
        this.ethereum.close();

        EthShutdownEvent event = new EthShutdownEvent(ethereum);
        getServer().getPluginManager().callEvent(event);
    }

    public Ethereum getEthInstance() {
        return ethereum;
    }

    public static McEthereum getInstance() {
        return INSTANCE;
    }

    public static ClassLoader getSpigotClassLoader() {
        return getInstance().getClassLoader();
    }

    public static Ethereum getEthereum() {
        return getInstance().getEthInstance();
    }
}
