package david11.commands;

import david11.pomoc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class KitCommand implements Listener, CommandExecutor {
    private String invKity = "Kity";

    private final HashMap<UUID, Long> cooldown;
    private final HashMap<UUID, Long> cooldownVIP;
    private final HashMap<UUID, Long> cooldownMVP;


    public KitCommand(pomoc plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.cooldown = new HashMap<>();
        this.cooldownVIP = new HashMap<>();
        this.cooldownMVP = new HashMap<>();
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(invKity)) {
            return;

        }
        if (event.getClickedInventory() == event.getWhoClicked().getInventory()) {
            event.setCancelled(true);
            return;
        }

        Player p = (Player) event.getWhoClicked();
        Inventory inv = p.getInventory();
        int slot = event.getSlot();

        // -------11-------- //

            if (event.getWhoClicked() instanceof Player) {
                if (!this.cooldown.containsKey(p.getUniqueId())) {
                    this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                    if (slot == 11) {
                        Bukkit.getLogger().info("Kliknięto na slot 11.");
                        inv.addItem(getItem(new ItemStack(Material.IRON_SWORD), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.IRON_PICKAXE), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.IRON_AXE), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.IRON_SHOVEL), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.COOKED_PORKCHOP, 32), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.GOLDEN_APPLE, 2), "&r&fZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.LEATHER_HELMET), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.LEATHER_CHESTPLATE), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.LEATHER_LEGGINGS), "&rZestaw Gracz"));
                        inv.addItem(getItem(new ItemStack(Material.LEATHER_BOOTS), "&rZestaw Gracz"));
                        p.closeInventory();
                    }

                    event.setCancelled(true);

                } else {

                    long timeElapsed = System.currentTimeMillis() - cooldown.get(p.getUniqueId());

                    if (timeElapsed >= 15000) {

                        this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                        if (slot == 11) {
                            Bukkit.getLogger().info("Kliknięto na slot 11.");
                            inv.addItem(getItem(new ItemStack(Material.IRON_SWORD), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.IRON_PICKAXE), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.IRON_AXE), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.IRON_SHOVEL), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.COOKED_PORKCHOP, 32), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.GOLDEN_APPLE, 2), "&r&fZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.LEATHER_HELMET), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.LEATHER_CHESTPLATE), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.LEATHER_LEGGINGS), "&rZestaw Gracz"));
                            inv.addItem(getItem(new ItemStack(Material.LEATHER_BOOTS), "&rZestaw Gracz"));
                            p.closeInventory();
                        }

                        event.setCancelled(true);

                    } else {
                        if (slot == 11) {
                        p.sendMessage(ChatColor.RED + "Poczekaj jeszcze " + ((15000 - timeElapsed) / 1000) + " sekund, aby odebrać zestaw ponownie.");
                        }
                    }
                }
            }

        // ------13------ //

            if (event.getWhoClicked().hasPermission("pomoc.VIP")) {
                if (event.getWhoClicked() instanceof Player) {
                    if (!this.cooldownVIP.containsKey(p.getUniqueId())) {
                        this.cooldownVIP.put(p.getUniqueId(), System.currentTimeMillis());

                        if (slot == 13) {
                            Bukkit.getLogger().info("Kliknięto na slot 13.");
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_SWORD), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_PICKAXE), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_AXE), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_SHOVEL), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.GOLDEN_CARROT, 64), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.GOLDEN_APPLE, 8), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.IRON_HELMET), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.IRON_CHESTPLATE), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.IRON_LEGGINGS), "&r&3Zestaw VIP"));
                            inv.addItem(getItem(new ItemStack(Material.IRON_BOOTS), "&r&3Zestaw VIP"));
                            p.closeInventory();
                        }

                        event.setCancelled(true);

                    } else {

                        long timeElapsed = System.currentTimeMillis() - cooldownVIP.get(p.getUniqueId());

                        if (timeElapsed >= 15000) {

                            this.cooldownVIP.put(p.getUniqueId(), System.currentTimeMillis());

                            if (slot == 13) {
                                Bukkit.getLogger().info("Kliknięto na slot 13.");
                                inv.addItem(getItem(new ItemStack(Material.DIAMOND_SWORD), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.DIAMOND_PICKAXE), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.DIAMOND_AXE), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.DIAMOND_SHOVEL), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.GOLDEN_CARROT, 64), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.GOLDEN_APPLE, 8), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.IRON_HELMET), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.IRON_CHESTPLATE), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.IRON_LEGGINGS), "&r&3Zestaw VIP"));
                                inv.addItem(getItem(new ItemStack(Material.IRON_BOOTS), "&r&3Zestaw VIP"));
                                p.closeInventory();
                            }

                            event.setCancelled(true);

                        } else if (event.getWhoClicked().hasPermission("pomoc.VIP")) {
                            p.sendMessage(ChatColor.RED + "Poczekaj jeszcze " + ((15000 - timeElapsed) / 1000) + " sekund, aby odebrać zestaw ponownie.");
                            event.setCancelled(true);
                            return;
                        }
                    }
                }
            }

        if (slot == 13) {
            if (!event.getWhoClicked().hasPermission("pomoc.VIP")) {
                p.closeInventory();
                p.sendMessage("Nie masz permisji, aby odebrać ten zestaw.");
                return;
            }
        }

        // -----15----- //

        if (event.getWhoClicked().hasPermission("pomoc.MVP")) {
            if (event.getWhoClicked() instanceof Player) {
                if (!this.cooldownMVP.containsKey(p.getUniqueId())) {
                    this.cooldownMVP.put(p.getUniqueId(), System.currentTimeMillis());

                    if (slot == 15) {
                        Bukkit.getLogger().info("Kliknięto na slot 15.");
                        inv.addItem(getItem(new ItemStack(Material.NETHERITE_SWORD), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.NETHERITE_PICKAXE), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.NETHERITE_AXE), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.NETHERITE_SHOVEL), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.GOLDEN_CARROT, 64), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.GOLDEN_APPLE, 16), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.DIAMOND_HELMET), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.DIAMOND_CHESTPLATE), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.DIAMOND_LEGGINGS), "&r&6Zestaw MVP"));
                        inv.addItem(getItem(new ItemStack(Material.DIAMOND_BOOTS), "&r&6Zestaw MVP"));
                        p.closeInventory();
                    }

                    event.setCancelled(true);

                } else {

                    long timeElapsed = System.currentTimeMillis() - cooldownMVP.get(p.getUniqueId());

                    if (timeElapsed >= 15000) {

                        this.cooldownMVP.put(p.getUniqueId(), System.currentTimeMillis());

                        if (slot == 15) {
                            Bukkit.getLogger().info("Kliknięto na slot 15.");
                            inv.addItem(getItem(new ItemStack(Material.NETHERITE_SWORD), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.NETHERITE_PICKAXE), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.NETHERITE_AXE), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.NETHERITE_SHOVEL), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.GOLDEN_CARROT, 64), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.GOLDEN_APPLE, 16), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_HELMET), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_CHESTPLATE), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_LEGGINGS), "&r&6Zestaw MVP"));
                            inv.addItem(getItem(new ItemStack(Material.DIAMOND_BOOTS), "&r&6Zestaw MVP"));
                            p.closeInventory();
                        }

                        event.setCancelled(true);

                    } else if (event.getWhoClicked().hasPermission("pomoc.MVP")) {
                        p.sendMessage(ChatColor.RED + "Poczekaj jeszcze " + ((15000 - timeElapsed) / 1000) + " sekund, aby odebrać zestaw ponownie.");
                        event.setCancelled(true);
                        return;
                    }
                }
            }
        }

        if (slot == 15) {
            if (!event.getWhoClicked().hasPermission("pomoc.MVP")) {
                p.closeInventory();
                p.sendMessage("Nie masz permisji, aby odebrać ten zestaw.");
                return;
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

        Player p = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Nie jesteś graczem lol.");
            return true;
        }

        Inventory inv = Bukkit.createInventory(p, 9 * 3, invKity);

        inv.setItem(11, getItem(new ItemStack(Material.LEATHER_HELMET), "&r&fZestaw Gracz", "&r&aKliknij, aby odebrać."));
        inv.setItem(13, getItem(new ItemStack(Material.IRON_HELMET), "&r&3Zestaw VIP", "&r&aKliknij, aby odebrać."));
        inv.setItem(15, getItem(new ItemStack(Material.DIAMOND_HELMET), "&r&6Zestaw MVP", "&r&aKliknij, aby odebrać."));

        if (!p.hasPermission("pomoc.VIP")) {
            inv.setItem(13, getItem(new ItemStack(Material.IRON_HELMET), "&r&3Zestaw VIP", "&r&cNie możesz odebrać tego zestawu!"));
        }

        if (!p.hasPermission("pomoc.MVP")) {
            inv.setItem(15, getItem(new ItemStack(Material.DIAMOND_HELMET), "&r&6Zestaw MVP", "&r&cNie możesz odebrać tego zestawu!"));
        }

        p.openInventory(inv);

        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String... lore) {
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