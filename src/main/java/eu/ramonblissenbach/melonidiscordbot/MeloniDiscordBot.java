package eu.ramonblissenbach.melonidiscordbot;

import eu.ramonblissenbach.melonidiscordbot.listeners.SlashCommandInteractionListner;
import eu.ramonblissenbach.melonidiscordbot.utils.ItemReader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import javax.security.auth.login.LoginException;

public class MeloniDiscordBot {

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault("")
                .setActivity(Activity.playing("Meloncity"))
                .addEventListeners(new SlashCommandInteractionListner())
                .build();

        jda.updateCommands()
                .addCommands(Commands.slash("invite", "Lade den Bota auf deinen Discord Server ein."))
                .addCommands(Commands.slash("info", "Informationen über den Bot."))
                .addCommands(Commands.slash("wert", "Gucke wie viel Wert ein Item hat.")
                        .addOption(OptionType.STRING, "itemname", "Gebe den Item Namen an von dem du den Preis wissen möchtest.", true))
            .queue();

    }

}
