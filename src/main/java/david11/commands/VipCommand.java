package david11.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VipCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        Player p = (Player) sender;
        p.sendMessage(ChatColor.GOLD + "Aby dostać/kupić rangę VIP napisz na discordzie do David11#7334.");
        return true;
    }
}