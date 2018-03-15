package net.isariel.lycan.api.service.command;

import org.bukkit.command.Command;

/**
 * @author Felix Klauke <fklauke@itemis.de>
 */
public interface CommandService {

    void registerCommand(String label, Command command);

    void unregisterCommand(Command command);
}
