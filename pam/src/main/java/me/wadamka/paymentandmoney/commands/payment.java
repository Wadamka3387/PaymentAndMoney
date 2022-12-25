package me.wadamka.paymentandmoney.commands;

import me.wadamka.paymentandmoney.storage.DeathKillAndBalance;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class payment implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length == 0 || args.length == 1){
                p.sendMessage(ChatColor.GOLD + "Usage: /pay <user> <amount>");
            } else if (args.length == 2) {

                int payAmount = Integer.parseInt(args[1]);

                if(payAmount >= 1){

                    for(Player target : Bukkit.getOnlinePlayers()){

                        if(target.getName().equalsIgnoreCase(args[0])){

                            if(DeathKillAndBalance.getData(p, DeathKillAndBalance.balance) >= payAmount){

                                DeathKillAndBalance.setData(p, DeathKillAndBalance.balance, -payAmount);
                                p.sendMessage(ChatColor.GOLD + "paid " + payAmount + " to " + target.getName() + ".");
                                DeathKillAndBalance.setData(target, DeathKillAndBalance.balance, +payAmount);
                                target.sendMessage(ChatColor.GOLD + "received " + payAmount + " from " + p.getName() + ".");

                            } else {
                                p.sendMessage(ChatColor.RED + "not enough money lol");
                            }

                        }

                    }
                }


            } else if (args.length >= 3) {

                p.sendMessage(ChatColor.RED + "Wrong usage. Too many arguments.");

                return false;
            }


            // this is just for testing because I have no friends to test. This isnt supposed to be reviewed. Dont mind this part, I just set my money here. (I know its poorly coded...)
            if(args[0].equalsIgnoreCase("set")){

                int amount = Integer.parseInt(args[1]);

                DeathKillAndBalance.setData(p, DeathKillAndBalance.balance, amount);

            }
            // heres the end of the shitty part

        }

        return true;
    }
}
