package david11.util;

import david11.pomoc;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Scoreboard implements Listener {
    private final Map<UUID, FastBoard> boards = new HashMap<>();

    public Scoreboard(pomoc plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);

        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (FastBoard board : boards.values()) {
                updateBoard(board,
                        "",
                        "&aOnline:",
                        "&c" + Bukkit.getOnlinePlayers().size(),
                        "",
                        "&aY-Coord:",
                        "&c" + board.getPlayer().getLocation().getBlockY());
            }
        }, 0L, 10L);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        FastBoard board = new FastBoard(p);

        String title = "&c&lWitaj " + p.getName();
        board.updateTitle(ChatColor.translateAlternateColorCodes('&', title));

        boards.put(p.getUniqueId(), board);

        p.sendMessage("Cześć " + p.getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        FastBoard board = boards.remove(p.getUniqueId());

        if (board != null) {
            board.delete();
        }
    }

    private void updateBoard(FastBoard board, String ... lines) {
        for (int a = 0; a < lines.length; ++a) {
            lines[a] = ChatColor.translateAlternateColorCodes('&', lines[a]);
        }

        board.updateLines(lines);
    }
}
