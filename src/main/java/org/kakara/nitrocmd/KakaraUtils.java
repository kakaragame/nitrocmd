package org.kakara.nitrocmd;

import dev.nitrocommand.core.NitroSubCommand;
import org.kakara.nitrocmd.anotations.KakaraPermission;

public class KakaraUtils {
    public static String getPermissionForSubCommand(NitroSubCommand subCommand) {
        if (subCommand.method().isAnnotationPresent(KakaraPermission.class)) {
            return subCommand.method().getAnnotation(KakaraPermission.class).value();
        } else if (subCommand.method().getDeclaringClass().isAnnotationPresent(KakaraPermission.class)) {
            return subCommand.method().getDeclaringClass().getAnnotation(KakaraPermission.class).value();
        }
        return "";
    }
}
