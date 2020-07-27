package com.github.unrelatedstring.three_toggles;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.options.StickyKeyBinding;
import org.lwjgl.glfw.GLFW;

public class ThreeToggles implements ClientModInitializer {
	public static KeyBinding toggleSneak;
	public static KeyBinding toggleWalk;
	public static KeyBinding toggleMine;

	private static void onTick(MinecraftClient client) {
		if (toggleSneak.isPressed()) {
			client.player.input.sneaking = true;
			System.out.println(client.player.isSneaking());
		}
	}

	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		toggleSneak = new StickyKeyBinding("key.three_toggles.sneak",
										   GLFW.GLFW_KEY_V,
				             	           "category.three_toggles.toggles",
		                                   () -> true);
		toggleWalk  = new StickyKeyBinding("key.three_toggles.walk",
									       GLFW.GLFW_KEY_B,
					                       "category.three_toggles.toggles",
							  	           () -> true);
		toggleMine  = new StickyKeyBinding("key.three_toggles.mine",
								     	   GLFW.GLFW_KEY_N,
					        		 	   "category.three_toggles.toggles",
										   () -> true);

		KeyBindingHelper.registerKeyBinding(toggleSneak);
		KeyBindingHelper.registerKeyBinding(toggleWalk);
		KeyBindingHelper.registerKeyBinding(toggleMine);

		ClientTickCallback.EVENT.register(ThreeToggles::onTick);
	}
}
