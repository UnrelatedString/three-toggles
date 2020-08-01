/*
 * SPDX-FileCopyrightText: 2020 UnrelatedString <unrelatedstring@gmail.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.unrelatedstring.three_toggles;

import com.sun.tools.internal.xjc.model.CDefaultValue;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import org.lwjgl.glfw.GLFW;

public class ThreeToggles implements ClientModInitializer {

    // designed for QWERTY, respecting default vanilla key bindings
    static final int[] defaultKeys = {
            GLFW.GLFW_KEY_V,
            GLFW.GLFW_KEY_B,
            GLFW.GLFW_KEY_N,
            GLFW.GLFW_KEY_M,
            GLFW.GLFW_KEY_COMMA,
            GLFW.GLFW_KEY_PERIOD,
            GLFW.GLFW_KEY_G,
            GLFW.GLFW_KEY_H,
            GLFW.GLFW_KEY_J,
            GLFW.GLFW_KEY_K,
            GLFW.GLFW_KEY_L,
            GLFW.GLFW_KEY_SEMICOLON,
            GLFW.GLFW_KEY_APOSTROPHE,
            GLFW.GLFW_KEY_R,
            GLFW.GLFW_KEY_Y,
            GLFW.GLFW_KEY_U,
            GLFW.GLFW_KEY_I,
            GLFW.GLFW_KEY_O,
            GLFW.GLFW_KEY_P,
            GLFW.GLFW_KEY_LEFT_BRACKET,
            GLFW.GLFW_KEY_RIGHT_BRACKET,
            GLFW.GLFW_KEY_BACKSLASH,
            GLFW.GLFW_KEY_MINUS,
            GLFW.GLFW_KEY_EQUAL,
            GLFW.GLFW_KEY_BACKSPACE
    };

    @Override
    public void onInitializeClient() {

        AutoConfig.register(ToggleConfig.class, GsonConfigSerializer::new);
        setBindings();

    }

    public void setBindings() {
        ToggleBinding.toggles.clear();
        ToggleConfig config = AutoConfig.getConfigHolder(ToggleConfig.class).getConfig();
        int i = 0;
        for (String target : config.targets) {
            new ToggleBinding(
                    i < defaultKeys.length ? defaultKeys[i++] : -1,
                    target);
        }
    }
}
