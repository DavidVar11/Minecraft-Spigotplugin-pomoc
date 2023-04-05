package david11;

import david11.commands.*;
//import david11.handlers.PlayerHandler;
import david11.enchants.CustomEnchants;
import david11.handlers.CoalHandler;
import david11.handlers.TorchHandler;
import david11.util.DelayedTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class pomoc extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getLogger().info("Włączanie plugina pomocy...");
        getCommand("pomoc").setExecutor(new PomocCommand());
        getCommand("admin").setExecutor(new AdminCommand());
        getCommand("vip").setExecutor(new VipCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("FreeMiecz").setExecutor(new FreeMieczCommand());
        getCommand("menu").setExecutor(new Menu(this));
        getCommand("kit").setExecutor(new KitCommand(this));
        new TorchHandler(this);
        new DelayedTask(this);
        new CoalHandler(this);
//      new PlayerHandler(this);
        CustomEnchants.register();
        this.getServer().getPluginManager().registerEvents(this, this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        super.onDisable();
        Bukkit.getLogger().info("Wyłączanie plugina pomocy...");
        // Plugin shutdown logic
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("zbieranie")) {
            if (!(sender instanceof Player))
                return true;
            Player p = (Player) sender;

            ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
            item.addUnsafeEnchantment(CustomEnchants.ZBIERANIE, 1);
            item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 100);

            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + "Zbieranie I");
            if (meta.hasLore())
                for (String l : meta.getLore())
                    lore.add(l);
            meta.setLore(lore);
            item.setItemMeta(meta);

            p.getInventory().addItem(item);
            return true;

        }
        return true;
    }

    @EventHandler()
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand() == null)
            return;
        if (!event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
            return;
        if (!event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.ZBIERANIE))
            return;
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().getGameMode() == GameMode.SPECTATOR)
            return;
        if (event.getPlayer().getInventory().firstEmpty() == -1)
            return;
        if (event.getBlock().getState() instanceof Container)
            return;

        event.setDropItems(false);
        Player p = event.getPlayer();
        Block b = event.getBlock();

        Collection<ItemStack> drops = b.getDrops(p.getInventory().getItemInMainHand());
        if (drops.isEmpty())
            return;
        p.getInventory().addItem(drops.iterator().next());
    }
}
