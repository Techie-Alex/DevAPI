package me.devanonymous.Server.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class DevGUI {
    public static class Items {
        public static void customItem(Inventory inventory, Material material, Byte id, Integer amount, Integer slot, String customName, List<String> lores) {
            ItemStack is = new ItemStack(material, amount, id);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', customName));
            im.setLore(lores);
            is.setItemMeta(im);
            inventory.setItem(slot, is);
        }

        public static void customItem(Inventory inventory, Material material, Byte id, Integer amount, Integer slot, String customName) {
            ItemStack is = new ItemStack(material, amount, id);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', customName));
            is.setItemMeta(im);
            inventory.setItem(slot, is);
        }

        public static void customEnchantedItem(Inventory inventory, Material material, Byte id, Integer amount, Integer slot, String customName, Enchantment enchantment, Integer level, List<String> lores) {
            ItemStack is = new ItemStack(material, amount, id);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', customName));
            im.setLore(lores);
            is.setItemMeta(im);
            is.addUnsafeEnchantment(enchantment, level);
            inventory.setItem(slot, is);
        }

        public static void customEnchantedItem(Inventory inventory, Material material, Byte id, Integer amount, Integer slot, String customName, Enchantment enchantment, Integer level) {
            ItemStack is = new ItemStack(material, amount, id);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', customName));
            is.setItemMeta(im);
            is.addUnsafeEnchantment(enchantment, level);
            inventory.setItem(slot, is);
        }

        public static void skullItem(Inventory inventory, String headOwnerName, Integer amount, Integer slot, String customName, List<String> lores) {
            ItemStack is = new ItemStack(Material.SKULL_ITEM, amount);
            is.setDurability((short) 3);
            SkullMeta sm = (SkullMeta) is.getItemMeta();
            sm.setDisplayName(ChatColor.translateAlternateColorCodes('&', customName));
            sm.setLore(lores);
            sm.setOwner(headOwnerName);
            is.setItemMeta(sm);
            inventory.setItem(slot, is);
        }

        public static void skullItem(Inventory inventory, String headOwnerName, Integer amount, Integer slot, String customName) {
            ItemStack is = new ItemStack(Material.SKULL_ITEM, amount);
            is.setDurability((short) 3);
            SkullMeta sm = (SkullMeta) is.getItemMeta();
            sm.setDisplayName(ChatColor.translateAlternateColorCodes('&', customName));
            sm.setOwner(headOwnerName);
            is.setItemMeta(sm);
            inventory.setItem(slot, is);
        }

        public static void fillItem(Inventory inventory, Integer filler_slot) {
            ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(" ");
            is.setItemMeta(im);
            inventory.setItem(filler_slot, is);
        }

        public static void fillItem(Inventory inventory, Integer filler_slot, Byte color) {
            ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, 1, color);
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(" ");
            is.setItemMeta(im);
            inventory.setItem(filler_slot, is);
        }
    }

    public static class Clicks {
        public static Boolean clickVerify(String invTitle, InventoryClickEvent event, String customName) {
            if (event.getCurrentItem() != null && event.getInventory().getTitle().equalsIgnoreCase(invTitle))
                if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', customName)))
                    return true;
            return false;
        }

        public static Boolean clickVerify(String invTitle, InventoryClickEvent event, Integer slot) {
            if (event.getCurrentItem() != null && event.getInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', invTitle)))
                if (event.getSlot() == slot)
                    return true;
            return false;
        }

        public static Boolean clickVerify(Inventory inventory, InventoryClickEvent event, String customName) {
            if (event.getCurrentItem() != null && event.getInventory().equals(inventory))
                if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', customName)))
                    return true;
            return false;
        }

        public static Boolean clickVerify(Inventory inventory, InventoryClickEvent event, Integer slot) {
            if (event.getCurrentItem() != null && event.getInventory().equals(inventory))
                if (event.getSlot() == slot)
                    return true;
            return false;
        }

        public static void preventClick(String invTitle, InventoryClickEvent event) {
            if (event.getInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', invTitle)))
                event.setCancelled(true);
        }

        public static void preventClick(Inventory inventory, InventoryClickEvent event) {
            if (event.getInventory().equals(inventory)) event.setCancelled(true);
        }

        public static void preventItemClick(String invTitle, InventoryClickEvent event, Integer slot) {
            if (event.getInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', invTitle)) && event.getSlot() == slot)
                event.setCancelled(true);
        }

        public static void preventItemClick(Inventory inventory, InventoryClickEvent event, Integer slot) {
            if (event.getInventory().equals(inventory) && event.getSlot() == slot) event.setCancelled(true);
        }
    }

    public static class Tools {
        public static Inventory createInv(Integer size, String title) {
            return Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', title));
        }

        public static void refreshInv(InventoryClickEvent event) {
            event.getWhoClicked().openInventory(event.getInventory());
        }

        public static void closeInv(InventoryClickEvent event) {
            event.getWhoClicked().closeInventory();
        }
    }

    public static class Fillers {
        public static void fillInv(Inventory inventory) {
            for (Integer i = 0; i < inventory.getSize(); i++) {
                if (i > inventory.getSize()) break;
                if (inventory.getItem(i) == null) Items.fillItem(inventory, i);
            }
        }

        public static void fillInv(Inventory inventory, Byte color) {
            for (Integer i = 0; i < inventory.getSize(); i++) {
                if (i > inventory.getSize()) break;
                if (inventory.getItem(i) == null) Items.fillItem(inventory, i, color);
            }
        }

        public static void fillStyleRandom(Inventory inventory) {
            List<Byte> l = Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14);
            for (Integer i = 0; i < inventory.getSize(); i++) {
                if (i > inventory.getSize()) break;
                if (inventory.getItem(i) == null) Items.fillItem(inventory, i, l.get(new Random().nextInt(l.size())));
            }
        }

        public static void fillStyleRainbowColors(Inventory inventory) {
            List<Byte> l = Arrays.asList((byte) 14, (byte) 1, (byte) 4, (byte) 5, (byte) 3, (byte) 10, (byte) 2);
            for (Integer i = 0; i < inventory.getSize(); i++) {
                if (i > inventory.getSize()) break;
                if (inventory.getItem(i) == null) Items.fillItem(inventory, i, l.get(new Random().nextInt(l.size())));
            }
        }

        public static void fillStyleRainbow(Inventory inventory) {
            List<Byte> l = Arrays.asList((byte) 14, (byte) 1, (byte) 4, (byte) 5, (byte) 3, (byte) 10, (byte) 2);
            Integer c = 0;
            for (Integer i = 0; i < inventory.getSize(); i++) {
                if (i > inventory.getSize()) break;
                c++;
                if (c >= l.size()) c = 1;
                if (inventory.getItem(i) == null) Items.fillItem(inventory, i, l.get(c));
            }
        }

        public static void fillStyleCheckered(Inventory inventory, Byte color1, Byte color2) {
            for (Integer i = 0; i < inventory.getSize(); i++) {
                if (i > inventory.getSize()) break;
                if (inventory.getItem(i) == null) if (i % 2 == 0) {
                    Items.fillItem(inventory, i, color1);
                } else Items.fillItem(inventory, i, color2);
            }
        }

        public static void fillStyleRows(Inventory inventory, Byte color1, Byte color2) {
            for (Integer r = 1; r <= inventory.getSize() / 9; r++) {
                if (r % 2 == 0) {
                    for (Integer s = r * 9 - 9; s < r * 9; s++)
                        if (inventory.getItem(s) == null) Items.fillItem(inventory, s, color2);
                } else for (Integer s = r * 9 - 9; s < r * 9; s++)
                    if (inventory.getItem(s) == null) Items.fillItem(inventory, s, color1);
            }
        }
    }
}
