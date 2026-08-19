package dev.efnilite.ip.hook;

import dev.efnilite.ip.IP;
import org.bukkit.entity.Player;

public class FloodgateHook {

    public static boolean isBedrockPlayer(Player player) {
        try {
            Object api = Class.forName("org.geysermc.floodgate.api.FloodgateApi")
                    .getMethod("getInstance")
                    .invoke(null);
            return (boolean) Class.forName("org.geysermc.floodgate.api.FloodgateApi")
                    .getMethod("isFloodgatePlayer", java.util.UUID.class)
                    .invoke(api, player.getUniqueId());
        } catch (Exception ex) {
            return false;
        }
    }
}
