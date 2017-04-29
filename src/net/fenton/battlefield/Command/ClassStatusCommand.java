package net.fenton.battlefield.command;

import net.fenton.battlefield.bfclass.BattlefieldClassData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Encast (2017-02-05 5:16 PM)
 */
public class ClassStatusCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("cstatus")) {
            if(sender.hasPermission("battlefield.command.cstatus")) {
                if(sender instanceof Player) {
                    Player p = (Player) sender;
                    if(args.length >= 2) {
                        BattlefieldClassData.BFClass c = null;
                        for(BattlefieldClassData.BFClass bfClass : BattlefieldClassData.BFClass.values()) {
                            if(bfClass.getDbName().equalsIgnoreCase(args[0])) {
                                c = bfClass;
                            }
                        }
                        if(c != null) {
                            boolean status;
                            if(args[1].equalsIgnoreCase("true")) {
                                status = true;
                            } else if(args[1].equalsIgnoreCase("false")) {
                                status = false;
                            } else {
                                p.sendMessage("§c" + args[1] + " is not a valid option!");
                                return true;
                            }
                            BattlefieldClassData.getInstance().getClassByName(c).setEnabled(status);
                            if(status) {
                                p.sendMessage("§aEnabled " + c.getName() + "!");
                            } else {
                                p.sendMessage("§cDisabled " + c.getName() + "!");
                            }
                        } else {
                            p.sendMessage("§c" + args[0] + " is not a valid class!");
                        }
                    } else {
                        p.sendMessage("§cInvalid arguments!");
                        p.sendMessage("§c/cstatus <class> <true,false>");
                    }
                } else {
                    sender.sendMessage("Only players can use this command.");
                }
            } else {
                sender.sendMessage("§cYou do not have permission to execute this command.");
            }
        }
        return true;
    }
}
