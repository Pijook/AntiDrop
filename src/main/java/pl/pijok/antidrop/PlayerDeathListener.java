package pl.pijok.antidrop;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){

        Player player = event.getEntity();

        if(player.hasPermission(Settings.bypassPermission)){
            event.setKeepInventory(true);
        }
        else{
            if(!player.hasPermission(Settings.keepInventoryPermission)){
                return;
            }

            boolean keepInventory = true;

            if(event.getEntity().getLastDamageCause() != null){
                if(event.getEntity().getLastDamageCause().getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)){
                    keepInventory = !event.getEntity().getLastDamageCause().getEntity().getType().equals(EntityType.PLAYER);
                }
            }

            event.setKeepInventory(keepInventory);
        }

    }

}
