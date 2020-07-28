/*
 * This file is part of three-toggles.
 *
 * three-toggles is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * three-toggles is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with three-toggles. If not, see <https://www.gnu.org/licenses/>.
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
