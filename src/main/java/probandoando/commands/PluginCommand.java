package probandoando.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import probandoando.core.Main;

public class PluginCommand implements CommandExecutor {

    private final Main miplugin;

    public PluginCommand(Main miplugin) {
        this.miplugin = miplugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                switch (args[0]) {
                    case "version":
                        Main.sendMessage(player, "El plugin se encuentra en su versión " + ChatColor.GOLD + miplugin.getDescription().getVersion(), ChatColor.DARK_GREEN, ChatColor.RED);
                        break;
                    case "tp":
                        if (!player.hasPermission("burnito-plugin.tp")) {
                            Main.sendMessage(player, "Usted no tiene permisos para teletransportarse", ChatColor.DARK_RED, ChatColor.YELLOW);
                            return false;
                        }
                        player.teleport(player.getWorld().getSpawnLocation());
                        Main.sendMessage(player, "Has sido teletransportado al spawn", ChatColor.DARK_GREEN, ChatColor.RED);
                    break;
                    case "curar":
                        player.setHealth(player.getHealthScale());
                        player.setFoodLevel(20);
                        Main.sendMessage(player, "Has sido curado al máximo", ChatColor.DARK_GREEN, ChatColor.RED);
                    break;
                    case "reload":
                        miplugin.reloadConfig();
                        Main.sendMessage(player, "El plugin ha sido recargado correctamente", ChatColor.DARK_GREEN, ChatColor.RED);
                    break;
                    default:
                        Main.sendMessage(player, "Invalid command", ChatColor.DARK_RED, ChatColor.YELLOW);
                }
            } else {
                player.sendMessage(ChatColor.GOLD + "------------------------------------------------" + "\n" +
                                   ChatColor.DARK_AQUA + "Comandos: " + "\n" +
                                   ChatColor.DARK_GREEN + "    /burnitoPlugin version: versión del plugin" + "\n" +
                                                          "    /burnitoPlugin tp: Teletransporta al spawn" + "\n" +
                                   ChatColor.GOLD + "------------------------------------------------");
            }
        }
        return true;
    }
}
