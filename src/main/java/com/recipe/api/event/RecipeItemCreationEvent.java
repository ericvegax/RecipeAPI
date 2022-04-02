package com.recipe.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class RecipeItemCreationEvent extends PlayerEvent implements Cancellable {

    private static HandlerList handlerList = new HandlerList();

    private boolean isCancelled;

    public RecipeItemCreationEvent(Player who) {
        super(who);
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }

    public static HandlerList getHandler() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
