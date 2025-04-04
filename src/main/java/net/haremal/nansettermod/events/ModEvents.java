package net.haremal.nansettermod.events;

import net.haremal.nansettermod.NaNSetter;
import net.haremal.nansettermod.commands.SetNaNCommand;
import net.haremal.nansettermod.commands.UnsetNaNCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = NaNSetter.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event){
        new SetNaNCommand(event.getDispatcher());
        new UnsetNaNCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
