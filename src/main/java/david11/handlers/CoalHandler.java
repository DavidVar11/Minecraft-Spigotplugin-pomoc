package david11.handlers;

import david11.pomoc;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
public class CoalHandler implements Listener {
    public CoalHandler(pomoc plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCoalBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.COAL_BLOCK) {
            event.setCancelled(true);
        }
    }
}
