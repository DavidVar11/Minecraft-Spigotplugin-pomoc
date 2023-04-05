package david11.commands;

import david11.pomoc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Listener, CommandExecutor {
    private String invName = "Testowe okno";

    public Menu(pomoc plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(invName)) {
            return;
        }

        Player p = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        if (slot == 11) {
            Bukkit.getLogger().info("Kliknięto na slot 11.");
            Location loc = new Location(Bukkit.getWorld("world"), 307, 72, 1568, 0, 0);
            p.teleport(loc);
        }

        event.setCancelled(true);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nie jesteś graczem lol.");
            return true;
        }

        Player p=(Player) sender;

        Inventory inv= Bukkit.createInventory(p, 9*3, invName);

        inv.setItem(11, getItem(new ItemStack(Material.GRASS_BLOCK), "&r&6SpAWn", "&aTak, ty jesteś na TotALnIe fAKe'OwYm spawnie.", "&4100% lEgiT"));
        inv.setItem(13, getItem(new ItemStack(Material.DIRT), "&9Test", "Pierwsza linia", "Druga linia"));
        inv.setItem(15, getItem(new ItemStack(Material.GRASS_BLOCK), "&9Test", "Pierwsza linia", "Druga linia"));

        p.openInventory(inv);

        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore) {
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;
    }
}
