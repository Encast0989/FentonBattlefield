package net.fenton.battlefield.command.fenton;

import net.fenton.core.command.fentoncommand.FentonCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Encast (2017-01-28 3:31 PM)
 */
public class CoinsCommand extends FentonCommand {

    public CoinsCommand() {
        super("bf:coins", "Add or subtract player coins.", "", false, "bf:c");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("§cComing Soon!");
        }
    }
}
