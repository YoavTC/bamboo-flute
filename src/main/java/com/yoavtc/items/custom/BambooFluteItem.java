package com.yoavtc.items.custom;

import com.yoavtc.sound.ModSounds;
import com.yoavtc.sound.Notes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class BambooFluteItem extends Item {
    public BambooFluteItem(Settings settings) {
        super(settings);
    }

    public static int note;
    public boolean isUsing;
    public long lastUse = System.currentTimeMillis();
    public long cooldown = 550;

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            if (note != getNote((PlayerEntity) user) && lastUse + cooldown <= System.currentTimeMillis()) {
                note = getNote((PlayerEntity) user);
                playSound(world, (PlayerEntity) user);
                lastUse = System.currentTimeMillis();
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            isUsing = true;
        }

        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            isUsing = false;
            note = 9;
        }
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {return UseAction.TOOT_HORN;}

    private int getNote(PlayerEntity player) {
        float tempNote;
        tempNote = player.getPitch();

        tempNote = Math.min(tempNote, 30f);
        tempNote = Math.max(tempNote, -40f);

        int rounded = (int) (Math.round(tempNote / 10.0) * 10);


        switch (rounded) {
            case -40 -> {return 1;}
            case -30 -> {return 2;}
            case -20 -> {return 3;}
            case -10 -> {return 4;}
            case 0 -> {return 5;}
            case 10 -> {return 6;}
            case 20 -> {return 7;}
            case 30 -> {return 8;}
            default -> {return 9;}
        }
    }

    private void playSound(World world, PlayerEntity player) {
        switch (note) {
            case 1 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_HDO, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.RED)), true);
            }
            case 2 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_TI, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.GOLD)), true);
            }
            case 3 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_LA, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.YELLOW)), true);
            }
            case 4 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_SO, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.GREEN)), true);
            }
            case 5 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_FA, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_GREEN)), true);
            }
            case 6 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_MI, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.BLUE)), true);
            }
            case 7 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_RE, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)), true);
            }
            case 8 -> {
                world.playSound(null, player.getBlockPos(), ModSounds.BAMBOO_LDO, SoundCategory.RECORDS, 1.0f, 1.0f);
                player.sendMessage(Text.literal(Notes.values()[(note - 1)].toString()).setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)), true);
            }
            case 9 ->
                    world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_EVOKER_PREPARE_WOLOLO, SoundCategory.RECORDS, 1.0f, 1.0f);
        }
    }
}
