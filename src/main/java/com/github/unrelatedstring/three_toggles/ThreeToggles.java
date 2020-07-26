package com.github.unrelatedstring.three_toggles;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ThreeToggles implements ClientModInitializer {
	public static KeyBinding toggleSneak;
	public static KeyBinding toggleWalk;
	public static KeyBinding toggleMine;

	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		toggleSneak = new KeyBinding("key.three_toggles.sneak",
				   			         InputUtil.Type.KEYSYM,
									 GLFW.GLFW_KEY_V,
									 "category.three_toggles.toggles");
		toggleWalk =  new KeyBinding("key.three_toggles.walk",
									 InputUtil.Type.KEYSYM,
				                     GLFW.GLFW_KEY_B,
					                 "category.three_toggles.toggles");
		toggleMine =  new KeyBinding("key.three_toggles.mine",
								     InputUtil.Type.KEYSYM,
								     GLFW.GLFW_KEY_N,
					        		 "category.three_toggles.toggles");

		KeyBindingHelper.registerKeyBinding(toggleSneak);
		KeyBindingHelper.registerKeyBinding(toggleWalk);
		KeyBindingHelper.registerKeyBinding(toggleMine);
	}
}
