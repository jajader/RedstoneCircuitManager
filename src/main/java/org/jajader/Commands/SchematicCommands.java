package org.jajader.Commands;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jajader.SchematicSaveManager.SchematicLoader;
import org.jajader.SchematicSaveManager.SchematicWriter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SchematicCommands implements CommandExecutor {

    public static HashMap<Player, Location> pos1 = new HashMap<>();
    public static HashMap<Player, Location> pos2 = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player p) {
            if (strings == null) {
                p.sendMessage( TextColor.color(255, 0, 0) + "올바른 명령어 사용법이 아닙니다.");
                return false;
            }

            if (command.getName().equals("save")) {
                if (pos1.get(p) == null) {
                    p.sendMessage( TextColor.color(255, 0, 0) + "첫 번째 위치가 지정되지 않았습니다.");
                    return false;
                }

                if (pos2.get(p) == null) {
                    p.sendMessage( TextColor.color(255, 0, 0) + "두 번째 위치가 지정되지 않았습니다.");
                    return false;
                }

                SchematicWriter sw = new SchematicWriter();
                sw.writeSchematics(strings[0], pos1.get(p), pos2.get(p));

                p.sendMessage("구조물 "+strings[0]+ "(이)가 정상적으로 저장되었습니다.");
            }

            if (command.getName().equals("load")) {
                SchematicLoader sl = new SchematicLoader();
                sl.loadSchematics(strings[0], p.getLocation());
                p.sendMessage("구조물 "+strings[0]+ "(이)가 정상적으로 로드되었습니다.");

            }

            if (command.getName().equals("pos1")) {
                pos1.put(p, p.getLocation());

                p.sendMessage( TextColor.color(200, 50, 200) + "첫 번째 위치가 지정되었습니다.");

            }

            if (command.getName().equals("pos2")) {
                pos2.put(p, p.getLocation());

                p.sendMessage( TextColor.color(200, 50, 200) + "두 번째 위치가 지정되었습니다.");

            }

        }
        return true;
    }


}
