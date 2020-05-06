package org.kakara.nitrocmd;

import dev.nitrocommand.core.NitroCMD;
import dev.nitrocommand.core.basic.BasicCommandCore;
import org.kakara.core.command.CommandSender;
import org.kakara.core.mod.Mod;

public class KakaraCommandCore extends BasicCommandCore<CommandSender> {
    private Mod mod;

    public KakaraCommandCore(Mod mod) {
        this.mod = mod;
        NitroCMD.LOGGER = mod.getLogger();
    }

    @Override
    public String getName() {
        return "kakara_nitrocmd";
    }

    @Override
    public void sendMessage(CommandSender object, String s) {
        object.sendMessage(s);
    }
}
