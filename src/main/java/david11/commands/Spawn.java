package david11.commands;

import david11.util.SpawnUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    private SpawnUtil spawnUtil;

    public Spawn(SpawnUtil spawnUtil) {
        this.spawnUtil = spawnUtil;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Tylko gracze mogą z tego korzystać.");
            return true;
        }

        Player p = (Player) sender;
        spawnUtil.teleport(p);

        return true;
    }
}
