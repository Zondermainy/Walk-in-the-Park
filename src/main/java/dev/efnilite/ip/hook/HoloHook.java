package dev.efnilite.ip.hook;

import dev.efnilite.ip.IP;

public class HoloHook {

    public static void init() {
        try {
            Class.forName("me.filoghost.holographicdisplays.api.HolographicDisplaysAPI");
        } catch (Exception ex) {
            IP.logging().warn("##");
            IP.logging().warn("## IP only supports Holographic Displays v3.0.0 or higher!");
            IP.logging().warn("## This hook will now be disabled.");
            IP.logging().warn("##");
            return;
        }

        try {
            Object api = Class.forName("me.filoghost.holographicdisplays.api.HolographicDisplaysAPI")
                    .getMethod("get", Class.forName("org.bukkit.plugin.Plugin"))
                    .invoke(null, IP.getPlugin());

            Class.forName("me.filoghost.holographicdisplays.api.HolographicDisplaysAPI")
                    .getMethod("registerGlobalPlaceholder", String.class, int.class, Class.forName("me.filoghost.holographicdisplays.api.placeholder.GlobalPlaceholder"))
                    .invoke(api, "ip_leaderboard", 100, (java.util.function.Function<Object, Object>) argument -> {
                        if (argument == null) {
                            return "?";
                        }
                        return "?";
                    });
        } catch (Exception ex) {
            // reflection failed, hook disabled silently
        }
    }
}
