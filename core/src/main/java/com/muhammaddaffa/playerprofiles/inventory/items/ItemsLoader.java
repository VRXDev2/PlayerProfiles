package com.muhammaddaffa.playerprofiles.inventory.items;

import com.muhammaddaffa.playerprofiles.PlayerProfiles;
import com.muhammaddaffa.playerprofiles.configs.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ItemsLoader {

    private final List<GUIItem> mainMenuItems = new ArrayList<>();

    private final PlayerProfiles plugin;
    public ItemsLoader(PlayerProfiles plugin){
        this.plugin = plugin;
    }

    public void loadItems(){
        loadMainMenuItems();
    }

    public void reloadItems(){
        mainMenuItems.clear();

        loadMainMenuItems();
    }

    private void loadMainMenuItems(){
        FileConfiguration config = ConfigManager.GUI.getConfig();
        // Return if there is no items
        if(!config.isConfigurationSection("items")) return;
        // Loop through all items
        for(String configKey : config.getConfigurationSection("items").getKeys(false)){
            String path = "items." + configKey;
            String type = config.getString(path + ".type");
            String material = config.getString(path + ".material");
            int amount = config.getInt(path + ".amount");
            String name = config.getString(path + ".name");
            List<Integer> slots = config.getIntegerList(path + ".slots");
            boolean glowing = config.getBoolean(path + ".glowing");
            boolean hideAttributes = config.getBoolean(path + ".hideAttributes");
            int customModelData = config.getInt(path + ".customModelData");
            boolean onlyOwner = config.getBoolean(path + ".onlyOwner");
            boolean onlyVisitor = config.getBoolean(path + ".onlyVisitor");
            boolean usePermission = config.getBoolean(path + ".usePermission");
            String permission = config.getString(path + ".permission");
            List<String> lore = config.getStringList(path + ".lore");
            List<String> leftCommands = config.getStringList(path + ".leftClickCommands");
            List<String> rightCommands = config.getStringList(path + ".rightClickCommands");
            // Finally add the item to the list
            GUIItem guiItem = new GUIItem(type, material, amount, name, slots, glowing, hideAttributes, usePermission,
                    permission, lore, leftCommands, rightCommands, customModelData, onlyOwner, onlyVisitor);
            this.mainMenuItems.add(guiItem);
        }
    }

    public List<GUIItem> getMainMenuItems(){
        return mainMenuItems;
    }

}
