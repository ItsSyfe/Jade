package mcp.mobius.waila.api;

import javax.annotation.Nullable;

import mcp.mobius.waila.api.config.IPluginConfig;
import mcp.mobius.waila.api.ui.IElement;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Callback class interface used to provide Entity tooltip informations to Waila.<br>
 * All methods in this interface shouldn't to be called by the implementing mod. An instance of the class is to be
 * registered to Waila via the {@link IRegistrar} instance provided in the original registration callback method
 * (cf. {@link IRegistrar} documentation for more information).
 *
 * @author ProfMobius
 */
public interface IEntityComponentProvider {

	/**
     * Callback used to set an item to display alongside the entity name in the tooltip, similar to how blocks are treated.
     * Will only be called if the implementing class is registered via {@link}
     *
     * This method is only called on the client side. If you require data from the server, you should also implement
     * {@link IServerDataProvider#appendServerData(net.minecraft.nbt.CompoundNBT, net.minecraft.entity.player.ServerPlayerEntity, World, Object)}
     * and add the data to the {@link net.minecraft.nbt.CompoundNBT} there, which can then be read back using {@link IBlockAccessor#getServerData()}.
     * If you rely on the client knowing the data you need, you are not guaranteed to have the proper values.
     *
     * @param accessor Contains most of the relevant information about the current environment.
     * @param config   Current configuration of Waila.
     * @return The item to display or {@link ItemStack#EMPTY} to display nothing.
     */
	@Nullable
	default IElement getIcon(IEntityAccessor accessor, IPluginConfig config, IElement currentIcon) {
		return null;
	}

	/**
     * Callback used to add lines to one of the three sections of the tooltip (Head, Body, Tail).</br>
     * Will only be called if the implementing class is registered via {@link IRegistrar#registerComponentProvider(IEntityComponentProvider, TooltipPosition, Class)}.</br>
     * You are supposed to always return the modified input currenttip.</br>
     *
     * This method is only called on the client side. If you require data from the server, you should also implement
     * {@link IServerDataProvider#appendServerData(net.minecraft.nbt.CompoundNBT, net.minecraft.entity.player.ServerPlayerEntity, World, Object)}
     * and add the data to the {@link net.minecraft.nbt.CompoundNBT} there, which can then be read back using {@link IBlockAccessor#getServerData()}.
     * If you rely on the client knowing the data you need, you are not guaranteed to have the proper values.
     *
     * @param tooltip    Current list of tooltip lines (might have been processed by other providers and might be processed by other providers).
     * @param accessor   Contains most of the relevant information about the current environment.
     * @param config     Current configuration of Waila.
     */
	default void append(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {

	}

}
