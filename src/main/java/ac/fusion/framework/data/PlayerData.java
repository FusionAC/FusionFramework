package ac.fusion.framework.data;

import org.bukkit.entity.Player;

public interface PlayerData {
    Player getPlayer();

    long currentTick();

    void queuePreTask(Runnable task);

    void queuePostTask(Runnable task);
}
