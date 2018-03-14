package net.isariel.lycan.api.service.tablist;

import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public interface TablistService {

    /**
     * Set header and footer of the given player.
     *
     * @param player The player.
     * @param header The header text.
     * @param footer The footer text.
     */
    void sendHeaderFooter(Player player, String header, String footer);

    /**
     * Set header and footer of the given player.
     *
     * @param playerUniqueId The unique id of the player.
     * @param header The header text.
     * @param footer The footer text.
     */
    void sendHeaderFooter(UUID playerUniqueId, String header, String footer);

    /**
     * Set header and footer of the given player.
     *
     * @param player The player.
     * @param header The header component.
     * @param footer The footer component.
     */
    void sendHeaderFooter(Player player, WrappedChatComponent header, WrappedChatComponent footer);

    /**
     * Set header and footer of the given player.
     *
     * @param playerUniqueId The unique id of the player.
     * @param header The header component.
     * @param footer The footer component.
     */
    void sendHeaderFooter(UUID playerUniqueId, WrappedChatComponent header, WrappedChatComponent footer);
}
