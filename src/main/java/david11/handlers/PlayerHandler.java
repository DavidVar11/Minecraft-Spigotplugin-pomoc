package david11.handlers;

import david11.pomoc;
import david11.util.DelayedTask;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerHandler implements Listener {
    public PlayerHandler(pomoc plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        Inventory inv = p.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§r§koo§r§3Super Miecz§r§koo");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        item.setItemMeta(meta);

        inv.addItem(item);

        DelayedTask lang_get = new DelayedTask(() -> {
            String lang = p.getLocale();
            p.sendMessage(lang);
            Bukkit.getLogger().info(lang);

            if (lang.equals("en_us")) {
                p.sendMessage("hi");
                p.sendMessage(lang);
            }
        },20*5);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
            return;
        }

        Player p = (Player) event.getEntity();
        DelayedTask task = new DelayedTask(() -> {
            p.getInventory().addItem(new ItemStack(Material.DIAMOND));
        }, 20 * 5);
    }

    @EventHandler
    public void onLocaleChange(PlayerLocaleChangeEvent event) {
        Player p = event.getPlayer();

        DelayedTask lang_get = new DelayedTask(() -> {
            String lang = p.getLocale();
            p.sendMessage(lang);
            Bukkit.getLogger().info(lang);

            if (lang.equals("en_us")) {
                p.sendMessage("Hello");
            }
            if (lang.equals("pl_pl")) {
                p.sendMessage("Cześć");
            }
            if (lang.equals("hy_am")) {
                p.sendMessage("Բարև");
            }
        },20*3);
    }
}
