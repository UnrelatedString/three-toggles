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
