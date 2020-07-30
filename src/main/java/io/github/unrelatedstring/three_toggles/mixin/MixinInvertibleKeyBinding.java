/*
 * SPDX-FileCopyrightText: 2020 UnrelatedString <unrelatedstring@gmail.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
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
