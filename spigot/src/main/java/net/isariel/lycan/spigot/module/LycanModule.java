package net.isariel.lycan.spigot.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import net.isariel.lycan.api.service.command.CommandService;
import net.isariel.lycan.api.service.tablist.TablistService;
import net.isariel.lycan.spigot.service.command.CommandServiceImpl;
import net.isariel.lycan.spigot.service.tablist.TablistServiceImpl;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;

import javax.inject.Singleton;
import java.lang.reflect.Field;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LycanModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TablistService.class).to(TablistServiceImpl.class).asEagerSingleton();
        bind(CommandService.class).to(CommandServiceImpl.class).asEagerSingleton();
    }

    @Provides
    @Singleton
    public CommandMap provideCommandMap() {
        SimplePluginManager spm = (SimplePluginManager) Bukkit.getServer().getPluginManager();
        Field f;

        try {
            f = SimplePluginManager.class.getDeclaredField("commandMap");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }

        f.setAccessible(true);
        SimpleCommandMap scm = null;

        try {
            scm = (SimpleCommandMap) f.get(spm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        f.setAccessible(false);

        return scm;
    }
}
