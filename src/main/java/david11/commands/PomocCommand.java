package david11.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class PomocCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        Player p=(Player)sender;
        p.sendMessage(ChatColor.BLUE + "/vip - info o VIP'ie");
        p.sendMessage(ChatColor.BLUE + "/admin - info o adminie");
        p.sendMessage(ChatColor.BLUE + "/pomoc - to jest pomoc");
        return true;
    }
}
