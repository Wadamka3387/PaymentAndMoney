package me.wadamka.paymentandmoney.listeners;

import me.wadamka.paymentandmoney.storage.DeathKillAndBalance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public static void PlayerDeath(PlayerDeathEvent e){
        Player target = e.getPlayer();
        Player killer = (Player) target.getKiller();

        DeathKillAndBalance.setData(target, DeathKillAndBalance.deaths, +1);
        System.out.println(DeathKillAndBalance.getData(target, DeathKillAndBalance.deaths));
        DeathKillAndBalance.setData(killer, DeathKillAndBalance.kills, +1);
        System.out.println(DeathKillAndBalance.getData(killer, DeathKillAndBalance.kills));


    }

}
