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

package io.github.unrelatedstring.three_toggles.mixin;

import io.github.unrelatedstring.three_toggles.ToggleBinding;
import net.minecraft.client.options.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KeyBinding.class)
public abstract class MixinInvertibleKeyBinding {

    @Shadow
    private String translationKey;

    @Inject(at = @At("RETURN"), method = "isPressed()Z", cancellable = true)
    private void onIsPressed(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                cir.getReturnValue() ^
                        (ToggleBinding.toggles.containsKey(translationKey) &&
                                ToggleBinding.toggles.get(translationKey).binding.isPressed()));
    }
}
