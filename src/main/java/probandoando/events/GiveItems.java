package probandoando.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import probandoando.core.MessagesToPlayer;

public class GiveItems implements Listener {
    @EventHandler
    public void joinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Sí el jugador ya ha jugado antes, no seguirá con la sentencia
        if(player.hasPlayedBefore()) {
            return;
        }
        // Crea el stack del Item predefinido, con un total de 10
        ItemStack food = new ItemStack(Material.COOKED_PORKCHOP, 10);
        ItemStack sword = new ItemStack(Material.WOODEN_SWORD);     // Crea una espada
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);      // Crea una pechera de cuero

        player.getInventory().addItem(food);        // Añade el stack de food/comida al inventario
        player.getInventory().addItem(sword);       // Añade la espada al inventario
        player.getInventory().setChestplate(chestplate);        // Equipa la pechera de cuero al jugador
        MessagesToPlayer.sendMessage(player, "Has recibido el paquete de inicio", ChatColor.DARK_GREEN, ChatColor.RED);
    }
}
