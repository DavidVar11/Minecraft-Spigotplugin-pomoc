package david11.handlers;

import david11.pomoc;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//public class PlayerHandler implements Listener {
//    public PlayerHandler(pomoc plugin) {
//        Bukkit.getPluginManager().registerEvents(this, plugin);
//    }

//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent event) {
//        Player p = event.getPlayer();
//
//        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
//        Inventory inv = p.getInventory();
//
//        ItemMeta meta = item.getItemMeta();
//        meta.setDisplayName("§r§koo§r§3Super Miecz§r§koo");
//        meta.setUnbreakable(true);
//        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
//        item.setItemMeta(meta);
//
//        inv.addItem(item);
//    }
//}
