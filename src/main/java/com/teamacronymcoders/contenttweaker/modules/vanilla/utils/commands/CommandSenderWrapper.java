package com.teamacronymcoders.contenttweaker.modules.vanilla.utils.commands;

import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CommandSenderWrapper implements ICommandSender {
    private final ICommandSender parent;
    private final boolean bypassPermissions;
    private final boolean sendMessages;

    public CommandSenderWrapper(ICommandSender parent, boolean bypassPermissions, boolean sendMessages) {
        this.parent = parent;
        this.bypassPermissions = bypassPermissions;
        this.sendMessages = sendMessages;
    }

    @Nonnull
    @Override
    public String getName() {
        return parent.getName();
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return parent.getDisplayName();
    }

    @Override
    public void sendMessage(@Nonnull ITextComponent component) {
        if (sendMessages) {
            parent.sendMessage(component);
        }
    }

    @Override
    public boolean canUseCommand(int permLevel, @Nonnull String commandName) {
        return bypassPermissions || parent.canUseCommand(permLevel, commandName);
    }

    @Nonnull
    @Override
    public BlockPos getPosition() {
        return parent.getPosition();
    }

    @Nonnull
    @Override
    public Vec3d getPositionVector() {
        return parent.getPositionVector();
    }

    @Nonnull
    @Override
    public World getEntityWorld() {
        return parent.getEntityWorld();
    }

    @Override
    @Nullable
    public Entity getCommandSenderEntity() {
        return parent.getCommandSenderEntity();
    }

    @Override
    public boolean sendCommandFeedback() {
        return sendMessages && parent.sendCommandFeedback();
    }

    @Override
    public void setCommandStat(@Nonnull CommandResultStats.Type type, int amount) {
        parent.setCommandStat(type, amount);
    }

    @Override
    @Nullable
    public MinecraftServer getServer() {
        return parent.getServer();
    }
}
