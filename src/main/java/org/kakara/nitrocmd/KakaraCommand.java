package org.kakara.nitrocmd;

import dev.nitrocommand.core.CommandParser;
import dev.nitrocommand.core.NitroCommandObject;
import dev.nitrocommand.core.NitroSubCommand;
import dev.nitrocommand.core.Utils;
import org.kakara.core.command.CommandSender;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModCommand;
import org.kakara.core.player.Player;

import java.util.Set;

public class KakaraCommand extends ModCommand {
    private KakaraCommandCore commandCore;
    private NitroCommandObject object;

    public KakaraCommand(Set<String> aliases, String description, Mod mod, String command, KakaraCommandCore commandCore, NitroCommandObject object) {
        super(aliases, description, mod, command);
        this.commandCore = commandCore;
        this.object = object;
    }

    @Override
    public void execute(String s, String[] strings, String s1, CommandSender commandSender) {
        String message = String.join(" ", strings);
        NitroSubCommand subCommand = (strings.length == 0) ? object.getBaseExecutor() : CommandParser.locateSubCommand(message, object);

        if (subCommand == null) {
            subCommand = object.getBaseExecutor();
            return;
        }
        KakaraContorller controller = new KakaraContorller(commandSender, s, strings);
        String permission = KakaraUtils.getPermissionForSubCommand(subCommand);

        if (!permission.isEmpty()) {
            //TODO LATER
            //if (!commandSender.hasPermission(permission)) {
            //    core.getMissingPermissionHandler().handle(controller, permission);
            //    return false;
            //}
        }


        for (Class<?> type : subCommand.method().getParameterTypes()) {
            if (type.isAssignableFrom(commandSender.getClass())) {
                if (commandSender instanceof Player && !type.isAssignableFrom(Player.class)) {
                    //core.getMustBeAPlayerHandler().handle(controller);
                    return;
                }
            }
        }

        Utils.executeCommand(subCommand, Utils.getArguments(message, subCommand, subCommand.method().getParameters(), controller.getArgs(), commandCore));
    }
}
