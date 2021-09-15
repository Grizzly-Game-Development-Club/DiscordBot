package Bot.Commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {

    boolean isSlashCommand;

    TextChannel channel;
    SlashCommandEvent slashCommand;

    Message message;

    public Command(MessageReceivedEvent e) {
        this.isSlashCommand = false;
        this.message = e.getMessage();
        this.channel = e.getTextChannel();

        run();
    }

    public Command(SlashCommandEvent slashCommand) {
        this.isSlashCommand = true;
        this.slashCommand = slashCommand;

        run();
    }

    public abstract void run();

    public void sendMessage(String msg) {
        if (isSlashCommand) {
            slashCommand.reply(msg).queue();
        } else {
            channel.sendMessage(msg).queue();
        }
    }

    public void sendMessage(MessageEmbed embed) {
        if (isSlashCommand) {
            slashCommand.replyEmbeds(embed).queue();
        } else {
            channel.sendMessageEmbeds(embed).queue();
        }
    }

}
