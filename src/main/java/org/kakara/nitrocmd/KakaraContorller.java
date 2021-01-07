package org.kakara.nitrocmd;


import org.kakara.core.common.command.CommandSender;

public class KakaraContorller {
    private CommandSender commandSender;
    private String[] args;
    private String message;

    public KakaraContorller(CommandSender commandSender, String s, String[] args) {
        this.commandSender = commandSender;
        this.args = args;
        message = s;
    }

    public CommandSender getCommandSender() {
        return commandSender;
    }

    public String[] getArgs() {
        return args;
    }

    public Object[] toArray() {
        return new Object[]{args, commandSender, message};
    }

    public String getMessage() {
        return message;
    }
}
