package pl.pijok.antidrop;

import org.bukkit.plugin.java.JavaPlugin;
import pl.pijok.api.ChatUtils;
import pl.pijok.api.ConfigUtils;
import pl.pijok.api.Debug;

public class AntiDrop extends JavaPlugin {

    @Override
    public void onEnable() {

        ConfigUtils.setPlugin(this);
        ChatUtils.setPrefix("&7[&cAntiDrop&7] &r");
        Debug.setPrefix("[AntiDrop] ");

        Settings.load();

        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

    }

    @Override
    public void onDisable() {

    }
}
