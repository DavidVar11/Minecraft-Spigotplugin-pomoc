package david11.commands;

import david11.util.SpawnUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
    private SpawnUtil spawnUtil;

    public SetSpawn(SpawnUtil spawnUtil) {
        this.spawnUtil = spawnUtil;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Tylko gracze mogą z tego korzystać.");
            return true;
        }

        Player p = (Player) sender;
        spawnUtil.set(p.getLocation());

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aUstawiono serwerowy spawn."));

        return true;
    }
}
