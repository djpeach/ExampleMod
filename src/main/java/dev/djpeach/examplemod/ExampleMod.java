package dev.djpeach.examplemod;

import dev.djpeach.examplemod.proxy.SideProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = ExampleMod.MOD_ID,
        name = ExampleMod.MOD_NAME,
        version = ExampleMod.VERSION
)
public class ExampleMod {

    public static final String MOD_ID = "examplemod";
    public static final String MOD_NAME = "Example Mod";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static final String CLIENT_PROXY = "dev.djpeach.examplemod.proxy.ClientSideProxy";
    public static final String SERVER_PROXY = "dev.djpeach.examplemod.proxy.ServerSideProxy";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static ExampleMod INSTANCE;

    /**
     * This will use the right class based on the physical side
     */
    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static SideProxy proxy;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     *
     * e.g.:
     *      public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
        public static final Block myRock = null;
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     *
     * e.g.:
     *      public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
     *      public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {

    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         *
         * e.g.:
         *      event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
         *      event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new ItemBlock(Blocks.myRock).setRegistryName(MOD_ID, "myrock"));
        }

        /**
         * Listen for the register event for creating custom blocks
         *
         * e.g.:
         *      event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
            Blocks.myRock.setHardness(0.1f);
            Blocks.myRock.setCreativeTab(CreativeTabs.MATERIALS);
            Blocks.myRock.setRegistryName(MOD_ID,"myrock");
            event.getRegistry().register(new Block(Material.ROCK));
        }
    }
}
