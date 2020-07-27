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
						  			    (client) -> client.options.keySneak);
		toggleWalk  = new ToggleBinding("key.three_toggles.walk",
				    				    GLFW.GLFW_KEY_B,
									    (client) -> client.options.keyForward);
		toggleMine  = new ToggleBinding("key.three_toggles.mine",
										GLFW.GLFW_KEY_N,
										(client) -> client.options.keyAttack);

	}
}
