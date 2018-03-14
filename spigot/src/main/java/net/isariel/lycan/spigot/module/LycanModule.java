package net.isariel.lycan.spigot.module;

import com.google.inject.AbstractModule;
import net.isariel.lycan.api.service.tablist.TablistService;
import net.isariel.lycan.spigot.service.tablist.TablistServiceImpl;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class LycanModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TablistService.class).to(TablistServiceImpl.class).asEagerSingleton();
    }
}
