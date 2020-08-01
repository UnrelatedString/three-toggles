/*
 * SPDX-FileCopyrightText: 2020 UnrelatedString <unrelatedstring@gmail.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.unrelatedstring.three_toggles;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

import java.util.*;

@Config(name = "three_toggles")
public class ToggleConfig implements ConfigData {
    boolean isTheSaveAndQuitButtonBeingDumb = true;
    @ConfigEntry.Gui.Tooltip(count = 3)
    List<String> targets = new ArrayList<String>(Arrays.asList("key.attack", "key.forward", "key.sneak"));

}
