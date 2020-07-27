package com.github.unrelatedstring.three_toggles;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;

import java.util.function.Function;

public class ToggleBinding {
    public KeyBinding binding;
    public boolean on = false;
    public Function<MinecraftClient, KeyBinding> target;

    public ToggleBinding(String id, int key, Function<MinecraftClient, KeyBinding> target) {
        this.target = target;
        binding = new KeyBinding(id, key, "category.three_toggles.toggles");
        KeyBindingHelper.registerKeyBinding(binding);
        ClientTickCallback.EVENT.register(this::tick);
    }

    public void tick(MinecraftClient client) {
        if (binding.wasPressed()) {
            while (binding.wasPressed()) ;
            if (on) {
                target.apply(client).setPressed(false);
            }
            on = !on;
        }
        if (on) {
            target.apply(client).setPressed(true);
        }
    }
}
