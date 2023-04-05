package david11.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nie jesteś graczem lol.");
            return true;
        }

        Player p=(Player)sender;

        if (p.getAllowFlight()) {
            p.setAllowFlight(false);
            p.sendMessage(ChatColor.RED + "Latanie wyłączone");
        } else {
            p.setAllowFlight(true);
            p.sendMessage(ChatColor.GREEN + "Latanie włączone");
        }

        return true;
    }
}
