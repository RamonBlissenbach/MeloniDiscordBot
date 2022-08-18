package eu.ramonblissenbach.melonidiscordbot.listeners;

import eu.ramonblissenbach.melonidiscordbot.MeloniDiscordBot;
import eu.ramonblissenbach.melonidiscordbot.utils.ItemReader;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class SlashCommandInteractionListner extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getInteraction().getCommandString().startsWith("/wert")) {
            String item = event.getInteraction().getOption("itemname").getAsString();
            ItemReader itemReader = new ItemReader(item);

            MessageEmbed embed = new EmbedBuilder()
                    .setTitle(itemReader.getItemName())
                    .setThumbnail(itemReader.getItemImage())
                    .addField("Preis", itemReader.getItemPrice(), false)
                    .setColor(Color.BLUE)
                    .setFooter("Meloni von SyntaxxError", MeloniDiscordBot.getJda().getSelfUser().getAvatarUrl())
                    .build();

            event.reply(" ").addEmbeds(embed).setEphemeral(true).queue();
        }
        if (event.getInteraction().getCommandString().startsWith("/invite")) {
            MessageEmbed embed = new EmbedBuilder()
                    .setTitle("Einladen")
                    .setThumbnail(MeloniDiscordBot.getJda().getSelfUser().getAvatarUrl())
                    .setDescription("Kicke auf den Knopf um den Bot einzuladen.")
                    .setColor(Color.BLUE)
                    .setFooter("Meloni von SyntaxxError", MeloniDiscordBot.getJda().getSelfUser().getAvatarUrl())
                    .build();

            event.reply(" ").addEmbeds(embed).addActionRow(
                    Button.link("https://discord.com/api/oauth2/authorize?client_id=1004502976242667561&permissions=8&scope=bot%20applications.commands", "Einladen")
            ).queue();
        }

        if (event.getInteraction().getCommandString().startsWith("/info")) {
            MessageEmbed embed = new EmbedBuilder()
                    .setTitle("Informationen")
                    .setThumbnail(MeloniDiscordBot.getJda().getSelfUser().getAvatarUrl())
                    .setDescription("Hier sind ein paar Informationen zu mir.")
                    .addField("Was ist die Idee?", "Die Idee von Meloni ist es, die Website (https://melonwert.de/) auf Discord zu übertragen.", false)
                    .addField("Wer Steckt dahinter?", "Hinter Meloni steckt der Entwickler SyntaxxError der auch schon andere Bots programmiert hat.", false)
                    .addField("Woher kommen die Daten/Preise?", "Die Preise kommen direkt von der Melonwert Website (https://melonwert.de/) und werden auch live übertragen.", false)
                    .setColor(Color.BLUE)
                    .setFooter("Meloni von SyntaxxError", MeloniDiscordBot.getJda().getSelfUser().getAvatarUrl())
                    .build();

            event.reply(" ").addEmbeds(embed).queue();
        }
    }
}
