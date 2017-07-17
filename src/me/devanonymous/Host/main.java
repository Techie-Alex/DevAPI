package me.devanonymous.Host;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

public class main extends Plugin {
    public static String cp = "\u00a79";
    public static String cs = "\u00a7b";
    public static String ct = "\u00a77";
    public static String prefix = cp + "\u00a7lDevAPI \u00a7r" + ct;
    public static Plugin p;

    @Override
    public void onEnable() {
        p = this;
        getProxy().getConsole().sendMessage(new TextComponent("\u00a78###########################################################"));
        getProxy().getConsole().sendMessage(new TextComponent("\u00a78#                                                         \u00a78#"));
        getProxy().getConsole().sendMessage(new TextComponent("\u00a78#              " + ct + "\u00a7lDevAPIHost Loaded! Version " + cs + "\u00a7l" + getDescription().getVersion() + "             \u00a78#"));
        getProxy().getConsole().sendMessage(new TextComponent("\u00a78#                                                         \u00a78#"));
        getProxy().getConsole().sendMessage(new TextComponent("\u00a78###########################################################"));
    }
}
