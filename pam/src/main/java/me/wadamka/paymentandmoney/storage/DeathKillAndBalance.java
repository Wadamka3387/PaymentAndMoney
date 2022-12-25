package me.wadamka.paymentandmoney.storage;

import me.wadamka.paymentandmoney.PaymentAndMoney;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class DeathKillAndBalance implements Listener {

    static PersistentDataContainer data;
    public static NamespacedKey kills = new NamespacedKey(PaymentAndMoney.gpl(), "kills");
    public static NamespacedKey deaths = new NamespacedKey(PaymentAndMoney.gpl(), "deaths");
    public static NamespacedKey balance = new NamespacedKey(PaymentAndMoney.gpl(), "balance");

    @EventHandler
    public static void playerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        data = p.getPersistentDataContainer();

        if(!data.has(kills)){
            data.set(kills, PersistentDataType.INTEGER, 0);
            System.out.println("No player data found! Set kills to 0");
        }

        if(!data.has(deaths)){
            data.set(deaths, PersistentDataType.INTEGER, 0);
            System.out.println("No player data found! Set deaths to 0");
        }

        if(!data.has(balance)){
            data.set(balance, PersistentDataType.INTEGER, 0);
            System.out.println("No player data found! Set balance to 0");
        }

    }


    public static Integer getData(Player p, NamespacedKey key){

        return p.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);

    }

    public static void setData(Player p, NamespacedKey key, Integer value){

        p.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, value);

    }


}
