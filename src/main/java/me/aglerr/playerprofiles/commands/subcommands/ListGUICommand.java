package me.aglerr.playerprofiles.commands.subcommands;

import me.aglerr.lazylibs.libs.Common;
import me.aglerr.playerprofiles.ConfigValue;
import me.aglerr.playerprofiles.PlayerProfiles;
import me.aglerr.playerprofiles.commands.abstraction.SubCommand;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListGUICommand extends SubCommand {

    @Override
    public @Nullable String getPermission() {
        return "playerprofiles.admin";
    }

    @Override
    public @NotNull List<String> parseTabCompletion(PlayerProfiles plugin, CommandSender sender, String[] args) {
        return new ArrayList<>();
    }

    @Override
    public void execute(PlayerProfiles plugin, CommandSender sender, String[] args) {
        // First, get the list of gui name in comma
        String guiList = String.join(", ", plugin.getCustomGUIManager().getListName());
        // Send the message to the command sender
        sender.sendMessage(Common.color(ConfigValue.LIST_GUI
                .replace("{prefix}", ConfigValue.PREFIX)
                .replace("{gui}", guiList)));
    }

}
