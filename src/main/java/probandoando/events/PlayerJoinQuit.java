package probandoando.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuit implements Listener {

    @EventHandler
    public void joinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = ChatColor.GOLD + player.getName();

        if(player.hasPlayedBefore()) {
            event.setJoinMessage(ChatColor.DARK_GREEN + "Él jugador <" + name + ChatColor.DARK_GREEN + "> se ha unido");
        } else {
            event.setJoinMessage(ChatColor.DARK_GREEN + "Bienvenido <" + name + ChatColor.DARK_GREEN + "> a mi servidor :D");
        }
    }

    @EventHandler
    public void quitPlayer(PlayerQuitEvent event) {
        String name = ChatColor.GOLD + event.getPlayer().getName();

        event.setQuitMessage("Él jugador <" + name + ChatColor.DARK_GREEN + "> se ha salido");
    }
}
