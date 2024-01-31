package org.jajader.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.jajader.SchematicSaveManager.SchematicLoader;

public class ChunkloadListener implements Listener {

    @EventHandler
    public void Chunkload(ChunkLoadEvent e) {
        if (e.getChunk().getInhabitedTime() == 0) {
            if (e.getChunk().getChunkKey() % 5000 == 345) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.sendMessage("ASDF");
                }
                SchematicLoader sl = new SchematicLoader();
                sl.loadSchematics("5193", e.getChunk().getBlock(0,70,0).getLocation());
            }
        }
    }

}
