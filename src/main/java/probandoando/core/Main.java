package probandoando.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import probandoando.commands.PluginCommand;
import probandoando.events.GiveItems;
import probandoando.events.PlayerJoinQuit;

public final class Main extends JavaPlugin {

    ConsoleCommandSender ccs = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        // Commands of Plugin
        try {
            getCommand("burnitoPlugin").setExecutor(new PluginCommand(this.getDescription().getVersion()));
        } catch (NullPointerException ex) {
            ccs.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "!" + ChatColor.GOLD + "]: No se han podido cargar los comandos del plugin: " + ChatColor.DARK_AQUA + getDescription().getName());
        }

        // Events
        getServer().getPluginManager().registerEvents(new PlayerJoinQuit(this), this);
        getServer().getPluginManager().registerEvents(new GiveItems(), this);

        // Recipe
        getServer().addRecipe(CraftingRecipe.recipeSaddle());

        String name = "[" + getDescription().getName() + "]";
        String version = getDescription().getVersion();
        ccs.sendMessage(ChatColor.GOLD + name + ChatColor.WHITE + ": Ha iniciado (Versión: " + ChatColor.GOLD + version + ChatColor.WHITE + ")");
    }

    @Override
    public void onDisable() {

    }

    public static void sendMessage(Player player, Object msg, ChatColor textColor, ChatColor notification) {
        player.sendMessage(textColor + "[" + notification + "!" + textColor + "]: " + msg);
    }
}
