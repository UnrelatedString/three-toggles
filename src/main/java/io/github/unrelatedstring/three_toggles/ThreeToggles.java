/*
 * SPDX-FileCopyrightText: 2022 UnrelatedString <unrelatedstring@gmail.com>
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package io.github.unrelatedstring.three_toggles;

import net.fabricmc.api.ClientModInitializer;
import org.lwjgl.glfw.GLFW;

public class ThreeToggles implements ClientModInitializer {
    public static ToggleBinding toggleSneak;
    public static ToggleBinding toggleWalk;
    public static ToggleBinding toggleMine;

    @Override
    public void onInitializeClient() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        toggleSneak = new ToggleBinding("key.three_toggles.sneak",
                GLFW.GLFW_KEY_V,
                "key.sneak");
        toggleWalk = new ToggleBinding("key.three_toggles.walk",
                GLFW.GLFW_KEY_B,
                "key.forward");
        toggleMine = new ToggleBinding("key.three_toggles.mine",
                GLFW.GLFW_KEY_N,
                "key.attack");

    }
}
