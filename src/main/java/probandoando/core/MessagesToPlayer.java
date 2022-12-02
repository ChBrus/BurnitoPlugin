package probandoando.core;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessagesToPlayer {
    public static void sendMessage(Player player, Object msg, ChatColor textColor, ChatColor notification) {
        player.sendMessage(textColor + "[" + notification + "!" + textColor + "]: " + msg);
    }
}
