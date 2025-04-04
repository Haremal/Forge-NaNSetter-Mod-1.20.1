package net.haremal.nansettermod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SetNaNCommand {
    public SetNaNCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("nanhealth").then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("set").executes(((command) -> {
            Entity entity = EntityArgument.getEntity(command, "target");
            if (entity instanceof LivingEntity livingEntity) {
                return setNaN(command.getSource(), livingEntity);
            } else {
                command.getSource().sendFailure(Component.nullToEmpty("Target is not a living entity!"));
                return 0;
            }
        })))));
    }

    private int setNaN(CommandSourceStack source, LivingEntity livingEntity) throws CommandSyntaxException {
        livingEntity.setHealth(Float.NaN);
        return Command.SINGLE_SUCCESS;
    }
}
