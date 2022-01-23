package pl.pijok.antidrop;

import org.bukkit.configuration.file.YamlConfiguration;
import pl.pijok.api.ConfigUtils;

public class Settings {

    public static String keepInventoryPermission;
    public static String bypassPermission;

    public static void load(){

        YamlConfiguration configuration = ConfigUtils.load("config.yml");

        keepInventoryPermission = configuration.getString("keepInventoryPermissionOnPVE");
        bypassPermission = configuration.getString("bypassPermission");

    }

}
