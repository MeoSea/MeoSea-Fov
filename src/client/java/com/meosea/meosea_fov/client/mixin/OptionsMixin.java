package com.meosea.meosea_fov.client.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

import com.meosea.meosea_fov.client.config.ConfigManager;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;

@Mixin(Options.class)
public class OptionsMixin {

	@ModifyArg(
		method = "<init>",
		slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=options.fov")),
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/OptionInstance$IntRange;<init>(II)V",
			ordinal = 0
		),
		index = 0
	)
	private int meosea$minFov(int min) {
		return ConfigManager.get().minFov;
	}

	@ModifyArg(
		method = "<init>",
		slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=options.fov")),
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/OptionInstance$IntRange;<init>(II)V",
			ordinal = 0
		),
		index = 1
	)
	private int meosea$maxFov(int max) {
		return ConfigManager.get().maxFov;
	}

	@ModifyArg(
		method = "<init>",
		slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=options.fov")),
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/OptionInstance;<init>",
			ordinal = 0
		),
		index = 2
	)
	private OptionInstance.CaptionBasedToString<Integer> fovmod$fovLabel(OptionInstance.CaptionBasedToString<Integer> original) {
		return (caption, value) -> {
			if (value == 70) {
				return Options.genericValueLabel(caption, Component.translatable("options.fov.min"));
			} else if (value == ConfigManager.get().maxFov) {
				return Options.genericValueLabel(caption, Component.translatable("options.fov.max"));
			}
			return Options.genericValueLabel(caption, value);
		};
	}
}