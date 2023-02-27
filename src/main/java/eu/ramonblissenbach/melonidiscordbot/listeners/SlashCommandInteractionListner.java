package eu.ramonblissenbach.melonidiscordbot.listeners;

import eu.ramonblissenbach.melonidiscordbot.utils.ItemReader;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class SlashCommandInteractionListner extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        String commandName = event.getName();

        switch (commandName){
            case "wert" -> {
                String item = event.getOption("itemname").getAsString();
                ItemReader itemReader = new ItemReader(item);

                event.replyEmbeds(new EmbedBuilder()
                        .setTitle(itemReader.getItemName())
                        .setThumbnail(itemReader.getItemImage())
                        .addField("Preis", itemReader.getItemPrice(), false)
                        .setColor(Color.BLUE)
                        .setFooter("Meloni von SyntaxxError", event.getJDA().getSelfUser().getAvatarUrl())
                        .build()
                ).setEphemeral(true).queue();
            }
            case "invite" -> {
                event.replyEmbeds(new EmbedBuilder()
                        .setTitle("Einladen")
                        .setThumbnail(event.getJDA().getSelfUser().getAvatarUrl())
                        .setDescription("Kicke auf den Knopf um den Bot einzuladen.")
                        .setColor(Color.BLUE)
                        .setFooter("Meloni von SyntaxxError", event.getJDA().getSelfUser().getAvatarUrl())
                        .build()
                ).addActionRow(
                        Button.link("https://discord.com/api/oauth2/authorize?client_id=1004502976242667561&permissions=8&scope=bot%20applications.commands", "Einladen")
                ).queue();
            }
            case "info" -> {
                event.replyEmbeds(new EmbedBuilder()
                        .setTitle("Informationen")
                        .setThumbnail(event.getJDA().getSelfUser().getAvatarUrl())
                        .setDescription("Hier sind ein paar Informationen zu mir.")
                        .addField("Was ist die Idee?", "Die Idee von Meloni ist es, die Website (https://melonwert.de/) auf Discord zu übertragen.", false)
                        .addField("Wer Steckt dahinter?", "Hinter Meloni steckt der Entwickler SyntaxxError der auch schon andere Bots programmiert hat.", false)
                        .addField("Woher kommen die Daten/Preise?", "Die Preise kommen direkt von der Melonwert Website (https://melonwert.de/) und werden auch live übertragen.", false)
                        .setColor(Color.BLUE)
                        .setFooter("Meloni von SyntaxxError", event.getJDA().getSelfUser().getAvatarUrl())
                        .build()
                ).queue();
            }
        }
    }
}
