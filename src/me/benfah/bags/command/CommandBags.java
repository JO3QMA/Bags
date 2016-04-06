package me.benfah.bags.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import me.benfah.bags.main.Bags;
import me.benfah.bags.main.RecipeManager;
import me.benfah.bags.translation.Translation;

public class CommandBags implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("hi");

		if(command.getName().equalsIgnoreCase("bags"))
		{
			if(args.length >= 1)
			{
				if(args[0].equalsIgnoreCase("credits"))
				{
					
					sender.sendMessage(Translation.bag_credits1);
					sender.sendMessage(Translation.bag_credits2);
					sender.sendMessage(Translation.bag_credits3);

				}
				if(args[0].equalsIgnoreCase("resource"))
				{
					if(sender.hasPermission(new Permission("bag.resource", PermissionDefault.TRUE)))
					{
						if(sender instanceof Player)
						{
							((Player)sender).setResourcePack("https://www.dropbox.com/s/dc2bpx4w0loavuo/Bags2.zip?dl=1");
							
						}
						else
						System.out.println(Translation.not_allowed);
					}
					
					

				}
				if(args[0].equalsIgnoreCase("give"))
				{
					if(sender.hasPermission(new Permission("bag.give", PermissionDefault.OP)))
					{
						if(args.length == 2)
						{
								if(args[1].equalsIgnoreCase("normal"))
									((Player)sender).getInventory().addItem(RecipeManager.getBag());
								if(args[1].equalsIgnoreCase("big"))
									((Player)sender).getInventory().addItem(RecipeManager.getBigBag());
								if(args[1].equalsIgnoreCase("craft"))
									((Player)sender).getInventory().addItem(RecipeManager.getCraftingBag());
								if(args[1].equalsIgnoreCase("ender"))
									((Player)sender).getInventory().addItem(RecipeManager.getEnderBag());
								if(args[1].equalsIgnoreCase("enchant"))
									((Player)sender).getInventory().addItem(RecipeManager.getEnchantmentBag());
								if(args[1].equalsIgnoreCase("anvil"))
									((Player)sender).getInventory().addItem(RecipeManager.getAnvilBag());
								
							
							
							
							
							
						}
						else
						sender.sendMessage(Translation.bag_give_syntax);
					}
					else
					sender.sendMessage(Bags.not_allowed);
				}
				
				
				
				
			}
			else
			{
				sender.sendMessage(Translation.bag_cmdhelp1);
				sender.sendMessage(Translation.bag_cmdhelp2);
				sender.sendMessage(Translation.bag_cmdhelp3);
			}
			
		}
		return false;
	}
}
