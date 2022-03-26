package me.logger.commands;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.logger.main.main;

public class LoggerCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String error = main.getPlugin().getConfig().getString("Logger.error");
		String nopermission = main.getPlugin().getConfig().getString("Logger.nopermission");
		if(sender.hasPermission("logger.admin")) {
			if(args.length >=2) {
				if(args[0].equalsIgnoreCase("locations")) {
					Player target = Bukkit.getPlayer(args[1]);
					UUID uuid = target.getUniqueId();
					
					String topborder = main.getPlugin().getConfig().getString("Logger.messages.topborder");
					String playername = main.getPlugin().getConfig().getString("Logger.messages.playername").replace("PLAYER", target.getName());
					String space1 = main.getPlugin().getConfig().getString("Logger.messages.space1");
					String lastlocs = main.getPlugin().getConfig().getString("Logger.locations.lastlocs");
					String bottomborder = main.getPlugin().getConfig().getString("Logger.locations.bottomborder");
					
					File file = new File("plugins/Logger/"+uuid, "locations.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					
					String lastT = cfg.getString("Last.loc.Time");
					String lastX = cfg.getString("Last.loc.X");
					String lastY = cfg.getString("Last.loc.Y");
					String lastZ = cfg.getString("Last.loc.Z");
					String lastW = cfg.getString("Last.loc.World");
					
					String secondlastT = cfg.getString("secondlast.loc.Time");
					String secondlastX = cfg.getString("secondlast.loc.X");
					String secondlastY = cfg.getString("secondlast.loc.Y");
					String secondlastZ = cfg.getString("secondlast.loc.Z");
					String secondlastW = cfg.getString("secondlast.loc.World");
					
					String thirdT = cfg.getString("third.loc.Time");
					String thirdX = cfg.getString("third.loc.X");
					String thirdY = cfg.getString("third.loc.Y");
					String thirdZ = cfg.getString("third.loc.Z");
					String thirdW = cfg.getString("third.loc.World");
					
					String fourthT = cfg.getString("fourth.loc.Time");
					String fourthX = cfg.getString("fourth.loc.X");
					String fourthY = cfg.getString("fourth.loc.Y");
					String fourthZ = cfg.getString("fourth.loc.Z");
					String fourthW = cfg.getString("fourth.loc.World");
					
					String fifthT = cfg.getString("fifth.loc.Time");
					String fifthX = cfg.getString("fifth.loc.X");
					String fifthY = cfg.getString("fifth.loc.Y");
					String fifthZ = cfg.getString("fifth.loc.Z");
					String fifthW = cfg.getString("fifth.loc.World");
					
					String sixthT = cfg.getString("sixth.loc.Time");
					String sixthX = cfg.getString("sixth.loc.X");
					String sixthY = cfg.getString("sixth.loc.Y");
					String sixthZ = cfg.getString("sixth.loc.Z");
					String sixthW = cfg.getString("sixth.loc.World");
					
					String seventhT = cfg.getString("seventh.loc.Time");
					String seventhX = cfg.getString("seventh.loc.X");
					String seventhY = cfg.getString("seventh.loc.Y");
					String seventhZ = cfg.getString("seventh.loc.Z");
					String seventhW = cfg.getString("seventh.loc.World");
					
					String eighthT = cfg.getString("eighth.loc.Time");
					String eighthX = cfg.getString("eighth.loc.X");
					String eighthY = cfg.getString("eighth.loc.Y");
					String eighthZ = cfg.getString("eighth.loc.Z");
					String eighthW = cfg.getString("eighth.loc.World");
					
					String ninthT = cfg.getString("ninth.loc.Time");
					String ninthX = cfg.getString("ninth.loc.X");
					String ninthY = cfg.getString("ninth.loc.Y");
					String ninthZ = cfg.getString("ninth.loc.Z");
					String ninthW = cfg.getString("ninth.loc.World");
					
					String tenthT = cfg.getString("tenth.loc.Time");
					String tenthX = cfg.getString("tenth.loc.X");
					String tenthY = cfg.getString("tenth.loc.Y");
					String tenthZ = cfg.getString("tenth.loc.Z");
					String tenthW = cfg.getString("tenth.loc.World");
					
					String eleventhT = cfg.getString("eleventh.loc.Time");
					String eleventhX = cfg.getString("eleventh.loc.X");
					String eleventhY = cfg.getString("eleventh.loc.Y");
					String eleventhZ = cfg.getString("eleventh.loc.Z");
					String eleventhW = cfg.getString("eleventh.loc.World");
					
					String twelfthT = cfg.getString("twelfth.loc.Time");
					String twelfthX = cfg.getString("twelfth.loc.X");
					String twelfthY = cfg.getString("twelfth.loc.Y");
					String twelfthZ = cfg.getString("twelfth.loc.Z");
					String twelfthW = cfg.getString("twelfth.loc.World");
					
					String thirteenthT = cfg.getString("twelfth.loc.Time");
					String thirteenthX = cfg.getString("twelfth.loc.X");
					String thirteenthY = cfg.getString("twelfth.loc.Y");
					String thirteenthZ = cfg.getString("twelfth.loc.Z");
					String thirteenthW = cfg.getString("twelfth.loc.World");
					
					String fourteenthT = cfg.getString("thirteenth.loc.Time");
					String fourteenthX = cfg.getString("thirteenth.loc.X");
					String fourteenthY = cfg.getString("thirteenth.loc.Y");
					String fourteenthZ = cfg.getString("thirteenth.loc.Z");
					String fourteenthW = cfg.getString("thirteenth.loc.World");
					
					String fifteenthT = cfg.getString("fifteenth.loc.Time");
					String fifteenthX = cfg.getString("fifteenth.loc.X");
					String fifteenthY = cfg.getString("fifteenth.loc.Y");
					String fifteenthZ = cfg.getString("fifteenth.loc.Z");
					String fifteenthW = cfg.getString("fifteenth.loc.World");
					
					sender.sendMessage(topborder);
					sender.sendMessage(playername);
					sender.sendMessage(space1);
					sender.sendMessage(lastlocs);
					sender.sendMessage("§l1§r) "+lastT);
					sender.sendMessage(lastW+lastX+lastY+lastZ);
					if(secondlastT != null) {
						sender.sendMessage("§l2§r) "+secondlastT);
						sender.sendMessage(secondlastW+secondlastX+secondlastY+secondlastZ);
						if(thirdT != null) {
							sender.sendMessage("§l3§r) "+thirdT);
							sender.sendMessage(thirdW+thirdX+thirdY+thirdZ);
							if(fourthT != null) {
								sender.sendMessage("§l4§r) "+fourthT);
								sender.sendMessage(fourthW+fourthX+fourthY+fourthZ);
								if(fifthT != null) {
									sender.sendMessage("§l5§r) "+fifthT);
									sender.sendMessage(fifthW+fifthX+fifthY+fifthZ);
									if(sixthT != null) {
										sender.sendMessage("§l6§r) "+sixthT);
										sender.sendMessage(sixthW+sixthX+sixthY+sixthZ);
										if(seventhT != null) {
											sender.sendMessage("§l7§r) "+seventhT);
											sender.sendMessage(seventhW+seventhX+seventhY+seventhZ);
											if(eighthT != null) {
												sender.sendMessage("§l8§r) "+eighthT);
												sender.sendMessage(eighthW+eighthX+eighthY+eighthZ);
												if(ninthT != null) {
													sender.sendMessage("§l9§r) "+ninthT);
													sender.sendMessage(ninthW+ninthX+ninthY+ninthZ);
													if(tenthT != null) {
														sender.sendMessage("§l10§r) "+tenthT);
														sender.sendMessage(tenthW+tenthX+tenthY+tenthZ);
														if(eleventhT != null) {
															sender.sendMessage("§l11§r) "+eleventhT);
															sender.sendMessage(eleventhW+eleventhX+eleventhY+eleventhZ);
															if(twelfthT != null) {
																sender.sendMessage("§l12§r) "+twelfthT);
																sender.sendMessage(twelfthW+twelfthX+twelfthY+twelfthZ);
																if(thirteenthT != null) {
																	sender.sendMessage("§l13§r) "+thirteenthT);
																	sender.sendMessage(thirteenthW+thirteenthX+thirteenthY+thirteenthZ);
																	if(fourteenthT != null) {
																		sender.sendMessage("§l14§r) "+fourteenthT);
																		sender.sendMessage(fourteenthW+fourteenthX+fourteenthY+fourteenthZ);
																		if(fifteenthT != null) {
																			sender.sendMessage("§l15§r) "+fifteenthT);
																			sender.sendMessage(fifteenthW+fifteenthX+fifteenthY+fifteenthZ);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
								
						}
					}	
					sender.sendMessage(bottomborder);
					
				}else if(args[0].equalsIgnoreCase("messages")) {
					Player target = Bukkit.getPlayer(args[1]);
					UUID uuid = target.getUniqueId();
					
					String topborder = main.getPlugin().getConfig().getString("Logger.messages.topborder");
					String playername = main.getPlugin().getConfig().getString("Logger.messages.playername").replace("PLAYER", target.getName());
					String space1 = main.getPlugin().getConfig().getString("Logger.messages.space1");
					String Lastmessages = main.getPlugin().getConfig().getString("Logger.messages.Lastmessages");
					String space2 = main.getPlugin().getConfig().getString("Logger.messages.space2");
					String lastcommands = main.getPlugin().getConfig().getString("Logger.messages.lastcommands");
					String bottomborder = main.getPlugin().getConfig().getString("Logger.messages.bottomborder");
					
					File file = new File("plugins/Logger/"+uuid, "messages.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					String last = cfg.getString("Message.last");
					String second = cfg.getString("Message.second");		
					String third = cfg.getString("Message.third");		
					String fourth = cfg.getString("Message.fourth");		
					String fifth = cfg.getString("Message.fifth");		
					String sixth = cfg.getString("Message.sixth");		
					String seventh = cfg.getString("Message.seventh");		
					String eighth = cfg.getString("Message.eighth");		
					String ninth = cfg.getString("Message.ninth");		
					String tenth = cfg.getString("Message.tenth");		
					String eleventh = cfg.getString("Message.eleventh");		
					String twelfth = cfg.getString("Message.twelfth");	
					String thirteenth = cfg.getString("Message.thirteenth");	
					String fourteenth = cfg.getString("Message.fourteenth");
					String fifteenth = cfg.getString("Message.fifteenth");
					
					String lastc = cfg.getString("Command.last");
					String secondc = cfg.getString("Command.second");		
					String thirdc = cfg.getString("Command.third");		
					String fourthc = cfg.getString("Command.fourth");		
					String fifthc = cfg.getString("Command.fifth");		
					String sixthc = cfg.getString("Command.sixth");		
					String seventhc = cfg.getString("Command.seventh");		
					String eighthc = cfg.getString("Command.eighth");		
					String ninthc = cfg.getString("Command.ninth");		
					String tenthc = cfg.getString("Command.tenth");		
					String eleventhc = cfg.getString("Command.eleventh");		
					String twelfthc = cfg.getString("Command.twelfth");	
					String thirteenthc = cfg.getString("Command.thirteenth");	
					String fourteenthc = cfg.getString("Command.fourteenth");
					String fifteenthc = cfg.getString("Command.fifteenth");
					
					sender.sendMessage(topborder);
					sender.sendMessage(playername);
					sender.sendMessage(space1);
					sender.sendMessage(Lastmessages);
					sender.sendMessage("§l1)"+last);
					if(second != null) {
						sender.sendMessage("§l2§r) "+second);
						if(third != null) {
							sender.sendMessage("§l3§r) "+third);
							if(fourth != null) {
								sender.sendMessage("§l4§r) "+fourth);
								if(fifth != null) {
									sender.sendMessage("§l5§r) "+fifth);
									if(sixth != null) {
										sender.sendMessage("§l6§r) "+sixth);
										if(seventh != null) {
											sender.sendMessage("§l7§r) "+seventh);
											if(eighth != null) {
												sender.sendMessage("§l8§r) "+eighth);
												if(ninth != null) {
													sender.sendMessage("§l9§r) "+ninth);
													if(tenth != null) {
														sender.sendMessage("§l10§r) "+tenth);
														if(eleventh != null) {
															sender.sendMessage("§l11§r) "+eleventh);
															if(twelfth != null) {
																sender.sendMessage("§l12§r) "+twelfth);
																if(thirteenth != null) {
																	sender.sendMessage("§l13§r) "+thirteenth);
																	if(fourteenth != null) {
																		sender.sendMessage("§l14§r) "+fourteenth);
																		if(fifteenth != null) {
																			sender.sendMessage("§l15§r) "+fifteenth);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
								
						}
					}	
					sender.sendMessage(space2);
					sender.sendMessage(lastcommands);
					sender.sendMessage("§l1)"+lastc);
					if(secondc != null) {
						sender.sendMessage("§l2§r) "+secondc);
						if(thirdc != null) {
							sender.sendMessage("§l3§r) "+thirdc);
							if(fourthc != null) {
								sender.sendMessage("§l4§r) "+fourthc);
								if(fifthc != null) {
									sender.sendMessage("§l5§r) "+fifthc);
									if(sixthc != null) {
										sender.sendMessage("§l6§r) "+sixthc);
										if(seventhc != null) {
											sender.sendMessage("§l7§r) "+seventhc);
											if(eighthc != null) {
												sender.sendMessage("§l8§r) "+eighthc);
												if(ninthc != null) {
													sender.sendMessage("§l9§r) "+ninthc);
													if(tenthc != null) {
														sender.sendMessage("§l10§r) "+tenthc);
														if(eleventhc != null) {
															sender.sendMessage("§l11§r) "+eleventhc);
															if(twelfthc != null) {
																sender.sendMessage("§l12§r) "+twelfthc);
																if(thirteenthc != null) {
																	sender.sendMessage("§l13§r) "+thirteenthc);
																	if(fourteenthc != null) {
																		sender.sendMessage("§l14§r) "+fourteenthc);
																		if(fifteenthc != null) {
																			sender.sendMessage("§l15§r) "+fifteenthc);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
								
						}
					}	
					sender.sendMessage(bottomborder);
				} else if(args[0].equalsIgnoreCase("onlinetime")) {
					Player target = Bukkit.getPlayer(args[1]);
					UUID uuid = target.getUniqueId();
					
					String topborder = main.getPlugin().getConfig().getString("Logger.onlinetime.topborder");
					String playername = main.getPlugin().getConfig().getString("Logger.onlinetime.playername").replace("PLAYER", target.getName());
					String space1 = main.getPlugin().getConfig().getString("Logger.onlinetime.space1");
					String playtime = main.getPlugin().getConfig().getString("Logger.onlinetime.playtime");
					String space2 = main.getPlugin().getConfig().getString("Logger.onlinetime.space2");
					String firstjoin = main.getPlugin().getConfig().getString("Logger.onlinetime.firstjoin");
					String space3 = main.getPlugin().getConfig().getString("Logger.onlinetime.space3");
					String lastjoins = main.getPlugin().getConfig().getString("Logger.onlinetime.lastjoins");
					String bottomborder = main.getPlugin().getConfig().getString("Logger.onlinetime.bottomborder");
					
					File file = new File("plugins/Logger/"+uuid, "time.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					int hours = cfg.getInt("Time.hours");
					int minutes = cfg.getInt("Time.minutes");
					String first = cfg.getString("First.Join");
					String last = cfg.getString("Last.Join");
					String second = cfg.getString("secondlast.Join");		
					String third = cfg.getString("third.Join");		
					String fourth = cfg.getString("fourth.Join");		
					String fifth = cfg.getString("fifth.Join");		
					String sixth = cfg.getString("sixth.Join");		
					String seventh = cfg.getString("seventh.Join");		
					String eighth = cfg.getString("eighth.Join");		
					String ninth = cfg.getString("ninth.Join");		
					String tenth = cfg.getString("tenth.Join");		
					String eleventh = cfg.getString("eleventh.Join");		
					String twelfth = cfg.getString("twelfth.Join");	
					String thirteenth = cfg.getString("thirteenth.Join");	
					String fourteenth = cfg.getString("fourteenth.Join");
					String fifteenth = cfg.getString("fifteenth.Join");
					
					String lastl = cfg.getString("Last.Leave");		
					String secondl = cfg.getString("secondlast.Leave");		
					String thirdl = cfg.getString("third.Leave");		
					String fourthl = cfg.getString("fourth.Leave");		
					String fifthl = cfg.getString("fifth.Leave");		
					String sixthl = cfg.getString("sixth.Leave");		
					String seventhl = cfg.getString("seventh.Leave");		
					String eighthl = cfg.getString("eighth.Leave");		
					String ninthl = cfg.getString("ninth.Leave");		
					String tenthl = cfg.getString("tenth.Leave");		
					String eleventhl = cfg.getString("eleventh.Leave");		
					String twelfthl = cfg.getString("twelfth.Leave");	
					String thirteenthl = cfg.getString("thirteenth.Leave");	
					String fourteenthl = cfg.getString("fourteenth.Leave");
					
					sender.sendMessage(topborder);
					sender.sendMessage(playername);
					sender.sendMessage(space1);
					sender.sendMessage(playtime);
					sender.sendMessage(hours+"Hour(s) and "+minutes+"Minute(s)");
					sender.sendMessage(space2);
					sender.sendMessage(firstjoin);
					sender.sendMessage(first+"");
					sender.sendMessage(space3);
					sender.sendMessage(lastjoins);
					sender.sendMessage("§l1) "+last);
					if(second != null) {
						sender.sendMessage("§l2§r) "+second+" - "+lastl);
						if(third != null) {
							sender.sendMessage("§l3§r) "+third+" - "+secondl);
							if(fourth != null) {
								sender.sendMessage("§l4§r) "+fourth+" - "+thirdl);
								if(fifth != null) {
									sender.sendMessage("§l5§r) "+fifth+" - "+fourthl);
									if(sixth != null) {
										sender.sendMessage("§l6§r) "+sixth+" - "+fifthl);
										if(seventh != null) {
											sender.sendMessage("§l7§r) "+seventh+" - "+sixthl);
											if(eighth != null) {
												sender.sendMessage("§l8§r) "+eighth+" - "+seventhl);
												if(ninth != null) {
													sender.sendMessage("§l9§r) "+ninth+" - "+eighthl);
													if(tenth != null) {
														sender.sendMessage("§l10§r) "+tenth+" - "+ninthl);
														if(eleventh != null) {
															sender.sendMessage("§l11§r) "+eleventh+" - "+tenthl);
															if(twelfth != null) {
																sender.sendMessage("§l12§r) "+twelfth+" - "+eleventhl);
																if(thirteenth != null) {
																	sender.sendMessage("§l13§r) "+thirteenth+" - "+twelfthl);
																	if(fourteenth != null) {
																		sender.sendMessage("§l14§r) "+fourteenth+" - "+thirteenthl);
																		if(fifteenth != null) {
																			sender.sendMessage("§l15§r) "+fifteenth+" - "+fourteenthl);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
								
						}
					}	
					sender.sendMessage(bottomborder);
				}else {
					sender.sendMessage(error);
				}
			}else {
				sender.sendMessage(error);
			}
		}else {
			sender.sendMessage(nopermission);
		}
		return true;
	}

}
