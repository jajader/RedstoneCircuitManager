package org.jajader;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jajader.Listeners.ChunkloadListener;
import org.jajader.SchematicSaveManager.SchematicLoader;
import org.jajader.SchematicSaveManager.SchematicWriter;

public final class RedstoneCircuitManager extends JavaPlugin implements CommandExecutor, Listener {



    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("save").setExecutor(this);
        this.getCommand("load").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ChunkloadListener(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }





    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (command.getName().equals("save")) {
                SchematicWriter sw = new SchematicWriter();
                sw.writeSchematics(args[0], p.getLocation(), p.getLocation().add(-5,5,5));
            }

            if (command.getName().equals("load")) {
                SchematicLoader sl = new SchematicLoader();
                sl.loadSchematics(args[0], p.getLocation());

            }

        }
        return true;
    }





}
