package david11.handlers;

import david11.pomoc;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TorchHandler implements Listener {
    public TorchHandler(pomoc plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /**
     * Lowest
     * Low
     * Normal
     * High
     * Highest
     * ------
     * Monitor
     */


    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace_Low(BlockPlaceEvent event) {
        if (!event.getPlayer().hasPermission("pomoc.torch_diamond")) {
            return;
        }
        if (event.getBlock().getType() == Material.TORCH) {
            event.getBlock().setType(Material.DIAMOND_BLOCK);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onTorchPlace_Normal(BlockPlaceEvent event) {
        Block block = event.getBlock();

        Bukkit.getLogger().info("A block was placed");
    }
}
