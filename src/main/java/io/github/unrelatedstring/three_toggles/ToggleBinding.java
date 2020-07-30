/*
 * SPDX-FileCopyrightText: 2020 UnrelatedString <unrelatedstring@gmail.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.unrelatedstring.three_toggles;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.options.StickyKeyBinding;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ToggleBinding {
    public KeyBinding binding;
    public Function<MinecraftClient, KeyBinding> target;
    public static Map<String, ToggleBinding> toggles = new HashMap<>();

    public ToggleBinding(String id, int key, Function<MinecraftClient, KeyBinding> target, String targetTranslationKey) {
        this.target = target;
        binding = new StickyKeyBinding(id, key, "category.three_toggles.toggles", () -> true);
        KeyBindingHelper.registerKeyBinding(binding);
        toggles.put(targetTranslationKey, this);
    }
}
