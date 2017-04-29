package net.fenton.battlefield.command.fenton;

import net.fenton.api.Fenton;
import net.fenton.battlefield.BattlefieldSettings;
import net.fenton.core.command.fentoncommand.FentonCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Encast (2017-01-28 3:37 PM)
 */
public class GameCommand extends FentonCommand {

    public GameCommand() {
        super("bf:game", "Control different aspects of Battlefield.", "", false, "bf:g");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length >= 1) {
                if(args[0].equalsIgnoreCase("regen")) {
                    if(BattlefieldSettings.getInstance().isRegen()) {
                        BattlefieldSettings.getInstance().setRegen(false);
                        p.sendMessage("§cDisabled regeneration!");
                        Bukkit.getServer().broadcastMessage(Fenton.getAPI().getPlayerHandler().getPlayer(p.getUniqueId()).getActualPrefixedName() +
                                " §9disabled regeneration!");
                    } else {
                        BattlefieldSettings.getInstance().setRegen(true);
                        p.sendMessage("§aEnabled regeneration!");
                        Bukkit.getServer().broadcastMessage(Fenton.getAPI().getPlayerHandler().getPlayer(p.getUniqueId()).getActualPrefixedName() +
                            " §9enabled regeneration!");
                    }
                } else if(args[0].equalsIgnoreCase("extrahearts")) {
                    if(BattlefieldSettings.getInstance().isExtraHearts()) {
                        BattlefieldSettings.getInstance().setExtraHearts(false);
                        p.sendMessage("§cDisabled extra hearts!");
                        Bukkit.getServer().broadcastMessage(Fenton.getAPI().getPlayerHandler().getPlayer(p.getUniqueId()).getActualPrefixedName() +
                                " §9disabled extra hearts!");
                    } else {
                        BattlefieldSettings.getInstance().setExtraHearts(true);
                        p.sendMessage("§aEnabled extra hearts!");
                        Bukkit.getServer().broadcastMessage(Fenton.getAPI().getPlayerHandler().getPlayer(p.getUniqueId()).getActualPrefixedName() +
                                " §9enabled extra hearts!");
                    }
                } else if(args[0].equalsIgnoreCase("permspeed")) {
                    if(BattlefieldSettings.getInstance().isPermanentSpeed()) {
                        BattlefieldSettings.getInstance().setPermanentSpeed(false);
                        p.sendMessage("§cDisabled permanent speed!");
                        Bukkit.getServer().broadcastMessage(Fenton.getAPI().getPlayerHandler().getPlayer(p.getUniqueId()).getActualPrefixedName() +
                                " §9disabled permanent speed!");
                    } else {
                        BattlefieldSettings.getInstance().setPermanentSpeed(true);
                        p.sendMessage("§aEnabled permanent speed!");
                        Bukkit.getServer().broadcastMessage(Fenton.getAPI().getPlayerHandler().getPlayer(p.getUniqueId()).getActualPrefixedName() +
                                " §9enabled permanent speed!");
                    }
                } else {
                    p.sendMessage("§cInvalid argument.");
                    p.sendMessage("§cRequires: <regen, extrahearts, permspeed> [value]");
                }
            } else {
                p.sendMessage("§cRequires: <regen, extrahearts, permspeed> [value]");
            }
        }
    }
}
