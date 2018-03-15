package net.isariel.lycan.spigot.service.command;

import net.isariel.lycan.api.service.command.CommandService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;

import javax.inject.Inject;

/**
 * @author Felix Klauke <fklauke@itemis.de>
 */
public class CommandServiceImpl implements CommandService {

    private final CommandMap commandMap;

    @Inject
    public CommandServiceImpl(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public void registerCommand(String label, Command command) {
        commandMap.register(label, command);
    }

    @Override
    public void unregisterCommand(Command command) {
        command.unregister(commandMap);
    }
}
