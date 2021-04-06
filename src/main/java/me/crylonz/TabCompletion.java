package me.crylonz;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.crylonz.RedStoneMe.redStoneTriggers;

public class TabCompletion implements TabCompleter {

    private List<String> list = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        list.clear();
        if (cmd.getName().equalsIgnoreCase("rsm")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (args.length == 1) {
                    if (player.hasPermission("redstoneme.help") || player.hasPermission("redstoneme.admin")) {
                        list.add("help");
                    }
                    if (player.hasPermission("redstoneme.new") || player.hasPermission("redstoneme.admin")) {
                        list.add("new");
                    }
                    if (player.hasPermission("redstoneme.destroy") || player.hasPermission("redstoneme.admin")) {
                        list.add("destroy");
                    }
                    if (player.hasPermission("redstoneme.add") || player.hasPermission("redstoneme.admin")) {
                        list.add("add");
                    }
                    if (player.hasPermission("redstoneme.add") || player.hasPermission("redstoneme.admin")) {
                        list.add("add");
                    }
                    if (player.hasPermission("redstoneme.remove") || player.hasPermission("redstoneme.admin")) {
                        list.add("remove");
                    }
                    if (player.hasPermission("redstoneme.radius") || player.hasPermission("redstoneme.admin")) {
                        list.add("radius");
                    }
                    if (player.hasPermission("redstoneme.state") || player.hasPermission("redstoneme.admin")) {
                        list.add("state");
                    }
                    if (player.hasPermission("redstoneme.public") || player.hasPermission("redstoneme.admin")) {
                        list.add("public");
                    }
                    if (player.hasPermission("redstoneme.list") || player.hasPermission("redstoneme.admin")) {
                        list.add("list");
                    }
                }

                if (args.length == 2) {
                    if (args[0].equals("destroy") ||
                            args[0].equals("add") ||
                            args[0].equals("remove") ||
                            args[0].equals("radius") ||
                            args[0].equals("state") ||
                            args[0].equals("public") ||
                            args[0].equals("list")) {

                        for (RedStoneTrigger trigger : redStoneTriggers) {
                            if (trigger.hasAccess(player)) {
                                list.add(trigger.getTriggerName());
                            }
                        }
                    }
                    if (args[0].equals("new")) {
                        list.add("<triggerName>");
                    }
                }
                if (args.length == 3) {
                    if (args[0].equals("new") || args[0].equals("radius")) {
                        list.add("<Radius>");
                    }
                    if (args[0].equals("add") || args[0].equals("remove")) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            list.add(p.getName());
                        }
                    }
                    if (args[0].equals("state") || args[0].equals("public")) {
                        list.add("OFF");
                        list.add("ON");
                    }
                }
            }
        }
        return list;
    }
}