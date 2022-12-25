package me.wadamka.paymentandmoney;

import me.wadamka.paymentandmoney.commands.payment;
import me.wadamka.paymentandmoney.listeners.PlayerDeath;
import me.wadamka.paymentandmoney.storage.DeathKillAndBalance;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaymentAndMoney extends JavaPlugin {

    public static PaymentAndMoney pl;

    @Override
    public void onEnable() {
        // Plugin startup logic

        pl = this;

        Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DeathKillAndBalance(), this);

        this.getCommand("pay").setExecutor(new payment());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static PaymentAndMoney gpl(){

        return pl;

    }


}
