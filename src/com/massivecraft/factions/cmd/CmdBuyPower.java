package com.massivecraft.factions.cmd;

import com.massivecraft.factions.integration.Econ;
//MODIF


public class CmdBuyPower extends FCommand
{
	
	public CmdBuyPower()
	{
		super();
		this.aliases.add("buy");
		this.aliases.add("buypower");
		
		this.optionalArgs.put("quantite", "1");
		
		this.setHelpShort("buy max power - 1 max power pour 100 po");
		
		senderMustBePlayer = true;
		senderMustBeMember = false;
		senderMustBeModerator = false;
		senderMustBeAdmin = false;
	}
	
	@Override
	public void perform()
	{
		
		int quantite = this.argAsInt(0, 1);
		if (fme == null) {
			
			return;
		}
		if(quantite<1) { return;}
		
		if ( ! Econ.modifyMoney(fme, -100*quantite, " pour acheter "+quantite+" puissance max", "pour l'achat de "+quantite+" puissance max")) return;
		
		fme.alterPowerMax(quantite);
		sendMessage(fme.getNameAndTitle(fme)+" - +"+quantite+" MaxPower!");
		sendMessage(fme.getNameAndTitle(fme)+" - Power / Maxpower: "+fme.getPowerRounded()+" / "+fme.getPowerMaxRounded());

	}
	
}
