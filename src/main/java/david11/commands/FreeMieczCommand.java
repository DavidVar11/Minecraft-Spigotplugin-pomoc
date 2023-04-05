package david11.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FreeMieczCommand implements CommandExecutor {

    @Override

    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

        Player p = (Player) sender;

        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        Inventory inv = p.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§r§koo§r§3Super Miecz§r§koo");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 5, true);
        item.setItemMeta(meta);

        inv.addItem(item);
        return true;
    }
}
