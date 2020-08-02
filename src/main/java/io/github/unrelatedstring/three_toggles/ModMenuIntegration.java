/*
 * SPDX-FileCopyrightText: 2020 UnrelatedString <unrelatedstring@gmail.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.unrelatedstring.three_toggles;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

//It's worth noting that this file is more or less copied straight off of https://shedaniel.gitbook.io/cloth-config/advanced/modmenu-integration and https://shedaniel.gitbook.io/cloth-config/auto-config/generating-a-cloth-config-screen

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (screen) -> AutoConfig.getConfigScreen(ToggleConfig.class, screen).get();
    }
}
