package Bot;

import Bot.Commands.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {

    final String commandSign = "!";

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        //Ignore any message sent by a bot.
        if (!e.getAuthor().isBot()) {
            //Ignore empty messages.
            if (!e.getMessage().getContentRaw().equals("")) {
                if (e.getMessage().getContentRaw().toLowerCase().startsWith(commandSign)) {
                    //Format the command
                    String commandName = e.getMessage().getContentRaw().toLowerCase().split("\\s+")[0];
                    commandName = commandName.substring(commandSign.length());
                    switch (commandName) {
                        case "hello" -> new HelloWorld(e.getTextChannel());
                        case "ping" -> new Ping(e.getTextChannel());
                    }
                }
            }
        }
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent slashCommand) {
        switch (slashCommand.getName()) {
            case "hello" -> new HelloWorld(slashCommand);
            case "ping" -> new Ping(slashCommand);
        }
    }
}
