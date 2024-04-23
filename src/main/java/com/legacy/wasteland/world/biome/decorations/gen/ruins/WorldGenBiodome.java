package com.legacy.wasteland.world.biome.decorations.gen.ruins;

import com.legacy.wasteland.Wasteland;
import com.legacy.wasteland.config.WastelandConfig;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class WorldGenBiodome extends WorldGenerator {
    public boolean generate(World world, Random rand, BlockPos pos) {
        WorldServer worldserver = (WorldServer) world;
        MinecraftServer minecraftserver = world.getMinecraftServer();
        TemplateManager templatemanager = worldserver.getStructureTemplateManager();
        Template template = templatemanager.getTemplate(minecraftserver, new ResourceLocation(Wasteland.MOD_ID+":biodome"));
        PlacementSettings settings = new PlacementSettings();

        if(template == null)
        {
            System.out.println("NO STRUCTURE");
            return false;
        }

        settings.setRotation(Rotation.CLOCKWISE_90);
        if (world.getBlockState(pos.down()).getBlock() == WastelandConfig.worldgen.getSurfaceBlock()) {
            template.addBlocksToWorld(world, pos, settings);
            return true;
        }
        else {
            return false;
        }
    }
}
