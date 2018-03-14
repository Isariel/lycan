package net.isariel.lycan.spigot.service.tablist;

import com.comphenix.protocol.wrappers.WrappedChatComponent;
import net.isariel.lycan.api.protocol.WrapperPlayServerPlayerListHeaderFooter;
import net.isariel.lycan.api.service.tablist.TablistService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class TablistServiceImpl implements TablistService {

    @Override
    public void sendHeaderFooter(Player player, String header, String footer) {
        WrappedChatComponent headerComponent = WrappedChatComponent.fromText(header);
        WrappedChatComponent footerComponent = WrappedChatComponent.fromText(footer);

        sendHeaderFooter(player, headerComponent, footerComponent);
    }

    @Override
    public void sendHeaderFooter(UUID playerUniqueId, String header, String footer) {
        Player player = Bukkit.getPlayer(playerUniqueId);
        sendHeaderFooter(player, header, footer);
    }

    @Override
    public void sendHeaderFooter(UUID playerUniqueId, WrappedChatComponent header, WrappedChatComponent footer) {
        Player player = Bukkit.getPlayer(playerUniqueId);
        sendHeaderFooter(player, header, footer);
    }

    @Override
    public void sendHeaderFooter(Player player, WrappedChatComponent header, WrappedChatComponent footer) {
        WrapperPlayServerPlayerListHeaderFooter packet = new WrapperPlayServerPlayerListHeaderFooter();
        packet.setHeader(header);
        packet.setFooter(footer);
        packet.sendPacket(player);
    }
}
