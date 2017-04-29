package net.fenton.battlefield.Command;

import net.fenton.battlefield.Core;
import net.fenton.battlefield.Player.BFPlayer;
import net.fenton.battlefield.Player.BFPlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Encast (2016-12-29), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 9:00 PM
 */
public class OPModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("opmode")) {
            if(sender.hasPermission("battlefield.command.opmode")) {
                if(sender instanceof Player) {
                    Player p = (Player) sender;
                    if(args.length >= 1) {
                        BFPlayer data = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                        if(args[0].equalsIgnoreCase("on")) {
                            if(!data.isOpMode()) {
                                p.sendMessage("§3Please wait while we save your current stats.");
                                Core.getInstance().getBattlefieldDatabase().savePlayer(p, false, true);
                            } else {
                                p.sendMessage("§cOP Mode is already turned on for you.");
                                return true;
                            }
                        } else if(args[0].equalsIgnoreCase("off")) {
                            if(data.isOpMode()) {
                                p.sendMessage("§3You will be kicked in 3 seconds...");
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        net.fenton.core.Core.getInstance().sendPlayerToServer(p, "FenL");
                                    }
                                }.runTaskLater(Core.getInstance(), 60);
                            } else {
                                p.sendMessage("§cOP Mode is already off for you.");
                                return true;
                            }
                        } else {
                            p.sendMessage("§cInvalid argument, can either be §3on §cor §3off§c.");
                            return true;
                        }
                    } else {
                        p.sendMessage("§cPlease specify either to toggle §3on §cor §3off §cOP Mode.");
                        return true;
                    }
                } else {
                    sender.sendMessage("Only players can use this command.");
                }
            } else {
                sender.sendMessage("§cYou do not have permission to execute this command.");
                return true;
            }
        }
        return true;
    }
}
