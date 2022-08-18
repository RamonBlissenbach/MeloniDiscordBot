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

    private static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault("")
                .setActivity(Activity.playing("Meloncity"))
                .build();

        jda.getEventManager().register(new SlashCommandInteractionListner());
        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(Commands.slash("invite", "Lade den Bota auf deinen Discord Server ein."));
        commands.addCommands(Commands.slash("info", "Informationen über den Bot."));
        commands.addCommands(Commands.slash("wert", "Gucke wie viel Wert ein Item hat.").addOption(OptionType.STRING, "itemname", "Gebe den Item Namen an von dem du den Preis wissen möchtest.", true));

        commands.queue();

    }

    public static JDA getJda() {
        return jda;
    }
}
